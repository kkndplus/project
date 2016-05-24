package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.BaseballTeamStore;
import store.PlayerStore;
import store.logic.BaseballTeamJdbcStore;
import store.logic.PlayerJdbcStore;

public class BaseballTeamServiceLogic implements BaseballTeamService {

	private BaseballTeamStore teamStore = new BaseballTeamJdbcStore();
	private PlayerStore playerStore = new PlayerJdbcStore();
	
	@Override
	public BaseballTeam findTeam(String teamId) {
		BaseballTeam team = teamStore.retrieve(teamId);
		if(team == null) {
			return null;
		}
		
		List<Player> players = playerStore.retrieveByTeam(teamId);
		team.setPlayers(players);
		
		return team;
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return teamStore.retrieveAll();
	}

	@Override
	public Player findPlayer(String playerId) {
		return playerStore.retrieve(playerId);
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		List<BaseballTeam> teams = teamStore.retrieveAll();
		for(BaseballTeam team : teams) {
			List<Player> players = playerStore.retrieveByTeam(team.getTeamId());
			team.setPlayers(players);
		}
		
		return teams;
	}
	
	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		List<BaseballTeam> teams = teamStore.retrieveAll();
		List<BaseballTeam> targetTeams = new ArrayList<BaseballTeam>();
		for(BaseballTeam team : teams) {
			if(!teamId.equals(team.getTeamId())) {
				targetTeams.add(team);
			}
		}
		
		for(BaseballTeam team : targetTeams) {
			List<Player> players = playerStore.retrieveByTeam(team.getTeamId());
			team.setPlayers(players);
		}
		
		return targetTeams;
		
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		
		Player sourcePlayer = playerStore.retrieve(sourcePlayerId);
		Player targetPlayer = playerStore.retrieve(targetPlayerId);
		String sourceTeam = sourcePlayer.getTeamId();
		String targetTeam = targetPlayer.getTeamId();
		sourcePlayer.setTeamId(targetTeam);
		targetPlayer.setTeamId(sourceTeam);
		playerStore.update(sourcePlayer);
		playerStore.update(targetPlayer);
	}

}
