package irose.entity;

import java.util.List;

import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_SKILL")
public class PlayerSkill extends CharacterSkill
{
	private static transient final long serialVersionUID = -6009222555754753172L;
	
	private int level;
	private int maxLevel;
	private int skillPoints;
	private List<PlayerSkillRequeriment> requeriments;
	
	public int getLevel()
	{
		return level;
	}
	
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	public int getMaxLevel()
	{
		return maxLevel;
	}
	
	public void setMaxLevel(int maxLevel)
	{
		this.maxLevel = maxLevel;
	}
	
	public int getSkillPoints()
	{
		return skillPoints;
	}
	
	public void setSkillPoints(int skillPoints)
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
