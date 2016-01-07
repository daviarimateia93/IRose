package irose.entity;

import java.util.List;

import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_SKILL")
public class PlayerSkill extends CharacterSkill
{
	private static final long serialVersionUID = -6009222555754753172L;
	
	private Long level;
	private Long maxLevel;
	private Long skillPoints;
	private List<PlayerSkillRequeriment> requeriments;
	
	public Long getLevel()
	{
		return level;
	}
	
	public void setLevel(Long level)
	{
		this.level = level;
	}
	
	public Long getMaxLevel()
	{
		return maxLevel;
	}
	
	public void setMaxLevel(Long maxLevel)
	{
		this.maxLevel = maxLevel;
	}
	
	public Long getSkillPoints()
	{
		return skillPoints;
	}
	
	public void setSkillPoints(Long skillPoints)
	{
		this.skillPoints = skillPoints;
	}
	
	public List<PlayerSkillRequeriment> getRequeriments()
	{
		return requeriments;
	}
	
	public void setRequeriments(List<PlayerSkillRequeriment> requeriments)
	{
		this.requeriments = requeriments;
	}
}
