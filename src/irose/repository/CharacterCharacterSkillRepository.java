package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterCharacterSkill;
import irose.entity.CharacterSkill;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericDAO;

public class CharacterCharacterSkillRepository extends MySQLGenericDAO<CharacterCharacterSkill>
{
	@Override
	protected void parseBean(ResultSet resultSet, CharacterCharacterSkill bean) throws Exception
	{
		bean.setCharacter(RepositoryManager.get(CharacterRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_CHARACTER")));
		bean.getSkills().add(RepositoryManager.get(CharacterSkillRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_CHARACTER_SKILL")));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(CharacterCharacterSkill bean)
	{
		List<Map<String, Object>> maps = new ArrayList<>();
		
		for(CharacterSkill skill : bean.getSkills())
		{
			Map<String, Object> map = new HashMap<>();
			map.put("ID_CHARACTER", bean.getCharacter().getId());
			map.put("ID_CHARACTER_SKILL", skill.getId());
			
			maps.add(map);
		}
		
		return maps;
	}
	
	@Override
	protected CharacterCharacterSkill mergeBeanOnUpdateToDelete(CharacterCharacterSkill updateBean, CharacterCharacterSkill selectedBean)
	{
		CharacterCharacterSkill deleteBean = null;
		
		for(CharacterSkill skill : selectedBean.getSkills())
		{
			if(!updateBean.getSkills().contains(skill))
			{
				if(deleteBean == null)
				{
					deleteBean = new CharacterCharacterSkill();
				}
				
				deleteBean.getSkills().add(skill);
			}
		}
		
		if(deleteBean != null)
		{
			deleteBean.setCharacter(updateBean.getCharacter());
		}
		
		return deleteBean;
	}
	
	@Override
	protected CharacterCharacterSkill mergeBeanOnUpdateToInsert(CharacterCharacterSkill updateBean, CharacterCharacterSkill selectedBean)
	{
		CharacterCharacterSkill insertBean = null;
		
		for(CharacterSkill skill : updateBean.getSkills())
		{
			if(!selectedBean.getSkills().contains(skill))
			{
				if(insertBean == null)
				{
					insertBean = new CharacterCharacterSkill();
				}
				
				insertBean.getSkills().add(skill);
			}
		}
		
		if(insertBean != null)
		{
			insertBean.setCharacter(updateBean.getCharacter());
		}
		
		return insertBean;
	}
	
	@Override
	protected CharacterCharacterSkill mergeBean(CharacterCharacterSkill lastBean, CharacterCharacterSkill bean)
	{
		if(lastBean == null)
		{
			return bean;
		}
		
		if(lastBean.getCharacter().getId() == bean.getCharacter().getId())
		{
			for(CharacterSkill skill : bean.getSkills())
			{
				lastBean.getSkills().add(skill);
			}
			
			return lastBean;
		}
		
		return null;
	}
	
	public CharacterCharacterSkill selectByCharacterId(Connection connection, Long characterId) throws Exception
	{
		String sql = "SELECT * FROM " + getTableName() + " WHERE ID_CHARACTER = ?";
		
		return getBean(executeQuery(connection, sql, characterId));
	}
}
