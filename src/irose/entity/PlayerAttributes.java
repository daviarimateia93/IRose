package irose.entity;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER_ATTRIBUTES")
public class PlayerAttributes extends BaseEntity
{
	private static transient final long serialVersionUID = -1064031796208216819L;
	
	@Identifier("ID")
	@Generated("ID")
	private Long id;
	private int strength;
	private int dexterity;
	private int intelligence;
	private int concentration;
	private int charm;
	private int sense;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public void setStrength(int strength)
	{
		this.strength = strength;
	}
	
	public int getDexterity()
	{
		return dexterity;
	}
	
	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}
	
	public int getIntelligence()
	{
		return intelligence;
	}
	
	public void setIntelligence(int intelligence)
	{
		this.intelligence = intelligence;
	}
	
	public int getConcentration()
	{
		return concentration;
	}
	
	public void setConcentration(int concentration)
	{
		this.concentration = concentration;
	}
	
	public int getCharm()
	{
		return charm;
	}
	
	public void setCharm(int charm)
	{
		this.charm = charm;
	}
	
	public int getSense()
	{
		return sense;
	}
	
	public void setSense(int sense)
	{
		this.sense = sense;
	}
}
