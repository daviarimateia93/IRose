package irose.server;

import me.gerenciar.stp.system.STPException;

public class IRoseServerMain
{
	public static void main(String[] args) throws STPException
	{
		int port = 8888;
		
		if(args != null)
		{
			if(args.length == 1)
			{
				port = Integer.valueOf(args[0]);
			}
		}
		
		IRoseServer.getInstance().start(port);
	}
}
