package service.mapper;

import java.util.List;

import domain.BaseballTeam;

public interface BaseballTeamServiceMapper {
	
	//팀 아이디로 해당 팀 선택
	public BaseballTeam findTeam(String teamId);
	
	//모든 팀 선택
	public List<BaseballTeam> findAllTeams();
	
	//모든 선수 선택(선수 목록 출력) (준비작업을 위해 모든 팀 출력)
	public List<BaseballTeam> findAllTeamsWithPlayers();
	
	//트레이드 하기 위해 해당 팀 이외의 선수들 출력 (준비작업을 위해 해당 팀 제외한 팀들 출력)
	public List<BaseballTeam> findTradeTargetPlayers(String teamId);
}
