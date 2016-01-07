package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.Location;
import irose.util.Point;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class LocationRepository extends MySQLGenericSimpleDAO<Location>
{	
	@Override
	protected void parseBean(ResultSet resultSet, Location bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setMap(RepositoryManager.get(MapRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_MAP")));
		bean.setPoint(new Point(resultSet.getDouble("POINT_X"), resultSet.getDouble("POINT_Y"), resultSet.getDouble("POINT_Z")));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(Location bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("ID_MAP", bean.getMap().getId());
		map.put("POINT_X", bean.getPoint().getX());
		map.put("POINT_Y", bean.getPoint().getY());
		map.put("POINT_Z", bean.getPoint().getZ());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
