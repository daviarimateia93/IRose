package irose.entity;

import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("PLAYER_ATTRIBUTES")
public class PlayerAttributes extends Gateway
{
	private static final long serialVersionUID = -1064031796208216819L;
	
	@Identifier("ID")
	private Long id;
	private long strength;
	private long dexterity;
	private long intelligence;
	private long concentration;
	private long charm;
	private long sense;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public long getStrength()
	{
		return strength;
	}
	
	public void setStrength(long strength)
	{
		this.strength = strength;
	}
	
	public long getDexterity()
	{
		return dexterity;
	}
	
	public void setDexterity(long dexterity)
	{
		this.dexterity = dexterity;
	}
	
	public long getIntelligence()
	{
		return intelligence;
	}
	
	public void setIntelligence(long intelligence)
	{
		this.intelligence = intelligence;
	}
	
	public long getConcentration()
	{
		return concentration;
	}
	
	public void setConcentration(long concentration)
	{
		this.concentration = concentration;
	}
	
	public long getCharm()
	{
		return charm;
	}
	
	public void setCharm(long charm)
	{
		this.charm = charm;
	}
	
	public long getSense()
	{
		return sense;
	}
	
	public void setSense(long sense)
	{
		this.sense = sense;
	}
}
