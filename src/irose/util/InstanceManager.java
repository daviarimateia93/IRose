package irose.util;

import java.util.HashMap;
import java.util.Map;

public class InstanceManager
{
	protected static Map<String, Object> instances = new HashMap<>();
	
	protected InstanceManager()
	{
	
	}
	
	@SuppressWarnings("unchecked")
	protected static <T> T get(Class<T> type, String packageEndingName)
	{
		Object instance = null;
		
		if(type != null)
		{
			String name = type.getName();
			instance = instances.get(name);
			
			if(instance == null)
			{
				if(name.indexOf(".") > -1)
				{
					String parts[] = name.split("\\.");
					
					if(packageEndingName.equalsIgnoreCase(parts[parts.length - 2]))
					{
						try
						{
							instance = type.newInstance();
							
							instances.put(name, instance);
						}
						catch(InstantiationException | IllegalAccessException exception)
						{
							// ignore it
						}
					}
				}
			}
		}
		
		if(instance == null)
		{
			throw new IllegalArgumentException(packageEndingName + " does not belong to a ending \"*." + packageEndingName + "\" package");
		}
		else
		{
			return (T) instance;
		}
	}
}
