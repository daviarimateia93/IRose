package irose.server.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import irose.entity.Account;
import irose.repository.AccountRepository;
import irose.util.RepositoryManager;
import irose.util.Requestable;
import me.gerenciar.stp.gateway.Peer;

public class AccountService
{
	private static Map<Peer, Account> connectedPeers = new HashMap<>();
	private static Map<Long, Account> connectedAccounts = new HashMap<>();
	
	@Requestable
	public Account login(String nickname, String password, Peer peer)
	{
		if(getByPeer(peer) == null)
		{
			Connection connection = RepositoryManager.newConnection();
			
			try
			{
				RepositoryManager.beginTransaction(connection);
				
				Account account = RepositoryManager.get(AccountRepository.class).selectByNicknameAndPassword(connection, nickname, password);
				
				if(account != null)
				{
					account.setLogged(true);
					
					RepositoryManager.get(AccountRepository.class).update(connection, account);
					
					connectedPeers.put(peer, account);
					connectedAccounts.put(account.getId(), account);
				}
				
				RepositoryManager.commit(connection);
				
				return account;
			}
			catch(Exception exception)
			{
				RepositoryManager.rollback(connection);
				
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	@Requestable
	public void logout(Long accountId, Peer peer)
	{
		if(connectedAccounts.containsKey(accountId) && check(peer, accountId))
		{
			Connection connection = RepositoryManager.newConnection();
			
			try
			{
				RepositoryManager.beginTransaction(connection);
				
				Account account = connectedAccounts.remove(accountId);
				account.setLogged(false);
				
				RepositoryManager.get(AccountRepository.class).update(connection, account);
				
				RepositoryManager.commit(connection);
			}
			catch(Exception exception)
			{
				RepositoryManager.rollback(connection);
			}
		}
	}
	
	@Requestable
	public Account getByPeer(Peer peer)
	{
		return connectedPeers.get(peer);
	}
	
	public Account getByAccountId(Long accountId)
	{
		return connectedAccounts.get(accountId);
	}
	
	private boolean check(Peer peer, Long accountId)
	{
		Account account = getByAccountId(accountId);
		
		if(account != null)
		{
			return account.getPeer().equals(peer);
		}
		else
		{
			return false;
		}
	}
}
