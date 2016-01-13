package irose.server.service;

import java.util.HashMap;
import java.util.Map;

import irose.entity.Player;

public class WorldService
{
	private static Map<Long, Player> connectedPlayers = new HashMap<>();
	
	public Player getByPlayerId(Long playerId)
	{
		return connectedPlayers.get(playerId);
	}
}
