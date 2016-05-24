package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.User;
import store.UserStore;
import store.factory.ConnectionFactory;
import store.logic.util.JdbcUtils;

public class UserStoreLogic implements UserStore {
	
	private ConnectionFactory connectionFactory;
	
	public UserStoreLogic() {
		connectionFactory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(User user) {
		//
		Connection connection = null;
		PreparedStatement psmt = null;
		int createdCount = 0;
		
		try {
			connection = connectionFactory.createConnection();
			
			psmt = connection.prepareStatement("INSERT INTO USER_TB(LOGINID, PASSWORD, NAME) VALUES (?,?,?)");
			
			psmt.setString(1, user.getLoginId());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getName());

			createdCount = psmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(psmt, connection);
		}

		return createdCount > 0;
	}

	@Override
	public User read(String id) {
		//
//		String sql = "SELECT LOGINID, PASSWORD, NAME FROM USER_TB WHERE LOGINID = ?" ;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User user = null;

		try {
			conn = connectionFactory.createConnection();
			
			psmt = conn.prepareStatement("SELECT LOGINID, PASSWORD, NAME FROM USER_TB WHERE LOGINID = ?");
		
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setLoginId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(rs, psmt, conn);
		}

		return user;
	}

}
