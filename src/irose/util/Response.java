package irose.util;

public class Response extends BaseEntity
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
	
	/*
	@Override
	public <T extends BaseEntity> T toObject(String source)
	{
		T object = super.toObject(source);
		
		if(object instanceof Response)
		{
			return ((Response) object).className.equals(className) ? object : null;
		}
		
		return null;
	}*/
}
