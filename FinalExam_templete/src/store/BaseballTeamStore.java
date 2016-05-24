package store;

import java.util.List;

import domain.BaseballTeam;

public interface BaseballTeamStore {
	//팀 아이디 입력시 해당 팀 정보 전송
	public BaseballTeam retrieve(String teamId);
	//저장된 모든 정보 전송
	public List<BaseballTeam> retrieveAll();
}
