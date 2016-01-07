package irose.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import irose.entity.PlayerSkillPlayerSkillRequeriment;
import irose.entity.PlayerSkillRequeriment;
import irose.util.RepositoryManager;
import me.gerenciar.sdao.dao.jdbc.mysql.MySQLGenericDAO;

public class PlayerSkillPlayerSkillRequerimentRepository extends MySQLGenericDAO<PlayerSkillPlayerSkillRequeriment>
{
	@Override
	protected void parseBean(ResultSet resultSet, PlayerSkillPlayerSkillRequeriment bean) throws Exception
	{
		bean.setSkill(RepositoryManager.get(PlayerSkillRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_PLAYER_SKILL")));
		bean.getRequeriments().add(RepositoryManager.get(PlayerSkillRequerimentRepository.class).selectOne(getCurrentConnection(), resultSet.getLong("ID_PLAYER_SKILL_REQUERIMENT")));
	}
	
	@Override
	protected PlayerSkillPlayerSkillRequeriment parseBean(ResultSet resultSet) throws Exception
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected List<Map<String, Object>> parseMaps(PlayerSkillPlayerSkillRequeriment bean)
	{
		List<Map<String, Object>> maps = new ArrayList<>();
		
		for(PlayerSkillRequeriment requeriment : bean.getRequeriments())
		{
			Map<String, Object> map = new HashMap<>();
			map.put("ID_PLAYER_SKILL", bean.getSkill().getId());
			map.put("ID_PLAYER_SKILL_REQUERIMENT", requeriment.getId());
			
			maps.add(map);
		}
		
		return maps;
	}
	
	@Override
	protected PlayerSkillPlayerSkillRequeriment mergeBeanOnUpdateToDelete(PlayerSkillPlayerSkillRequeriment updateBean, PlayerSkillPlayerSkillRequeriment selectedBean)
	{
		PlayerSkillPlayerSkillRequeriment deleteBean = null;
		
		for(PlayerSkillRequeriment requeriment : selectedBean.getRequeriments())
		{
			if(!updateBean.getRequeriments().contains(requeriment))
			{
				if(deleteBean == null)
				{
					deleteBean = new PlayerSkillPlayerSkillRequeriment();
				}
				
				deleteBean.getRequeriments().add(requeriment);
			}
		}
		
		if(deleteBean != null)
		{
			deleteBean.setSkill(updateBean.getSkill());
		}
		
		return deleteBean;
	}
	
	@Override
	protected PlayerSkillPlayerSkillRequeriment mergeBeanOnUpdateToInsert(PlayerSkillPlayerSkillRequeriment updateBean, PlayerSkillPlayerSkillRequeriment selectedBean)
	{
		PlayerSkillPlayerSkillRequeriment insertBean = null;
		
		for(PlayerSkillRequeriment requeriment : updateBean.getRequeriments())
		{
			if(!selectedBean.getRequeriments().contains(requeriment))
			{
				if(insertBean == null)
				{
					insertBean = new PlayerSkillPlayerSkillRequeriment();
				}
				
				insertBean.getRequeriments().add(requeriment);
			}
		}
		
		if(insertBean != null)
		{
			insertBean.setSkill(updateBean.getSkill());
		}
		
		return insertBean;
	}
	
	@Override
	protected PlayerSkillPlayerSkillRequeriment mergeBean(PlayerSkillPlayerSkillRequeriment lastBean, PlayerSkillPlayerSkillRequeriment bean)
	{
		if(lastBean == null)
		{
			return bean;
		}
		
		if(lastBean.getSkill().getId() == bean.getSkill().getId())
		{
			for(PlayerSkillRequeriment requeriment : bean.getRequeriments())
			{
				lastBean.getRequeriments().add(requeriment);
			}
			
			return lastBean;
		}
		
		return null;
	}
	
	public PlayerSkillPlayerSkillRequeriment selectByPlayerSkillId(Connection connection, Long playerSkillId) throws Exception
	{
		String sql = "SELECT * FROM " + getTableName() + " WHERE ID_PLAYER_SKILL = ?";
		
		return getBean(executeQuery(connection, sql, playerSkillId));
	}
}
