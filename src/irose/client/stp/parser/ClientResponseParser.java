package irose.client.stp.parser;

import irose.util.ResponseParser;

public class ClientResponseParser extends ResponseParser
{
	private static ClientResponseParser instance;
	
	protected ClientResponseParser()
	{
	}
	
	public static ClientResponseParser getInstance()
	{
		if(instance == null)
		{
			instance = new ClientResponseParser();
		}
		
		return instance;
	}
}
