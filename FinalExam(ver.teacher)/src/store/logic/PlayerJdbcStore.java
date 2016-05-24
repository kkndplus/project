package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Player;
import store.PlayerStore;
import store.factory.ConnectionFactory;

public class PlayerJdbcStore implements PlayerStore {


	@Override
	public void update(Player player) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE player_tb ");
		sqlBuilder.append("   SET teamId = ? ");
		sqlBuilder.append("       ,name = ? ");
		sqlBuilder.append("       ,backNumber = ? ");
		sqlBuilder.append("       ,position = ? ");
		sqlBuilder.append("       ,hitting = ? ");
		sqlBuilder.append("       ,throw = ? ");
		sqlBuilder.append(" WHERE id = ? ");
		
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString())) {
			pstmt.setString(1, player.getTeamId());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getBackNumber());
			pstmt.setString(4, player.getPosition());
			pstmt.setString(5, player.getHittingHand());
			pstmt.setString(6, player.getThrowHand());
			pstmt.setString(7, player.getPlayerId());
			
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL수행중 오류가 발생했습니다.");
		}
	}

	@Override
	public Player retrieve(String playerId) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT id ");
		sqlBuilder.append("       ,teamId ");
		sqlBuilder.append("       ,name ");
		sqlBuilder.append("       ,backNumber ");
		sqlBuilder.append("       ,position ");
		sqlBuilder.append("       ,hitting ");
		sqlBuilder.append("       ,throw ");
		sqlBuilder.append("  FROM player_tb ");
		sqlBuilder.append(" WHERE id = '" + playerId + "'");
		
		Player player = null;
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamId"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL수행중 오류가 발생했습니다.");
		}
		
		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT id ");
		sqlBuilder.append("       ,teamId ");
		sqlBuilder.append("       ,name ");
		sqlBuilder.append("       ,backNumber ");
		sqlBuilder.append("       ,position ");
		sqlBuilder.append("       ,hitting ");
		sqlBuilder.append("       ,throw ");
		sqlBuilder.append("  FROM player_tb ");
		sqlBuilder.append(" WHERE teamId = '" + teamId + "'");
		
		List<Player> players = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				Player player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setTeamId(rs.getString("teamId"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backNumber"));
				player.setPosition(rs.getString("position"));
				player.setHittingHand(rs.getString("hitting"));
				player.setThrowHand(rs.getString("throw"));
				
				players.add(player);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL수행중 오류가 발생했습니다.");
		}
		
		return players;
	}

}
