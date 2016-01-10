package irose.util;

import me.gerenciar.sdao.factory.DAOFactory;
import me.gerenciar.sdao.factory.DAOFactory.Type;

public class RepositoryManager extends InstanceManager
{
	protected RepositoryManager()
	{
		super();
	}
	
	public static <T> T get(Class<T> type)
	{
		return get(type, "repository");
	}
	
	public static DAOFactory getDAOFactory()
	{
		return DAOFactory.getInstance(Type.MYSQL);
	}
}
