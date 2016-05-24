package store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import domain.BaseballTeam;

public interface BaseballTeamStoreMapper {
	//팀 아이디 입력시 해당 팀 전송
	@Select("SELECT id as teamId, name as name, "
			+ "region as region, manager as manager, "
			+ "stadium as stadium, logo "
			+ "FROM team_tb "
			+ "WHERE id = #{param1};")
	public BaseballTeam retrieve(String teamId);
	
	//저장된 모든 팀 전송
	@Select("SELECT id as teamId, name as name, "
			+ "region as region, manager as manager, "
			+ "stadium as stadium, logo "
			+ "FROM team_tb;")
	public List<BaseballTeam> retrieveAll();
}
