package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.PlayerSkillPlayerSkillRequeriment;
import irose.entity.PlayerSkillRequeriment;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class PlayerSkillRequerimentRepository extends MySQLGenericSimpleDAO<PlayerSkillRequeriment>
{
	@Override
	protected void parseBean(ResultSet resultSet, PlayerSkillRequeriment bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setMinLevel(resultSet.getInt("MIN_LEVEL"));
		
		RepositoryManager.get(PlayerSkillRepository.class).parseBean(RepositoryManager.get(PlayerSkillRepository.class).selectOneAsResultSet(getCurrentConnection(), bean.getId()), bean);
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(PlayerSkillRequeriment bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("MIN_LEVEL", bean.getMinLevel());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	public List<PlayerSkillRequeriment> selectByPlayerSkillId(Connection connection, Long playerSkillId) throws Exception
	{
		PlayerSkillPlayerSkillRequeriment playerSkillPlayerSkillRequeriment = RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).selectByPlayerSkillId(connection, playerSkillId);
		List<PlayerSkillRequeriment> requeriments = new ArrayList<>();
		
		for(PlayerSkillRequeriment playerSkillRequeriment : playerSkillPlayerSkillRequeriment.getRequeriments())
		{
			PlayerSkillRequeriment requeriment = selectOne(connection, playerSkillRequeriment.getId());
			
			if(requeriment != null)
			{
				requeriments.add(requeriment);
			}
		}
		
		return requeriments;
	}
}
