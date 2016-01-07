package irose.entity;

import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("CHARACTER_STATS")
public class CharacterStats extends Gateway
{
	private static final long serialVersionUID = -4708186494066603226L;
	
	@Identifier("ID")
	private Long id;
	private long hpLimit;
	private long mpLimit;
	private long weightLimit;
	private long spLimit;
	private long attack;
	private long defense;
	private long accuracy;
	private long magicDefense;
	private long dodge;
	private long movementSpeed;
	private long attackSpeed;
	private long critical;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public long getHpLimit()
	{
		return hpLimit;
	}
	
	public void setHpLimit(long hpLimit)
	{
		this.hpLimit = hpLimit;
	}
	
	public long getMpLimit()
	{
		return mpLimit;
	}
	
	public void setMpLimit(long mpLimit)
	{
		this.mpLimit = mpLimit;
	}
	
	public long getWeightLimit()
	{
		return weightLimit;
	}
	
	public void setWeightLimit(long weightLimit)
	{
		this.weightLimit = weightLimit;
	}
	
	public long getSpLimit()
	{
		return spLimit;
	}
	
	public void setSpLimit(long spLimit)
	{
		this.spLimit = spLimit;
	}
	
	public long getAttack()
	{
		return attack;
	}
	
	public void setAttack(long attack)
	{
		this.attack = attack;
	}
	
	public long getDefense()
	{
		return defense;
	}
	
	public void setDefense(long defense)
	{
		this.defense = defense;
	}
	
	public long getAccuracy()
	{
		return accuracy;
	}
	
	public void setAccuracy(long accuracy)
	{
		this.accuracy = accuracy;
	}
	
	public long getMagicDefense()
	{
		return magicDefense;
	}
	
	public void setMagicDefense(long magicDefense)
	{
		this.magicDefense = magicDefense;
	}
	
	public long getDodge()
	{
		return dodge;
	}
	
	public void setDodge(long dodge)
	{
		this.dodge = dodge;
	}
	
	public long getMovementSpeed()
	{
		return movementSpeed;
	}
	
	public void setMovementSpeed(long movementSpeed)
	{
		this.movementSpeed = movementSpeed;
	}
	
	public long getAttackSpeed()
	{
		return attackSpeed;
	}
	
	public void setAttackSpeed(long attackSpeed)
	{
		this.attackSpeed = attackSpeed;
	}
	
	public long getCritical()
	{
		return critical;
	}
	
	public void setCritical(long critical)
	{
		this.critical = critical;
	}
}
