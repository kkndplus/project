package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.factory.ConnectionFactory;


public class BaseballTeamJdbcStore implements BaseballTeamStore {

	@Override
	public BaseballTeam retrieve(String teamId) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT id ");
		sqlBuilder.append("       ,name ");
		sqlBuilder.append("       ,region ");
		sqlBuilder.append("       ,manager ");
		sqlBuilder.append("       ,stadium ");
		sqlBuilder.append("       ,logo ");
		sqlBuilder.append("  FROM team_tb ");
		sqlBuilder.append(" WHERE id = '" + teamId + "'");
		
		BaseballTeam team = null;
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL수행중 오류가 발생했습니다.");
		}
		
		return team;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT id ");
		sqlBuilder.append(",name ");
		sqlBuilder.append(",region ");
		sqlBuilder.append(",manager ");
		sqlBuilder.append(",stadium ");
		sqlBuilder.append(",logo ");
		sqlBuilder.append("FROM team_tb ");
		
		List<BaseballTeam> teams = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				BaseballTeam team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				
				teams.add(team);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL수행중 오류가 발생했습니다.");
		}
		
		return teams;
	}

}
