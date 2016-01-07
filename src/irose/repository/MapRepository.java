package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import irose.entity.Map;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class MapRepository extends MySQLGenericSimpleDAO<Map>
{
	@Override
	protected void parseBean(ResultSet resultSet, Map bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
	}
	
	@Override
	protected List<java.util.Map<String, Object>> parseMaps(Map bean)
	{
		java.util.Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		
		List<java.util.Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
