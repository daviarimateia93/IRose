package irose.client;

import irose.client.stp.parser.ClientAccountParser;
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
		ParserManager.getInstance().add(new ClientAccountParser());
		
		peer = new Peer()
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
}
