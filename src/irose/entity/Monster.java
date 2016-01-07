package irose.entity;

import java.util.List;

import me.gerenciar.sdao.annotation.TableName;

@TableName("MONSTER")
public class Monster extends Character
{
	private static final long serialVersionUID = -360800265349179884L;
	
	private List<MonsterSkill> skills;
	
	@Override
	public List<MonsterSkill> getSkills()
	{
		return skills;
	}
	
	public void setSkills(List<MonsterSkill> skills)
	{
		this.skills = skills;
	}
	
	@Override
	public CharacterType getType()
	{
		return CharacterType.MONSTER;
	}
}
