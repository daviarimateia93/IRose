package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterCharacterSkill;
import irose.entity.CharacterSkill;
import irose.entity.SummonSkill;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class SummonSkillRepository extends MySQLGenericSimpleDAO<SummonSkill>
{
	@Override
	protected void parseBean(ResultSet resultSet, SummonSkill bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		
		RepositoryManager.get(CharacterSkillRepository.class).parseBean(RepositoryManager.get(CharacterSkillRepository.class).selectOneAsResultSet(getCurrentConnection(), bean.getId()), bean);
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(SummonSkill bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	public List<SummonSkill> selectBySummonId(Connection connection, Long summonId) throws Exception
	{
		CharacterCharacterSkill characterCharacterSkill = RepositoryManager.get(CharacterCharacterSkillRepository.class).selectByCharacterId(connection, summonId);
		List<SummonSkill> skills = new ArrayList<>();
		
		if(characterCharacterSkill != null)
		{
			for(CharacterSkill characterSkill : characterCharacterSkill.getSkills())
			{
				SummonSkill skill = selectOne(connection, characterSkill.getId());
				
				if(skill != null)
				{
					skills.add(skill);
				}
			}
		}
		
		return skills;
	}
}
