package irose.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Request extends BaseEntity
{
	private static transient final long serialVersionUID = 6277710972013771070L;
	
	private String id;
	private String requestClassName;
	private String requestMethodName;
	private Object[] requestParams;
	private String[] requestParamsClassNames;
	
	public Request()
	{
	
	}
	
	public Request(String requestClassName, String requestMethodName, Object... requestParams)
	{
		this.id = UUID.randomUUID().toString();
		this.requestClassName = requestClassName;
		this.requestMethodName = requestMethodName;
		this.requestParams = requestParams;
		
		List<String> requestParamClassNames = new ArrayList<>();
		
		for(Object requestParam : requestParams)
		{
			requestParamClassNames.add(requestParam.getClass().getName());
		}
		
		this.requestParamsClassNames = requestParamClassNames.toArray(new String[requestParamClassNames.size()]);
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getRequestClassName()
	{
		return requestClassName;
	}
	
	public String getRequestMethodName()
	{
		return requestMethodName;
	}
	
	public Object[] getRequestParams()
	{
		return requestParams;
	}
	
	public String[] getRequestParamsClassNames()
	{
		return requestParamsClassNames;
	}
}
