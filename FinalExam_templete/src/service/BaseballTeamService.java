package service;

import java.util.List;

import domain.BaseballTeam;
import domain.Player;

public interface BaseballTeamService {

	//team
	//팀 아이디로 해당 팀 선택
	public BaseballTeam findTeam(String teamId);
	//모든 팀 선택
	public List<BaseballTeam> findAllTeams();
	//모든 선수 선택(선수 목록 출력)
	public List<BaseballTeam> findAllTeamsWithPlayers();
	//트레이드 하기 위해 해당 팀 이외의 선수들 출력
	public List<BaseballTeam> findTradeTargetPlayers(String teamId);
	
	//player
	//선수 찾기
	public Player findPlayer(String playerId);
	
	//선수 트레이드
	public void tradePlayer(String sourcePlayerId, String targetPlayerId);
	
	//전체 선수 찾기
	public List<Player> findAllPlayer() ;

	//팀별 선수 목록
	public List<Player> findPlayerByTeam(String teamId);
}
