package irose.entity;

import java.util.ArrayList;
import java.util.List;

import me.gerenciar.sdao.annotation.Group;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("CHARACTER_CHARACTER_SKILL")
public class CharacterCharacterSkill extends Gateway
{
	private static final long serialVersionUID = 2486495146745972075L;
	
	@Identifier("ID_CHARACTER")
	@Group("ID_CHARACTER")
	private Character character;
	@Identifier("ID_CHARACTER_SKILL")
	private List<CharacterSkill> skills = new ArrayList<>();
	
	public Character getCharacter()
	{
		return character;
	}
	
	public void setCharacter(Character character)
	{
		this.character = character;
	}
	
	public List<CharacterSkill> getSkills()
	{
		return skills;
	}
	
	public void setSkills(List<CharacterSkill> skills)
	{
		this.skills = skills;
	}
}
