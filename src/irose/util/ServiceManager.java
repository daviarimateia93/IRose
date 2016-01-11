package irose.util;

public class ServiceManager extends InstanceManager
{
	private ServiceManager()
	{
		super();
	}
	
	public static <T> T get(Class<T> type)
	{
		return get(type, "service");
	}
}
