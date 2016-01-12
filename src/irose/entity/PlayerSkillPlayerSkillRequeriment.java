package irose.entity;

import java.util.List;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.Group;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_SKILL_PLAYER_SKILL_REQUERIMENT")
public class PlayerSkillPlayerSkillRequeriment extends BaseEntity
{
	private static transient final long serialVersionUID = -1904185884922673375L;
	
	@Identifier("ID_PLAYER_SKILL")
	@Group("ID_PLAYER_SKILL")
	private PlayerSkill skill;
	@Identifier("ID_PLAYER_SKILL_REQUERIMENT")
	private List<PlayerSkillRequeriment> requeriments;
	
	public PlayerSkill getSkill()
	{
		return skill;
	}
	
	public void setSkill(PlayerSkill skill)
	{
		this.skill = skill;
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
