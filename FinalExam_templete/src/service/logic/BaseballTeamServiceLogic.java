package service.logic;

import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import service.impl.BaseballPlayerServiceImpl;
import service.impl.BaseballTeamServiceImpl;

public class BaseballTeamServiceLogic implements BaseballTeamService {

	private BaseballTeamServiceImpl baseballTeamService;
	private BaseballPlayerServiceImpl baseballPlayerService;

	public BaseballTeamServiceLogic() {
		baseballTeamService = new BaseballTeamServiceImpl();
		baseballPlayerService = new BaseballPlayerServiceImpl();
	}

	// team
	// 팀 아이디로 해당 팀 선택
	public BaseballTeam findTeam(String teamId) {
		return baseballTeamService.findTeam(teamId);
	}

	// 모든 팀 선택
	public List<BaseballTeam> findAllTeams() {
		return baseballTeamService.findAllTeams();
	}

	// 모든 선수 선택(선수 목록 출력)
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		
		List<BaseballTeam> list = new ArrayList<BaseballTeam>();
		List<BaseballTeam> teams = this.findAllTeams();
		for(BaseballTeam team:teams){
			List<Player> players = this.findPlayerByTeam(team.getTeamId());
			team.setPlayers(players);
			list.add(team);
		}
		return list;
	}

	// 트레이드 하기 위해 해당 팀 이외의 선수들 출력
	public List<BaseballTeam> findTradeTargetPlayers(String teamId) {
		List<BaseballTeam> list = baseballTeamService.findTradeTargetPlayers(teamId);
		for (BaseballTeam team : list) {
			List<Player> player = baseballPlayerService.findPlayerByTeam(team.getTeamId());
			team.setPlayers(player);
		}
		return list;
	}

	// player
	// 선수 찾기
	public Player findPlayer(String playerId) {
		return baseballPlayerService.findPlayer(playerId);
	}

	// 선수 트레이드
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		baseballPlayerService.tradePlayer(sourcePlayerId, targetPlayerId);
	}

	// 전체 선수 찾기
	public List<Player> findAllPlayer() {
		return baseballPlayerService.findAllPlayer();
	}

	// 팀별 선수 목록
	public List<Player> findPlayerByTeam(String teamId) {
		return baseballPlayerService.findPlayerByTeam(teamId);
	}
}
