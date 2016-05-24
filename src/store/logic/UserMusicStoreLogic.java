package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.UserMusicStore;
import store.factory.ConnectionFactory;
import store.logic.util.JdbcUtils;

public class UserMusicStoreLogic implements UserMusicStore {
	
	private ConnectionFactory connectionFactory;
	
	public UserMusicStoreLogic() {
		connectionFactory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean create(String userId, int musicId) {
		//
		Connection connection = null;
		PreparedStatement psmt = null;
		int createdCount = 0;
		try {
			connection = connectionFactory.createConnection();
			
			psmt = connection.prepareStatement("INSERT INTO USER_MUSIC_TB (USER_ID, MUSIC_ID) VALUES (?, ?)");
			
			psmt.setString(1, userId);
			psmt.setInt(2, musicId);

			createdCount = psmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(psmt, connection);
		}

		return createdCount > 0;
	}

	@Override
	public boolean delete(String userId, int musicId) {
		//
		Connection connection = null;
		PreparedStatement psmt = null;
		int deleteCount = 0;
		try {
			connection = connectionFactory.createConnection();
			
			psmt = connection.prepareStatement("DELETE FROM USER_MUSIC_TB WHERE MUSIC_ID = ? AND USER_ID = ?");
			psmt.setInt(1, musicId);
			psmt.setString(2, userId);

			deleteCount = psmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(psmt, connection);
		}

		return deleteCount > 0;
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		//
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MZ.ID, MZ.NAME, MZ.ARTIST_NAME, MZ.ALBUM_TITLE, MZ.IMAGE, MZ.AGENT_NAME ");
		sql.append("FROM MUSIC_TB MZ ");
		sql.append("JOIN USER_MUSIC_TB UM ");
		sql.append("ON MZ.ID = UM.MUSIC_ID ");
		sql.append("WHERE UM.USER_ID = ?");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Music> musics = new ArrayList<Music>();

		try {
			conn = connectionFactory.createConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Music music = new Music();
				music.setId(rs.getInt(1));
				music.setName(rs.getString(2));
				music.setArtist(rs.getString(3));
				music.setAlbum(rs.getString(4));
				music.setImage(rs.getString(5));
				music.setAgent(rs.getString(6));
				musics.add(music);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(rs, pstmt, conn);
		}

		return musics;
	}

	@Override
	public boolean existUserMusic(String userId, int musicId) {
		//
		Connection connection = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			connection = connectionFactory.createConnection();
			
			psmt = connection.prepareStatement("SELECT MUSIC_ID FROM USER_MUSIC_TB WHERE MUSIC_ID = ? AND USER_ID = ?");
			psmt.setInt(1, musicId);
			psmt.setString(2, userId);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(rs, psmt, connection);
		}

		return false;
	}

}
