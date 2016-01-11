package irose.util;

import me.gerenciar.sdao.GerenciarmeSDAO;
import me.gerenciar.sdao.GerenciarmeSDAO.GerenciarmeSDAOException;
import me.gerenciar.sdao.GerenciarmeSDAO.MutableConfiguration;
import me.gerenciar.sdao.GerenciarmeSDAO.MutableConfiguration.MutableDatabase;
import me.gerenciar.sdao.factory.DAOFactory;
import me.gerenciar.sdao.factory.DAOFactory.Type;

public class RepositoryManager extends InstanceManager
{
	static
	{
		MutableDatabase database = new MutableDatabase();
		database.setAddress("localhost");
		database.setPort(3306);
		database.setName("IROSE");
		database.setUsername("root");
		database.setPassword("root");
		
		MutableConfiguration configuration = new MutableConfiguration();
		configuration.setDatabase(database);
		
		try
		{
			GerenciarmeSDAO.configure(configuration);
		}
		catch(GerenciarmeSDAOException exception)
		{
			exception.printStackTrace();
		}
	}
	
	private RepositoryManager()
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
