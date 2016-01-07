package irose.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.CharacterStats;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class CharacterStatsRepository extends MySQLGenericSimpleDAO<CharacterStats>
{
	@Override
	protected void parseBean(ResultSet resultSet, CharacterStats bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setHpLimit(resultSet.getLong("HP_LIMIT"));
		bean.setMpLimit(resultSet.getLong("MP_LIMIT"));
		bean.setWeightLimit(resultSet.getLong("WEIGHT_LIMIT"));
		bean.setSpLimit(resultSet.getLong("SP_LIMIT"));
		bean.setAttack(resultSet.getLong("ATTACK"));
		bean.setDefense(resultSet.getLong("DEFENSE"));
		bean.setAccuracy(resultSet.getLong("ACCURACY"));
		bean.setMagicDefense(resultSet.getLong("MAGIC_DEFENSE"));
		bean.setDodge(resultSet.getLong("DODGE"));
		bean.setMovementSpeed(resultSet.getLong("MOVEMENT_SPEED"));
		bean.setAttackSpeed(resultSet.getLong("ATTACK_SPEED"));
		bean.setCritical(resultSet.getLong("CRITICAL"));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(CharacterStats bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("HP_LIMIT", bean.getHpLimit());
		map.put("MP_LIMIT", bean.getMpLimit());
		map.put("WEIGHT_LIMIT", bean.getWeightLimit());
		map.put("SP_LIMIT", bean.getSpLimit());
		map.put("ATTACK", bean.getAttack());
		map.put("DEFENSE", bean.getDefense());
		map.put("ACCURACY", bean.getAccuracy());
		map.put("MAGIC_DEFENSE", bean.getMagicDefense());
		map.put("DODGE", bean.getDodge());
		map.put("MOVEMENT_SPEED", bean.getMovementSpeed());
		map.put("ATTACK_SPEED", bean.getAttackSpeed());
		map.put("CRITICAL", bean.getCritical());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
}
