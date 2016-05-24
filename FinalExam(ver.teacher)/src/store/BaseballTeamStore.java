package store;

import java.util.List;

import domain.BaseballTeam;


/**
 * BaseballTeamStore
 * 
 */
public interface BaseballTeamStore {

	public BaseballTeam retrieve(String teamId);
	public List<BaseballTeam> retrieveAll();
}
