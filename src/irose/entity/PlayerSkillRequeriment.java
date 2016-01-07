package irose.entity;

import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_SKILL")
public class PlayerSkillRequeriment extends PlayerSkill
{
	
	private static final long serialVersionUID = -1505639894211748211L;
	
	private Long minLevel;
	
	public Long getMinLevel()
	{
		return minLevel;
	}
	
	public void setMinLevel(Long minLevel)
	{
		this.minLevel = minLevel;
	}
}
