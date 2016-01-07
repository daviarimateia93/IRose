package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.Character;
import irose.entity.CharacterCharacterSkill;
import irose.entity.CharacterSkill;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class CharacterRepository extends MySQLGenericSimpleDAO<Character>
{
	@Override
	protected void parseBean(ResultSet resultSet, Character bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setName(resultSet.getString("NAME"));
		bean.setSavedLocation(RepositoryManager.get(LocationRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_LOCATION")));
		bean.setHp(resultSet.getLong("HP"));
		bean.setMp(resultSet.getLong("MP"));
		bean.setWeight(resultSet.getLong("WEIGHT"));
		bean.setSp(resultSet.getLong("SP"));
		bean.setHpRecovery(resultSet.getFloat("HP_RECOVERY"));
		bean.setMpRecovery(resultSet.getFloat("MP_RECOVERY"));
		bean.setStats(RepositoryManager.get(CharacterStatsRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_CHARACTER_STATS")));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(Character bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("NAME", bean.getName());
		map.put("ID_LOCATION", bean.getSavedLocation().getId());
		map.put("HP", bean.getHp());
		map.put("MP", bean.getMp());
		map.put("WEIGHT", bean.getWeight());
		map.put("SP", bean.getSp());
		map.put("HP_RECOVERY", bean.getHpRecovery());
		map.put("MP_RECOVERY", bean.getMpRecovery());
		map.put("ID_CHARACTER_STATS", bean.getStats().getId());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	@Override
	public int insert(Connection connection, Character bean) throws Exception
	{
		int returnValue = super.insert(connection, bean);
		
		if(!bean.getSkills().isEmpty())
		{
			CharacterCharacterSkill characterCharacterSkill = new CharacterCharacterSkill();
			characterCharacterSkill.setCharacter(bean);
			
			for(CharacterSkill skill : bean.getSkills())
			{
				characterCharacterSkill.getSkills().add(skill);
			}
			
			RepositoryManager.get(CharacterCharacterSkillRepository.class).insert(connection, characterCharacterSkill);
		}
		
		return returnValue;
	}
	
	@Override
	public int update(Connection connection, Character bean) throws Exception
	{
		int returnValue = super.update(connection, bean);
		
		CharacterCharacterSkill characterCharacterSkill = new CharacterCharacterSkill();
		characterCharacterSkill.setCharacter(bean);
		
		for(CharacterSkill skill : bean.getSkills())
		{
			characterCharacterSkill.getSkills().add(skill);
		}
		
		CharacterCharacterSkill selectedCharacterCharacterSkill = RepositoryManager.get(CharacterCharacterSkillRepository.class).selectByCharacterId(connection, characterCharacterSkill.getCharacter().getId());
		
		if(characterCharacterSkill.getSkills().isEmpty() && selectedCharacterCharacterSkill != null)
		{
			RepositoryManager.get(CharacterCharacterSkillRepository.class).delete(connection, selectedCharacterCharacterSkill);
		}
		else
		{
			RepositoryManager.get(CharacterCharacterSkillRepository.class).update(connection, characterCharacterSkill);
		}
		
		return returnValue;
	}
	
	@Override
	public int delete(Connection connection, Character bean) throws Exception
	{
		int returnValue = super.delete(connection, bean);
		
		CharacterCharacterSkill characterCharacterSkill = new CharacterCharacterSkill();
		characterCharacterSkill.setCharacter(bean);
		
		for(CharacterSkill skill : bean.getSkills())
		{
			characterCharacterSkill.getSkills().add(skill);
		}
		
		RepositoryManager.get(CharacterCharacterSkillRepository.class).delete(connection, characterCharacterSkill);
		
		return returnValue;
	}
}
