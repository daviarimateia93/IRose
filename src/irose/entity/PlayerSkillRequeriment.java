package irose.entity;

import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_SKILL")
public class PlayerSkillRequeriment extends PlayerSkill
{
	private static transient final long serialVersionUID = -1505639894211748211L;
	
	private int minLevel;
	
	public int getMinLevel()
	{
		return minLevel;
	}
	
	public void setMinLevel(int minLevel)
	{
		this.minLevel = minLevel;
	}
}
