package irose.entity;

import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("CHARACTER_AREA")
public class CharacterArea extends Gateway
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