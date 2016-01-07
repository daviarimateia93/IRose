package irose.entity;

import java.util.List;

import me.gerenciar.sdao.annotation.TableName;

@TableName("SUMMON")
public class Summon extends Character
{
	private static final long serialVersionUID = -7342805184951353427L;
	
	private List<SummonSkill> skills;
	
	// non persistent
	private Player player;
	
	@Override
	public List<SummonSkill> getSkills()
	{
		return skills;
	}
	
	public void setSkills(List<SummonSkill> skills)
	{
		this.skills = skills;
	}
	
	@Override
	public CharacterType getType()
	{
		return CharacterType.SUMMON;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
