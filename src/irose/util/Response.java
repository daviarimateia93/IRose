package irose.util;

import me.gerenciar.sjson.gateway.Gateway;

public class Response extends Gateway
{
	private static transient final long serialVersionUID = -8833798379580814828L;
	
	public static enum Status
	{
		
		OK, ERROR
	}
	
	private Status status;
	private Object payload;
	
	public Response()
	{
	}
	
	public Response(Status status, Object payload)
	{
		this.status = status;
		this.payload = payload;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public Object getPayload()
	{
		return payload;
	}
}
