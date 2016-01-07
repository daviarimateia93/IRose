package irose.server.stp.parser;

import irose.util.RequestParser;

public class ServerRequestParser extends RequestParser
{
	private static ServerRequestParser instance;
	
	protected ServerRequestParser()
	{
	}
	
	public static ServerRequestParser getInstance()
	{
		if(instance == null)
		{
			instance = new ServerRequestParser();
		}
		
		return instance;
	}
}
