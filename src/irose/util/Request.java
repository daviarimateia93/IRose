package irose.util;

import java.util.ArrayList;
import java.util.List;

import me.gerenciar.sjson.gateway.Gateway;

public class Request extends Gateway
{
	private static final long serialVersionUID = 6277710972013771070L;
	
	private String className;
	private String methodName;
	private Object[] params;
	private String[] paramsClassNames;
	
	public Request()
	{
	}
	
	public Request(String className, String methodName, Object... params)
	{
		this.className = className;
		this.methodName = methodName;
		this.params = params;
		
		List<String> paramClassNames = new ArrayList<>();
		
		for(Object param : params)
		{
			paramClassNames.add(param.getClass().getName());
		}
		
		this.paramsClassNames = paramClassNames.toArray(new String[paramClassNames.size()]);
	}
	
	public String getClassName()
	{
		return className;
	}
	
	public String getMethodName()
	{
		return methodName;
	}
	
	public Object[] getParams()
	{
		return params;
	}
	
	public String[] getParamsClassNames()
	{
		return paramsClassNames;
	}
}
