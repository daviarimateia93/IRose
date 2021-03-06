package irose.server.stp.parser;

import irose.entity.Account;
import irose.server.service.AccountService;
import irose.util.BaseParser;
import irose.util.ServiceManager;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.gateway.Server;
import me.gerenciar.stp.parser.ParserServerKnown;

public class ServerParser extends BaseParser implements ParserServerKnown
{
	@Override
	public void onServerStart(Server server)
	{
	
	}
	
	@Override
	public void onServerEnd(Server server)
	{
	
	}
	
	@Override
	public void onPeerStart(Server server, Peer peer)
	{
	
	}
	
	@Override
	public void onPeerEnd(Server server, Peer peer)
	{
		Account account = ServiceManager.get(AccountService.class).getByPeer(peer);
		
		if(account != null)
		{
			ServiceManager.get(AccountService.class).logout(account.getId(), peer);
		}
	}
}
