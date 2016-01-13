package irose.util;

public class Response extends BaseEntity
{
	private static transient final long serialVersionUID = -8833798379580814828L;
	
	public static enum Status
	{
		OK, ERROR
	}
	
	private String requestId;
	private Status status;
	private Object payload;
	
	public Response()
	{
	
	}
	
	public Response(Request request, Status status, Object payload)
	{
		this.requestId = request.getId();
		this.status = status;
		this.payload = payload;
	}
	
	public String getRequestId()
	{
		return requestId;
	}
	
	public Status getStatus()
	{
		return status;
	}
	
	public Object getPayload()
	{
		return payload;
	}
	
	public boolean isFrom(Request request)
	{
		if(request == null)
		{
			return false;
		}
		
		return request.getId().equals(requestId);
	}
}
