package irose.server.stp.parser;

import irose.util.ResponseParser;

public class ServerResponseParser extends ResponseParser
{
	private static ServerResponseParser instance;
	
	protected ServerResponseParser()
	{
	}
	
	public static ServerResponseParser getInstance()
	{
		if(instance == null)
		{
			instance = new ServerResponseParser();
		}
		
		return instance;
	}
}
