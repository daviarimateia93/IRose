package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.Player;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class PlayerRepository extends MySQLGenericSimpleDAO<Player>
{
	@Override
	protected void parseBean(ResultSet resultSet, Player bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setAccount(RepositoryManager.get(AccountRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_ACCOUNT")));
		bean.setAttributePoints(resultSet.getInt("ATTRIBUTES_POINTS"));
		bean.setSkillPoints(resultSet.getInt("SKILL_POINTS"));
		bean.setRespawn(RepositoryManager.get(CharacterAreaRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_PLAYER_RESPAWN")));
		bean.setAttributes(RepositoryManager.get(PlayerAttributesRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_PLAYER_ATTRIBUTES")));
		bean.setExtraXpRate(resultSet.getFloat("EXTRA_XP_RATE"));
		bean.setExtraDropRate(resultSet.getFloat("EXTRA_DROP_RATE"));
		bean.setSkills(RepositoryManager.get(PlayerSkillRepository.class).selectByPlayerId(getCurrentConnection(), bean.getId()));
		
		RepositoryManager.get(CharacterRepository.class).parseBean(RepositoryManager.get(CharacterRepository.class).selectOneAsResultSet(getCurrentConnection(), bean.getId()), bean);
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(Player bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("ID_ACCOUNT", bean.getAccount().getId());
		map.put("ATTRIBUTES_POINTS", bean.getAttributePoints());
		map.put("SKILL_POINTS", bean.getSkillPoints());
		map.put("ID_PLAYER_RESPAWN", bean.getRespawn().getId());
		map.put("ID_PLAYER_ATTRIBUTES", bean.getAttributes().getId());
		map.put("EXTRA_XP_RATE", bean.getExtraXpRate());
		map.put("EXTRA_DROP_RATE", bean.getExtraDropRate());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	@Override
	public int insert(Connection connection, Player bean) throws Exception
	{
		int returnValue = super.insert(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).insert(connection, bean);
		
		return returnValue;
	}
	
	@Override
	public int update(Connection connection, Player bean) throws Exception
	{
		int returnValue = super.update(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).update(connection, bean);
		
		return returnValue;
	}
	
	@Override
	public int delete(Connection connection, Player bean) throws Exception
	{
		int returnValue = super.delete(connection, bean);
		
		RepositoryManager.get(CharacterRepository.class).delete(connection, bean);
		
		return returnValue;
	}
	
	public List<Player> selectByAccountId(Connection connection, Long accountId) throws Exception
	{
		String sql = "SELECT * FROM " + getTableName() + " WHERE ID_ACCOUNT = ?";
		
		return getBeans(executeQuery(connection, sql, accountId));
	}
}
