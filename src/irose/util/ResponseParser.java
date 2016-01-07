package irose.util;

import java.nio.charset.Charset;

import me.gerenciar.stp.gateway.Peer;
import me.gerenciar.stp.message.Message;
import me.gerenciar.stp.message.Payload;
import me.gerenciar.stp.parser.Parser;
import me.gerenciar.stp.system.STPException;
import me.gerenciar.stp.system.STPLogger;

public class ResponseParser extends Parser
{
	@Override
	protected void read(Peer peer, Message message)
	{
		read(peer, getResponse(message));
	}
	
	@Override
	protected void written(Peer peer, Message message)
	{
		read(peer, getResponse(message));
	}
	
	protected void read(Peer peer, Response response)
	{
	}
	
	protected void written(Peer peer, Response response)
	{
	}
	
	public void write(Peer peer, Response response)
	{
		byte[] payloadContent = response.toString().getBytes();
		
		Payload payload = new Payload();
		payload.setContent(payloadContent);
		payload.setLength(payloadContent.length);
		payload.setPosition(0);
		payload.setTotalLength(payloadContent.length);
		
		Message message = new Message();
		message.setType(getType());
		message.setPayload(payload);
		
		try
		{
			peer.getTransporter().send(message);
		}
		catch(STPException exception)
		{
			STPLogger.exception(exception);
		}
	}
	
	private Response getResponse(Message message)
	{
		return new Response().toObject(new String(message.getPayload().getContent(), Charset.forName("UTF-8")));
	}
	
	@Override
	public String getType()
	{
		return "RESPONSE";
	}
}
