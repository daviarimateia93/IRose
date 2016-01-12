package irose.util;

import java.io.Serializable;

import me.gerenciar.sjson.parser.Writer;

public abstract class BaseEntity implements Serializable
{
	private transient static final long serialVersionUID = -7983427912407793423L;
	
	private transient Writer writer = new Writer();
	
	@Override
	public String toString()
	{
		return writer.write(this);
	}
	
	@Override
	public boolean equals(Object object)
	{
		return toString().equals(writer.write(object));
	}
	
	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
}
