package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.PlayerAttributes;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class PlayerAttributesRepository extends MySQLGenericSimpleDAO<PlayerAttributes>
{
	@Override
	protected void parseBean(ResultSet resultSet, PlayerAttributes bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setStrength(resultSet.getInt("STRENGTH"));
		bean.setDexterity(resultSet.getInt("DEXTERITY"));
		bean.setIntelligence(resultSet.getInt("INTELLIGENCE"));
		bean.setConcentration(resultSet.getInt("CONCENTRATION"));
		bean.setCharm(resultSet.getInt("CHARM"));
		bean.setSense(resultSet.getInt("SENSE"));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(PlayerAttributes bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("STRENGTH", bean.getStrength());
		map.put("DEXTERITY", bean.getDexterity());
		map.put("INTELLIGENCE", bean.getIntelligence());
		map.put("CONCENTRATION", bean.getConcentration());
		map.put("CHARM", bean.getCharm());
		map.put("SENSE", bean.getSense());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
