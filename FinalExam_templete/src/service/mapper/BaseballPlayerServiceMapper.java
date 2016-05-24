package service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import domain.Player;

public interface BaseballPlayerServiceMapper {

	//선수 찾기
	@Select("SELECT id as playerId, name, backnumber, position, "
			+ "hitting, teamid, throw as throwing "
			+ "FROM player_tb "
			+ "WHERE id=#{param1}")
	public Player findPlayer(String playerId);
	
	//해당 팀에 속한 선수 찾기
	@Select("SELECT id as playerId, name, backnumber, position, "
			+ "hitting, teamid, throw as throwing "
			+ "FROM player_tb "
			+ "WHERE teamid=#{param1}")
	public List<Player> findPlayerByTeam(String teamId);
		
	//모든 선수 찾기
	@Select("SELECT p.id as playerId, p.name, p.backnumber, p.position, "
			+ "p.hitting, p.name, p.throw as throwing "
			+ "FROM player_tb p")
	public List<Player> findAllPlayer();
	
	//선수 트레이드
	@Update("UPDATE player_tb AS p1 "
			+ "JOIN player_tb AS p2 "
			+ "ON (p1.id = #{param1} AND p2.id = #{param2}) "
			+ "SET p1.teamid = p2.teamid, "
			+ "p2.teamid = p1.teamid; ")
	public void tradePlayer(String sourcePlayerId, String targetPlayerId);
}
