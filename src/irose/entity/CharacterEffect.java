package irose.entity;

import java.util.Date;

import irose.util.BaseEntity;

public class CharacterEffect extends BaseEntity
{
	private static transient final long serialVersionUID = -3950889283531756817L;
	
	// non persistent
	private String duration;
	private Date buffTime;
	
	public String getDuration()
	{
		return duration;
	}
	
	public void setDuration(String duration)
	{
		this.duration = duration;
	}
	
	public Date getBuffTime()
	{
		return buffTime;
	}
	
	public void setBuffTime(Date buffTime)
	{
		this.buffTime = buffTime;
	}
}
