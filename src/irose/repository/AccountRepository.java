package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.Account;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericSimpleDAO;

public class AccountRepository extends MySQLGenericSimpleDAO<Account>
{
	@Override
	protected void parseBean(ResultSet resultSet, Account bean) throws Exception
	{
		bean.setId(resultSet.getLong("ID"));
		bean.setNickname(resultSet.getString("NICKNAME"));
		bean.setPassword(resultSet.getString("PASSWORD"));
		bean.setEmail(resultSet.getString("EMAIL"));
		bean.setLastTimeSeen(resultSet.getDate("LAST_TIME_SEEN"));
		bean.setPlayers(RepositoryManager.get(PlayerRepository.class).selectByAccountId(getCurrentConnection(), bean.getId()));
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(Account bean)
	{
		Map<String, Object> map = new HashMap<>();
		map.put("ID", bean.getId());
		map.put("NICKNAME", bean.getNickname());
		map.put("PASSWORD", bean.getPassword());
		map.put("EMAIL", bean.getEmail());
		map.put("LAST_TIME_SEEN", bean.getLastTimeSeen());
		
		List<Map<String, Object>> maps = new ArrayList<>();
		maps.add(map);
		
		return maps;
	}
	
	public Account selectByNicknameAndPassword(Connection connection, String nickname, String password) throws Exception
	{
		String sql = "SELECT * FROM " + getTableName() + " WHERE NICKNAME = ? AND PASSWORD = ?";
		
		return getBean(executeQuery(connection, sql, nickname, password));
	}
}
