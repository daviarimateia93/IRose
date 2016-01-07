package irose.entity;

import irose.util.Point;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("LOCATION")
public class Location extends Gateway
{
	private static final long serialVersionUID = 1783681274525045728L;
	
	@Identifier("ID")
	private Long id;
	private Point point;
	private Map map;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public Point getPoint()
	{
		return point;
	}
	
	public void setPoint(Point point)
	{
		this.point = point;
	}
	
	public Map getMap()
	{
		return map;
	}
	
	public void setMap(Map map)
	{
		this.map = map;
	}
}
