package irose.util;

public class ServiceManager extends InstanceManager
{
	public static <T> T get(Class<T> type)
	{
		return get(type, "service");
	}
}
