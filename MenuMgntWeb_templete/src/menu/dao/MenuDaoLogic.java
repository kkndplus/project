package menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import menu.entity.Menu;
import menu.util.exception.NamooMenuException;

@Repository
public class MenuDaoLogic implements MenuDao {

	@Override
	public void create(Menu menu) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("INSERT INTO menu_tb ");
		sqlBuilder.append("   (id, menu_cd, menu_name, display_seq, url) ");
		sqlBuilder.append(" VALUES ");
		sqlBuilder.append("   (menu_tb_seq.nextVal, ?, ?, ?, ?) ");
		
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString())) {
			pstmt.setString(1, menu.getCode());
			pstmt.setString(2, menu.getName());
			pstmt.setInt(3, menu.getDisplaySeq());
			pstmt.setString(4, menu.getUrl());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new NamooMenuException("SQL수행중 오류가 발생했습니다.");
		}
	}

	@Override
	public Menu retrieve(String id) {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ");
		sqlBuilder.append("        id, menu_cd, menu_name, display_seq, url ");
		sqlBuilder.append("  FROM menu_tb ");
		sqlBuilder.append(" WHERE id = '" + id + "'");
		
		Menu menu = null;
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				menu = new Menu();
				menu.setId(rs.getString("id"));
				menu.setCode(rs.getString("menu_cd"));
				menu.setName(rs.getString("menu_name"));
				menu.setDisplaySeq(rs.getInt("display_seq"));
				menu.setUrl(rs.getString("url"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new NamooMenuException("SQL수행중 오류가 발생했습니다.");
		}
		
		return menu;
	}

	@Override
	public List<Menu> retrieveAllMenus() {
		//
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ");
		sqlBuilder.append("        id, menu_cd, menu_name, display_seq, url ");
		sqlBuilder.append("  FROM menu_tb ");
		sqlBuilder.append(" ORDER BY display_seq ASC ");
		
		List<Menu> allMenus = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().createConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlBuilder.toString())) {
			
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getString("id"));
				menu.setCode(rs.getString("menu_cd"));
				menu.setName(rs.getString("menu_name"));
				menu.setDisplaySeq(rs.getInt("display_seq"));
				menu.setUrl(rs.getString("url"));
				allMenus.add(menu);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new NamooMenuException("SQL수행중 오류가 발생했습니다.");
		}
		
		return allMenus;
	}

}
