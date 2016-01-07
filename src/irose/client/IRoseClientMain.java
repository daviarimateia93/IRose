package irose.client;

import me.gerenciar.stp.system.STPException;

public class IRoseClientMain
{
	public static void main(String[] args) throws STPException
	{
		String host = "localhost";
		int port = 8888;
		
		if(args != null)
		{
			if(args.length == 2)
			{
				host = args[0];
				port = Integer.valueOf(args[1]);
			}
		}
		
		IRoseClient.getInstance().start(host, port);
	}
}
