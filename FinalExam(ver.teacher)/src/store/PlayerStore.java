package store;

import java.util.List;

import domain.Player;

/**
 * PlayerStore
 * 
 */
public interface PlayerStore {

	public void update(Player player);
	public Player retrieve(String playerId);
	public List<Player> retrieveByTeam(String teamId);
}
