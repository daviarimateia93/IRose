package irose.entity;

import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("CHARACTER_SKILL")
public class CharacterSkill extends Gateway
{
	private static transient final long serialVersionUID = -7875118954969791477L;
	
	@Identifier("ID")
	@Generated("ID")
	private Long id;
	private CharacterSkillRange range;
	private CharacterSkillCategory category;
	private CharacterSkillType type;
	private int duration;
	private int countDown;
	private int value;
	private float valuePercent;
	private int mp;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public CharacterSkillRange getRange()
	{
		return range;
	}
	
	public void setRange(CharacterSkillRange range)
	{
		this.range = range;
	}
	
	public CharacterSkillCategory getCategory()
	{
		return category;
	}
	
	public void setCategory(CharacterSkillCategory category)
	{
		this.category = category;
	}
	
	public CharacterSkillType getType()
	{
		return type;
	}
	
	public void setType(CharacterSkillType type)
	{
		this.type = type;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	public int getCountDown()
	{
		return countDown;
	}
	
	public void setCountDown(int countDown)
	{
		this.countDown = countDown;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public float getValuePercent()
	{
		return valuePercent;
	}
	
	public void setValuePercent(float valuePercent)
	{
		this.valuePercent = valuePercent;
	}
	
	public int getMp()
	{
		return mp;
	}
	
	public void setMp(int mp)
	{
		this.mp = mp;
	}
}
