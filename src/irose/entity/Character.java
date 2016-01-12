package irose.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;

@TableName("CHARACTER")
public class Character extends BaseEntity
{
	private static transient final long serialVersionUID = -254460156320452039L;
	
	@Identifier("ID")
	@Generated("ID")
	private Long id;
	private String name;
	private Location savedLocation;
	private int hp;
	private int mp;
	private int weight;
	private int sp;
	private float hpRecovery;
	private float mpRecovery;
	private CharacterStats stats;
	
	// non persistent
	private CharacterStats finalStats;
	private List<CharacterType> attackableBy = new ArrayList<>();
	private Character targetCharacter;
	private Location currentLocation;
	private CharacterEffect hpUp;
	private CharacterEffect hpDown;
	private CharacterEffect mpUp;
	private CharacterEffect mpDown;
	private CharacterEffect weightUp;
	private CharacterEffect weightDown;
	private CharacterEffect staminaUp;
	private CharacterEffect staminaDown;
	private CharacterEffect attackUp;
	private CharacterEffect attackDown;
	private CharacterEffect defenseUp;
	private CharacterEffect defenseDown;
	private CharacterEffect accuracyUp;
	private CharacterEffect accuracyDown;
	private CharacterEffect magicDefenseUp;
	private CharacterEffect magicDefenseDown;
	private CharacterEffect dodgeUp;
	private CharacterEffect dodgeDown;
	private CharacterEffect movementSpeedUp;
	private CharacterEffect movementSpeedDown;
	private CharacterEffect attackSpeedUp;
	private CharacterEffect attackSpeedDown;
	private CharacterEffect criticalUp;
	private CharacterEffect criticalDown;
	private CharacterEffect poisoned;
	private CharacterEffect frozen;
	private CharacterEffect burned;
	private CharacterEffect stunned;
	private CharacterEffect bledding;
	private CharacterEffect stealth;
	private CharacterEffect cloacking;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Location getSavedLocation()
	{
		return savedLocation;
	}
	
	public void setSavedLocation(Location savedLocation)
	{
		this.savedLocation = savedLocation;
	}
	
	public int getHp()
	{
		return hp;
	}
	
	public void setHp(int hp)
	{
		this.hp = hp;
	}
	
	public int getMp()
	{
		return mp;
	}
	
	public void setMp(int mp)
	{
		this.mp = mp;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	public int getSp()
	{
		return sp;
	}
	
	public void setSp(int sp)
	{
		this.sp = sp;
	}
	
	public float getHpRecovery()
	{
		return hpRecovery;
	}
	
	public void setHpRecovery(float hpRecovery)
	{
		this.hpRecovery = hpRecovery;
	}
	
	public float getMpRecovery()
	{
		return mpRecovery;
	}
	
	public void setMpRecovery(float mpRecovery)
	{
		this.mpRecovery = mpRecovery;
	}
	
	public CharacterStats getStats()
	{
		return stats;
	}
	
	public void setStats(CharacterStats stats)
	{
		this.stats = stats;
	}
	
	public CharacterStats getFinalStats()
	{
		return finalStats;
	}
	
	public void setFinalStats(CharacterStats finalStats)
	{
		this.finalStats = finalStats;
	}
	
	public List<CharacterType> getAttackableBy()
	{
		return attackableBy;
	}
	
	public void setAttackableBy(List<CharacterType> attackableBy)
	{
		this.attackableBy = attackableBy;
	}
	
	public Character getTargetCharacter()
	{
		return targetCharacter;
	}
	
	public void setTargetCharacter(Character targetCharacter)
	{
		this.targetCharacter = targetCharacter;
	}
	
	public Location getCurrentLocation()
	{
		return currentLocation;
	}
	
	public void setCurrentLocation(Location currentLocation)
	{
		this.currentLocation = currentLocation;
	}
	
	public CharacterEffect getHpUp()
	{
		return hpUp;
	}
	
	public void setHpUp(CharacterEffect hpUp)
	{
		this.hpUp = hpUp;
	}
	
	public CharacterEffect getHpDown()
	{
		return hpDown;
	}
	
	public void setHpDown(CharacterEffect hpDown)
	{
		this.hpDown = hpDown;
	}
	
	public CharacterEffect getMpUp()
	{
		return mpUp;
	}
	
	public void setMpUp(CharacterEffect mpUp)
	{
		this.mpUp = mpUp;
	}
	
	public CharacterEffect getMpDown()
	{
		return mpDown;
	}
	
	public void setMpDown(CharacterEffect mpDown)
	{
		this.mpDown = mpDown;
	}
	
	public CharacterEffect getWeightUp()
	{
		return weightUp;
	}
	
	public void setWeightUp(CharacterEffect weightUp)
	{
		this.weightUp = weightUp;
	}
	
	public CharacterEffect getWeightDown()
	{
		return weightDown;
	}
	
	public void setWeightDown(CharacterEffect weightDown)
	{
		this.weightDown = weightDown;
	}
	
	public CharacterEffect getStaminaUp()
	{
		return staminaUp;
	}
	
	public void setStaminaUp(CharacterEffect staminaUp)
	{
		this.staminaUp = staminaUp;
	}
	
	public CharacterEffect getStaminaDown()
	{
		return staminaDown;
	}
	
	public void setStaminaDown(CharacterEffect staminaDown)
	{
		this.staminaDown = staminaDown;
	}
	
	public CharacterEffect getAttackUp()
	{
		return attackUp;
	}
	
	public void setAttackUp(CharacterEffect attackUp)
	{
		this.attackUp = attackUp;
	}
	
	public CharacterEffect getAttackDown()
	{
		return attackDown;
	}
	
	public void setAttackDown(CharacterEffect attackDown)
	{
		this.attackDown = attackDown;
	}
	
	public CharacterEffect getDefenseUp()
	{
		return defenseUp;
	}
	
	public void setDefenseUp(CharacterEffect defenseUp)
	{
		this.defenseUp = defenseUp;
	}
	
	public CharacterEffect getDefenseDown()
	{
		return defenseDown;
	}
	
	public void setDefenseDown(CharacterEffect defenseDown)
	{
		this.defenseDown = defenseDown;
	}
	
	public CharacterEffect getAccuracyUp()
	{
		return accuracyUp;
	}
	
	public void setAccuracyUp(CharacterEffect accuracyUp)
	{
		this.accuracyUp = accuracyUp;
	}
	
	public CharacterEffect getAccuracyDown()
	{
		return accuracyDown;
	}
	
	public void setAccuracyDown(CharacterEffect accuracyDown)
	{
		this.accuracyDown = accuracyDown;
	}
	
	public CharacterEffect getMagicDefenseUp()
	{
		return magicDefenseUp;
	}
	
	public void setMagicDefenseUp(CharacterEffect magicDefenseUp)
	{
		this.magicDefenseUp = magicDefenseUp;
	}
	
	public CharacterEffect getMagicDefenseDown()
	{
		return magicDefenseDown;
	}
	
	public void setMagicDefenseDown(CharacterEffect magicDefenseDown)
	{
		this.magicDefenseDown = magicDefenseDown;
	}
	
	public CharacterEffect getDodgeUp()
	{
		return dodgeUp;
	}
	
	public void setDodgeUp(CharacterEffect dodgeUp)
	{
		this.dodgeUp = dodgeUp;
	}
	
	public CharacterEffect getDodgeDown()
	{
		return dodgeDown;
	}
	
	public void setDodgeDown(CharacterEffect dodgeDown)
	{
		this.dodgeDown = dodgeDown;
	}
	
	public CharacterEffect getMovementSpeedUp()
	{
		return movementSpeedUp;
	}
	
	public void setMovementSpeedUp(CharacterEffect movementSpeedUp)
	{
		this.movementSpeedUp = movementSpeedUp;
	}
	
	public CharacterEffect getMovementSpeedDown()
	{
		return movementSpeedDown;
	}
	
	public void setMovementSpeedDown(CharacterEffect movementSpeedDown)
	{
		this.movementSpeedDown = movementSpeedDown;
	}
	
	public CharacterEffect getAttackSpeedUp()
	{
		return attackSpeedUp;
	}
	
	public void setAttackSpeedUp(CharacterEffect attackSpeedUp)
	{
		this.attackSpeedUp = attackSpeedUp;
	}
	
	public CharacterEffect getAttackSpeedDown()
	{
		return attackSpeedDown;
	}
	
	public void setAttackSpeedDown(CharacterEffect attackSpeedDown)
	{
		this.attackSpeedDown = attackSpeedDown;
	}
	
	public CharacterEffect getCriticalUp()
	{
		return criticalUp;
	}
	
	public void setCriticalUp(CharacterEffect criticalUp)
	{
		this.criticalUp = criticalUp;
	}
	
	public CharacterEffect getCriticalDown()
	{
		return criticalDown;
	}
	
	public void setCriticalDown(CharacterEffect criticalDown)
	{
		this.criticalDown = criticalDown;
	}
	
	public CharacterEffect getPoisoned()
	{
		return poisoned;
	}
	
	public void setPoisoned(CharacterEffect poisoned)
	{
		this.poisoned = poisoned;
	}
	
	public CharacterEffect getFrozen()
	{
		return frozen;
	}
	
	public void setFrozen(CharacterEffect frozen)
	{
		this.frozen = frozen;
	}
	
	public CharacterEffect getBurned()
	{
		return burned;
	}
	
	public void setBurned(CharacterEffect burned)
	{
		this.burned = burned;
	}
	
	public CharacterEffect getStunned()
	{
		return stunned;
	}
	
	public void setStunned(CharacterEffect stunned)
	{
		this.stunned = stunned;
	}
	
	public CharacterEffect getBledding()
	{
		return bledding;
	}
	
	public void setBledding(CharacterEffect bledding)
	{
		this.bledding = bledding;
	}
	
	public CharacterEffect getStealth()
	{
		return stealth;
	}
	
	public void setStealth(CharacterEffect stealth)
	{
		this.stealth = stealth;
	}
	
	public CharacterEffect getCloacking()
	{
		return cloacking;
	}
	
	public void setCloacking(CharacterEffect cloacking)
	{
		this.cloacking = cloacking;
	}
	
	public CharacterType getType()
	{
		return CharacterType.UNKNOWN;
	}
	
	public List<? extends CharacterSkill> getSkills()
	{
		return Collections.emptyList();
	}
}
