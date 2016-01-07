package irose.server;

import irose.entity.Account;
import irose.server.service.AccountService;
import irose.server.stp.parser.ServerRequestParser;
import irose.server.stp.parser.ServerResponseParser;
import irose.util.Request;
import irose.util.Response;
import irose.util.ServiceManager;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.gateway.Server;
import me.gerenciar.stp.parser.ParserManager;
import me.gerenciar.stp.system.STPException;

public class IRoseServer
{
	private static IRoseServer instance;
	private boolean started;
	private Server server;
	
	private IRoseServer()
	{
		ParserManager.getInstance().add(ServerRequestParser.getInstance());
		ParserManager.getInstance().add(ServerResponseParser.getInstance());
		
		server = new Server()
		{
			@Override
			protected void onStart()
			{
				started = true;
			}
			
			@Override
			protected void onEnd()
			{
				started = false;
			}
			
			@Override
			protected void onPeerStart(Peer peer)
			{
			}
			
			@Override
			protected void onPeerEnd(Peer peer)
			{
				Account account = ServiceManager.get(AccountService.class).getByPeer(peer);
				
				if(account != null)
				{
					ServiceManager.get(AccountService.class).logout(account.getId(), peer);
				}
			}
		};
	}
	
	public static IRoseServer getInstance()
	{
		if(instance == null)
		{
			instance = new IRoseServer();
		}
		
		return instance;
	}
	
	public boolean isStarted()
	{
		return started;
	}
	
	void start(int port) throws STPException
	{
		if(!started)
		{
			server.start(port);
		}
	}
	
	void end() throws STPException
	{
		if(started)
		{
			server.end();
		}
	}
	
	public void write(Peer peer, Request request)
	{
		ServerRequestParser.getInstance().write(peer, request);
	}
	
	public void write(Peer peer, Response response)
	{
		ServerResponseParser.getInstance().write(peer, response);
	}
}
