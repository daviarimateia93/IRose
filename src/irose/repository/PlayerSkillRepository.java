package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterCharacterSkill;
import irose.entity.CharacterSkill;
import irose.entity.PlayerSkill;
import irose.entity.PlayerSkillPlayerSkillRequeriment;
import irose.entity.PlayerSkillRequeriment;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class PlayerSkillRepository extends MySQLGenericSimpleDAO<PlayerSkill>
{
	@Override
	protected void parseBean(ResultSet resultSet, PlayerSkill bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setLevel(resultSet.getLong("LEVEL"));
		bean.setMaxLevel(resultSet.getLong("MAX_LEVEL"));
		bean.setSkillPoints(resultSet.getLong("SKILL_POINTS"));
		bean.setRequeriments(RepositoryManager.get(PlayerSkillRequerimentRepository.class).selectByPlayerSkillId(getCurrentConnection(), bean.getId()));
		
		RepositoryManager.get(CharacterSkillRepository.class).parseBean(RepositoryManager.get(CharacterSkillRepository.class).selectOneAsResultSet(getCurrentConnection(), bean.getId()), bean);
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(PlayerSkill bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("LEVEL", bean.getId());
		map.put("MAX_LEVEL", bean.getId());
		map.put("SKILL_POINTS", bean.getId());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	@Override
	public int insert(Connection connection, PlayerSkill bean) throws Exception
	{
		int returnValue = super.insert(connection, bean);
		
		if(!bean.getRequeriments().isEmpty())
		{
			PlayerSkillPlayerSkillRequeriment playerSkillPlayerSkillRequeriment = new PlayerSkillPlayerSkillRequeriment();
			playerSkillPlayerSkillRequeriment.setSkill(bean);
			
			for(PlayerSkillRequeriment requeriment : bean.getRequeriments())
			{
				playerSkillPlayerSkillRequeriment.getRequeriments().add(requeriment);
			}
			
			RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).insert(connection, playerSkillPlayerSkillRequeriment);
		}
		
		return returnValue;
	}
	
	@Override
	public int update(Connection connection, PlayerSkill bean) throws Exception
	{
		int returnValue = super.update(connection, bean);
		
		PlayerSkillPlayerSkillRequeriment playerSkillPlayerSkillRequeriment = new PlayerSkillPlayerSkillRequeriment();
		playerSkillPlayerSkillRequeriment.setSkill(bean);
		
		for(PlayerSkillRequeriment requeriment : bean.getRequeriments())
		{
			playerSkillPlayerSkillRequeriment.getRequeriments().add(requeriment);
		}
		
		PlayerSkillPlayerSkillRequeriment selectedPlayerSkillPlayerSkillRequeriment = RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).selectByPlayerSkillId(connection, playerSkillPlayerSkillRequeriment.getSkill().getId());
		
		if(playerSkillPlayerSkillRequeriment.getRequeriments().isEmpty() && selectedPlayerSkillPlayerSkillRequeriment != null)
		{
			RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).delete(connection, selectedPlayerSkillPlayerSkillRequeriment);
		}
		else
		{
			RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).update(connection, playerSkillPlayerSkillRequeriment);
		}
		
		return returnValue;
	}
	
	@Override
	public int delete(Connection connection, PlayerSkill bean) throws Exception
	{
		int returnValue = super.delete(connection, bean);
		
		PlayerSkillPlayerSkillRequeriment playerSkillPlayerSkillRequeriment = new PlayerSkillPlayerSkillRequeriment();
		playerSkillPlayerSkillRequeriment.setSkill(bean);
		
		for(PlayerSkillRequeriment requeriment : bean.getRequeriments())
		{
			playerSkillPlayerSkillRequeriment.getRequeriments().add(requeriment);
		}
		
		RepositoryManager.get(PlayerSkillPlayerSkillRequerimentRepository.class).delete(connection, playerSkillPlayerSkillRequeriment);
		
		return returnValue;
	}
	
	public List<PlayerSkill> selectByPlayerId(Connection connection, Long playerId) throws Exception
	{
		CharacterCharacterSkill characterCharacterSkill = RepositoryManager.get(CharacterCharacterSkillRepository.class).selectByCharacterId(connection, playerId);
		List<PlayerSkill> skills = new ArrayList<>();
		
		if(characterCharacterSkill != null)
		{
			for(CharacterSkill characterSkill : characterCharacterSkill.getSkills())
			{
				PlayerSkill skill = selectOne(connection, characterSkill.getId());
				
				if(skill != null)
				{
					skills.add(skill);
				}
			}
		}
		
		return skills;
	}
}
