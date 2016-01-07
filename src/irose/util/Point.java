package irose.util;

import me.gerenciar.sjson.gateway.Gateway;

public class Point extends Gateway
{
	private static final long serialVersionUID = 6351514818335154730L;
	
	private double x;
	private double y;
	private double z;
	
	public Point()
	{
	}
	
	public Point(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX()
	{
		return x;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public double getZ()
	{
		return z;
	}
	
	public void setZ(double z)
	{
		this.z = z;
	}
	
	public double distance(Point point)
	{
		double xd = x - point.getX();
		double yd = y - point.getY();
		double zd = z - point.getZ();
		
		return Math.sqrt(xd * xd + yd * yd + zd * zd);
	}
}
