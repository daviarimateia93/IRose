package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterArea;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class CharacterAreaRepository extends MySQLGenericSimpleDAO<CharacterArea>
{
	@Override
	protected void parseBean(ResultSet resultSet, CharacterArea bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setLocation(RepositoryManager.get(LocationRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_LOCATION")));
		bean.setRadius(resultSet.getLong("RADIUS"));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(CharacterArea bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("ID_LOCATION", bean.getLocation().getId());
		map.put("RADIUS", bean.getRadius());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
