package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.Summon;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class SummonRepository extends MySQLGenericSimpleDAO<Summon>
{
	@Override
	protected void parseBean(ResultSet resultSet, Summon bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setSkills(RepositoryManager.get(SummonSkillRepository.class).selectBySummonId(getCurrentConnection(), bean.getId()));
		
		RepositoryManager.get(CharacterRepository.class).parseBean(RepositoryManager.get(CharacterRepository.class).selectOneAsResultSet(getCurrentConnection(), bean.getId()), bean);
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(Summon bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	@Override
	public int insert(Connection connection, Summon bean) throws Exception
	{
		int returnValue = super.insert(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).insert(connection, bean);
		
		return returnValue;
	}
	
	@Override
	public int update(Connection connection, Summon bean) throws Exception
	{
		int returnValue = super.update(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).update(connection, bean);
		
		return returnValue;
	}
	
	@Override
	public int delete(Connection connection, Summon bean) throws Exception
	{
		int returnValue = super.delete(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).delete(connection, bean);
		
		return returnValue;
	}
}
