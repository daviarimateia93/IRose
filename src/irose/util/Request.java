package irose.util;

import java.util.ArrayList;
import java.util.List;

import me.gerenciar.sjson.gateway.Gateway;

public class Request extends Gateway
{
	private static transient final long serialVersionUID = 6277710972013771070L;
	
	private String requestClassName;
	private String requestMethodName;
	private Object[] requestParams;
	private String[] requestParamsClassNames;
	
	public Request()
	{
	}
	
	public Request(String requestClassName, String requestMethodName, Object... requestParams)
	{
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
