package irose.server;

import irose.server.stp.parser.ServerAccountParser;
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
		ParserManager.getInstance().add(new ServerAccountParser());
		
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
}
