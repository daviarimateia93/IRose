package irose.entity;

import java.util.ArrayList;
import java.util.List;

import me.gerenciar.sdao.annotation.Generated;
import me.gerenciar.sdao.annotation.Identifier;
import me.gerenciar.sdao.annotation.TableName;
import me.gerenciar.sjson.gateway.Gateway;
import me.gerenciar.stp.gateway.Peer;

@TableName("ACCOUNT")
public class Account extends Gateway
{
	private static transient final long serialVersionUID = 712815442503981486L;
	
	@Identifier("ID")
	@Generated("ID")
	private Long id;
	private String nickname;
	private String password;
	private String email;
	private boolean logged;
	private List<Player> players = new ArrayList<>();
	
	// non persistent
	private Peer peer;
	
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getNickname()
	{
		return nickname;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public boolean isLogged()
	{
		return logged;
	}
	
	public void setLogged(boolean logged)
	{
		this.logged = logged;
	}
	
	public List<Player> getPlayers()
	{
		return players;
	}
	
	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}
	
	public Peer getPeer()
	{
		return peer;
	}
	
	public void setPeer(Peer peer)
	{
		this.peer = peer;
	}
}
