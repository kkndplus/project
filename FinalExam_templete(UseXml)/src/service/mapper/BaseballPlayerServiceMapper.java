package service.mapper;

import java.util.List;

import domain.Player;

public interface BaseballPlayerServiceMapper {

	//선수 찾기
	public Player findPlayer(String playerId);
	
	//해당 팀에 속한 선수 찾기
	public List<Player> findPlayerByTeam(String teamId);
		
	//모든 선수 찾기
	public List<Player> findAllPlayer();
	
	//선수 트레이드
	public void tradePlayer(String sourcePlayerId, String targetPlayerId);
}
