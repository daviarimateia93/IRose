package irose.entity;

import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("CHARACTER_SKILL")
public class CharacterSkill extends Gateway
{
	private static final long serialVersionUID = -7875118954969791477L;
	
	@Identifier("ID")
	private Long id;
	private CharacterSkillRange range;
	private CharacterSkillCategory category;
	private CharacterSkillType type;
	private long duration;
	private long countDown;
	private long value;
	private double valuePercent;
	private long mp;
	
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
	
	public long getDuration()
	{
		return duration;
	}
	
	public void setDuration(long duration)
	{
		this.duration = duration;
	}
	
	public long getCountDown()
	{
		return countDown;
	}
	
	public void setCountDown(long countDown)
	{
		this.countDown = countDown;
	}
	
	public long getValue()
	{
		return value;
	}
	
	public void setValue(long value)
	{
		this.value = value;
	}
	
	public double getValuePercent()
	{
		return valuePercent;
	}
	
	public void setValuePercent(double valuePercent)
	{
		this.valuePercent = valuePercent;
	}
	
	public long getMp()
	{
		return mp;
	}
	
	public void setMp(long mp)
	{
		this.mp = mp;
	}
}
