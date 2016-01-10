package irose.util;

public class ServiceManager extends InstanceManager
{
	protected ServiceManager()
	{
		super();
	}
	
	public static <T> T get(Class<T> type)
	{
		return get(type, "service");
	}
}
