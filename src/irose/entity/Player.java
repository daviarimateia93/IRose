package irose.entity;

import java.util.ArrayList;
import java.util.List;

import me.gerenciar.sdao.annotation.TableName;

@TableName("PLAYER")
public class Player extends Character
{
	private static transient final long serialVersionUID = 1490945766096913214L;
	
	private Account account;
	private int attributePoints;
	private int skillPoints;
	private CharacterArea respawn;
	private PlayerAttributes attributes;
	private List<PlayerSkill> skills = new ArrayList<>();
	
	// non persistent
	private PlayerAttributes finalAttributes;
	private CharacterEffect pvp;
	private CharacterEffect xpRateUp;
	private CharacterEffect dropRateUp;
	private CharacterEffect strengthUp;
	private CharacterEffect strengthDown;
	private CharacterEffect dexterityUp;
	private CharacterEffect dexterityDown;
	private CharacterEffect intelligenceUp;
	private CharacterEffect intelligenceDown;
	private CharacterEffect concentrationUp;
	private CharacterEffect concentrationDown;
	private CharacterEffect charmUp;
	private CharacterEffect charmDown;
	private CharacterEffect senseUp;
	private CharacterEffect senseDown;
	private float extraXpRate;
	private float extraDropRate;
	
	public Account getAccount()
	{
		return account;
	}
	
	public void setAccount(Account account)
	{
		this.account = account;
	}
	
	public int getAttributePoints()
	{
		return attributePoints;
	}
	
	public void setAttributePoints(int attributePoints)
	{
		this.attributePoints = attributePoints;
	}
	
	public int getSkillPoints()
	{
		return skillPoints;
	}
	
	public void setSkillPoints(int skillPoints)
	{
		this.skillPoints = skillPoints;
	}
	
	public CharacterArea getRespawn()
	{
		return respawn;
	}
	
	public void setRespawn(CharacterArea respawn)
	{
		this.respawn = respawn;
	}
	
	public PlayerAttributes getAttributes()
	{
		return attributes;
	}
	
	public void setAttributes(PlayerAttributes attributes)
	{
		this.attributes = attributes;
	}
	
	@Override
	public List<PlayerSkill> getSkills()
	{
		return skills;
	}
	
	public void setSkills(List<PlayerSkill> skills)
	{
		this.skills = skills;
	}
	
	@Override
	public CharacterType getType()
	{
		return CharacterType.PLAYER;
	}
	
	public PlayerAttributes getFinalAttributes()
	{
		return finalAttributes;
	}
	
	public void setFinalAttributes(PlayerAttributes finalAttributes)
	{
		this.finalAttributes = finalAttributes;
	}
	
	public CharacterEffect getPvp()
	{
		return pvp;
	}
	
	public void setPvp(CharacterEffect pvp)
	{
		this.pvp = pvp;
	}
	
	public CharacterEffect getXpRateUp()
	{
		return xpRateUp;
	}
	
	public void setXpRateUp(CharacterEffect xpRateUp)
	{
		this.xpRateUp = xpRateUp;
	}
	
	public CharacterEffect getDropRateUp()
	{
		return dropRateUp;
	}
	
	public void setDropRateUp(CharacterEffect dropRateUp)
	{
		this.dropRateUp = dropRateUp;
	}
	
	public CharacterEffect getStrengthUp()
	{
		return strengthUp;
	}
	
	public void setStrengthUp(CharacterEffect strengthUp)
	{
		this.strengthUp = strengthUp;
	}
	
	public CharacterEffect getStrengthDown()
	{
		return strengthDown;
	}
	
	public void setStrengthDown(CharacterEffect strengthDown)
	{
		this.strengthDown = strengthDown;
	}
	
	public CharacterEffect getDexterityUp()
	{
		return dexterityUp;
	}
	
	public void setDexterityUp(CharacterEffect dexterityUp)
	{
		this.dexterityUp = dexterityUp;
	}
	
	public CharacterEffect getDexterityDown()
	{
		return dexterityDown;
	}
	
	public void setDexterityDown(CharacterEffect dexterityDown)
	{
		this.dexterityDown = dexterityDown;
	}
	
	public CharacterEffect getIntelligenceUp()
	{
		return intelligenceUp;
	}
	
	public void setIntelligenceUp(CharacterEffect intelligenceUp)
	{
		this.intelligenceUp = intelligenceUp;
	}
	
	public CharacterEffect getIntelligenceDown()
	{
		return intelligenceDown;
	}
	
	public void setIntelligenceDown(CharacterEffect intelligenceDown)
	{
		this.intelligenceDown = intelligenceDown;
	}
	
	public CharacterEffect getConcentrationUp()
	{
		return concentrationUp;
	}
	
	public void setConcentrationUp(CharacterEffect concentrationUp)
	{
		this.concentrationUp = concentrationUp;
	}
	
	public CharacterEffect getConcentrationDown()
	{
		return concentrationDown;
	}
	
	public void setConcentrationDown(CharacterEffect concentrationDown)
	{
		this.concentrationDown = concentrationDown;
	}
	
	public CharacterEffect getCharmUp()
	{
		return charmUp;
	}
	
	public void setCharmUp(CharacterEffect charmUp)
	{
		this.charmUp = charmUp;
	}
	
	public CharacterEffect getCharmDown()
	{
		return charmDown;
	}
	
	public void setCharmDown(CharacterEffect charmDown)
	{
		this.charmDown = charmDown;
	}
	
	public CharacterEffect getSenseUp()
	{
		return senseUp;
	}
	
	public void setSenseUp(CharacterEffect senseUp)
	{
		this.senseUp = senseUp;
	}
	
	public CharacterEffect getSenseDown()
	{
		return senseDown;
	}
	
	public void setSenseDown(CharacterEffect senseDown)
	{
		this.senseDown = senseDown;
	}
	
	public float getExtraXpRate()
	{
		return extraXpRate;
	}
	
	public void setExtraXpRate(float extraXpRate)
	{
		this.extraXpRate = extraXpRate;
	}
	
	public float getExtraDropRate()
	{
		return extraDropRate;
	}
	
	public void setExtraDropRate(float extraDropRate)
	{
		this.extraDropRate = extraDropRate;
	}
}
