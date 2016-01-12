package irose.entity;

import irose.util.BaseEntity;
import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;

@TableName("MAP")
public class Map extends BaseEntity
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
