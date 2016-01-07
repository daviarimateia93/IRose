package irose.util;

import java.sql.Connection;
import java.sql.Savepoint;

import me.gerenciar.sdao.factory.DAOFactory;
import me.gerenciar.sdao.factory.DAOFactory.Type;

public class RepositoryManager extends InstanceManager
{
	public static <T> T get(Class<T> type)
	{
		return get(type, "repository");
	}
	
	public static DAOFactory getDAOFactory()
	{
		return DAOFactory.getInstance(Type.MYSQL);
	}
	
	public static Connection newConnection()
	{
		return getDAOFactory().newConnection();
	}
	
	public static void beginTransaction(Connection connection)
	{
		getDAOFactory().beginTransaction(connection);
	}
	
	public static void commit(Connection connection)
	{
		getDAOFactory().commit(connection);
	}
	
	public static void rollback(Connection connection)
	{
		getDAOFactory().rollback(connection);
	}
	
	public static void rollback(Connection connection, Savepoint savepoint)
	{
		getDAOFactory().rollback(connection, savepoint);
	}
}
