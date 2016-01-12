package irose.entity;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;

@TableName("CHARACTER_AREA")
public class CharacterArea extends BaseEntity
{
	private static transient final long serialVersionUID = 9061197192568282557L;
	
	@Identifier("ID")
	@Generated("ID")
	private Long id;
	private Location location;
	private double radius;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Location getLocation()
	{
		return location;
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
}