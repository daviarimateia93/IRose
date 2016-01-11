package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterSkill;
import irose.entity.CharacterSkillCategory;
import irose.entity.CharacterSkillRange;
import irose.entity.CharacterSkillType;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class CharacterSkillRepository extends MySQLGenericSimpleDAO<CharacterSkill>
{
	@Override
	protected void parseBean(ResultSet resultSet, CharacterSkill bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setRange(CharacterSkillRange.valueOf(resultSet.getString("RANGE")));
		bean.setCategory(CharacterSkillCategory.valueOf(resultSet.getString("CATEGORY")));
		bean.setType(CharacterSkillType.valueOf(resultSet.getString("TYPE")));
		bean.setDuration(resultSet.getInt("DURATION"));
		bean.setCountDown(resultSet.getInt("COUNT_DOWN"));
		bean.setValue(resultSet.getInt("VALUE"));
		bean.setValuePercent(resultSet.getFloat("VALUE_PERCENT"));
		bean.setMp(resultSet.getInt("MP"));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(CharacterSkill bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("RANGE", bean.getRange().name());
		map.put("CATEGORY", bean.getCategory().name());
		map.put("TYPE", bean.getType().name());
		map.put("DURATION", bean.getDuration());
		map.put("COUNT_DOWN", bean.getCountDown());
		map.put("VALUE", bean.getValue());
		map.put("VALUE_PERCENT", bean.getValuePercent());
		map.put("MP", bean.getMp());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
