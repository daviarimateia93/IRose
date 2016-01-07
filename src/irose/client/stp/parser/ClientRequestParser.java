package irose.client.stp.parser;

import irose.util.RequestParser;

public class ClientRequestParser extends RequestParser
{
	private static ClientRequestParser instance;
	
	protected ClientRequestParser()
	{
	}
	
	public static ClientRequestParser getInstance()
	{
		if(instance == null)
		{
			instance = new ClientRequestParser();
		}
		
		return instance;
	}
}