package irose.entity;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.TableName;

@TableName("CHARACTER_STATS")
public class CharacterStats extends BaseEntity
{
	private static transient final long serialVersionUID = -4708186494066603226L;
	
	// non persistent
	private int hpLimit;
	private int mpLimit;
	private int weightLimit;
	private int spLimit;
	private int attack;
	private int defense;
	private int accuracy;
	private int magicDefense;
	private int dodge;
	private int movementSpeed;
	private int attackSpeed;
	private int critical;
	
	public int getHpLimit()
	{
		return hpLimit;
	}
	
	public void setHpLimit(int hpLimit)
	{
		this.hpLimit = hpLimit;
	}
	
	public int getMpLimit()
	{
		return mpLimit;
	}
	
	public void setMpLimit(int mpLimit)
	{
		this.mpLimit = mpLimit;
	}
	
	public int getWeightLimit()
	{
		return weightLimit;
	}
	
	public void setWeightLimit(int weightLimit)
	{
		this.weightLimit = weightLimit;
	}
	
	public int getSpLimit()
	{
		return spLimit;
	}
	
	public void setSpLimit(int spLimit)
	{
		this.spLimit = spLimit;
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public void setAttack(int attack)
	{
		this.attack = attack;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public void setDefense(int defense)
	{
		this.defense = defense;
	}
	
	public int getAccuracy()
	{
		return accuracy;
	}
	
	public void setAccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}
	
	public int getMagicDefense()
	{
		return magicDefense;
	}
	
	public void setMagicDefense(int magicDefense)
	{
		this.magicDefense = magicDefense;
	}
	
	public int getDodge()
	{
		return dodge;
	}
	
	public void setDodge(int dodge)
	{
		this.dodge = dodge;
	}
	
	public int getMovementSpeed()
	{
		return movementSpeed;
	}
	
	public void setMovementSpeed(int movementSpeed)
	{
		this.movementSpeed = movementSpeed;
	}
	
	public int getAttackSpeed()
	{
		return attackSpeed;
	}
	
	public void setAttackSpeed(int attackSpeed)
	{
		this.attackSpeed = attackSpeed;
	}
	
	public int getCritical()
	{
		return critical;
	}
	
	public void setCritical(int critical)
	{
		this.critical = critical;
	}
}
