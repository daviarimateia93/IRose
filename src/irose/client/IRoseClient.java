package irose.client;

import irose.client.service.AccountService;
import irose.client.stp.parser.ClientRequestParser;
import irose.client.stp.parser.ClientResponseParser;
import irose.util.Request;
import irose.util.Response;
import irose.util.ServiceManager;
import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.parser.ParserManager;
import me.gerenciar.stp.system.STPException;

public class IRoseClient
{
	private static IRoseClient instance;
	private boolean started;
	private Peer peer;
	
	private IRoseClient()
	{
		ParserManager.getInstance().add(ClientRequestParser.getInstance());
		ParserManager.getInstance().add(ClientResponseParser.getInstance());
		
		peer = new Peer()
		{
			@Override
			protected void onStart()
			{
				started = true;
				
				ServiceManager.get(AccountService.class).login("teste", "123");
			}
			
			@Override
			protected void onEnd()
			{
				started = false;
			}
		};
	}
	
	public static IRoseClient getInstance()
	{
		if(instance == null)
		{
			instance = new IRoseClient();
		}
		
		return instance;
	}
	
	public boolean isStarted()
	{
		return started;
	}
	
	void start(String host, int port) throws STPException
	{
		if(!started)
		{
			peer.start(host, port);
		}
	}
	
	void end() throws STPException
	{
		if(started)
		{
			peer.end();
		}
	}
	
	public void write(Request request)
	{
		if(started)
		{
			ClientRequestParser.getInstance().write(peer, request);
		}
	}
	
	public void write(Response response)
	{
		if(started)
		{
			ClientResponseParser.getInstance().write(peer, response);
		}
	}
}
