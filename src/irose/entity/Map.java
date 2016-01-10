package irose.entity;

import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;

@TableName("MAP")
public class Map extends Gateway
{
	private static transient final long serialVersionUID = -8761115606945580127L;
	
	@Identifier("ID")
	@Generated("ID")
	public Long id;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
}
