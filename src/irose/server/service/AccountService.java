package irose.server.service;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import irose.entity.Account;
import irose.repository.AccountRepository;
import irose.util.Constants;
import irose.util.RepositoryManager;
import irose.util.Requestable;
import irose.util.StringHelper;
import me.gerenciar.sdao.factory.DAOFactory.Runnable;
import me.gerenciar.sdao.factory.DAOFactory.Wrapper;
import me.gerenciar.stp.gateway.Peer;

public class AccountService
{
	private static Map<Peer, Account> connectedPeers = new HashMap<>();
	private static Map<Long, Account> connectedAccounts = new HashMap<>();
	
	@Requestable
	public Account login(String nickname, String password, Peer peer)
	{
		Wrapper<Account> wrapper = new Wrapper<>();
		
		RepositoryManager.getDAOFactory().transactional(new Runnable<Account>(wrapper)
		{
			@Override
			public void run() throws Exception
			{
				if(getByPeer(peer) == null)
				{
					wrapper.set(RepositoryManager.get(AccountRepository.class).selectByNicknameAndPassword(RepositoryManager.getDAOFactory().getConnection(), nickname, encryptPassword(password)));
					
					if(wrapper.get() != null)
					{
						wrapper.get().setLogged(true);
						
						RepositoryManager.get(AccountRepository.class).update(RepositoryManager.getDAOFactory().getConnection(), wrapper.get());
						
						connectedPeers.put(peer, wrapper.get());
						connectedAccounts.put(wrapper.get().getId(), wrapper.get());
					}
					
				}
			}
		});
		
		return wrapper.get();
	}
	
	@Requestable
	public void logout(Long accountId, Peer peer)
	{
		RepositoryManager.getDAOFactory().transactional(new Runnable<Object>()
		{
			@Override
			public void run() throws Exception
			{
				if(connectedAccounts.containsKey(accountId) && check(peer, accountId))
				{
					Account account = connectedAccounts.remove(accountId);
					account.setLogged(false);
					
					RepositoryManager.get(AccountRepository.class).update(RepositoryManager.getDAOFactory().getConnection(), account);
				}
			}
		});
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
	
	public String encryptPassword(String password)
	{
		try
		{
			MessageDigest sha512 = MessageDigest.getInstance(Constants.TEXT_ALGORITHM_SHA_512);
			
			return StringHelper.hex(sha512.digest(password.getBytes()));
		}
		catch(Exception exception)
		{
			return null;
		}
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
