package irose.util;

import java.util.ArrayList;
import java.util.List;

public class Request extends BaseEntity
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
	
	/*
	@Override
	public <T extends BaseEntity> T toObject(String source)
	{
		T object = super.toObject(source);
		
		if(object instanceof Request)
		{
			return ((Request) object).className.equals(className) ? object : null;
		}
		
		return null;
	}*/
}
