package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Music;
import store.MusicStore;
import store.factory.ConnectionFactory;
import store.logic.util.JdbcUtils;


public class MusicStoreLogic implements MusicStore {
	
	private ConnectionFactory connectionFactory;
	
	public MusicStoreLogic() {
		connectionFactory = ConnectionFactory.getInstance();
	}

	@Override
	public Music read(int id) {
		//
		String sql = "SELECT ID, NAME, ARTIST_NAME, ALBUM_TITLE, IMAGE, AGENT_NAME FROM MUSIC_TB WHERE ID = ?" ;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Music music = null;

		try {
			conn = connectionFactory.createConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				music = new Music();
				music.setId(rs.getInt(1));
				music.setName(rs.getString(2));
				music.setArtist(rs.getString(3));
				music.setAlbum(rs.getString(4));
				music.setImage(rs.getString(5));
				music.setAgent(rs.getString(6));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.close(rs, psmt, conn);
		}

		return music;
	}

	@Override
	public List<Music> readByName(String name) {
		//
		String sql = "SELECT ID, NAME, ARTIST_NAME, ALBUM_TITLE, IMAGE, AGENT_NAME FROM MUSIC_TB WHERE NAME LIKE ?" ;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		List<Music> musics = new ArrayList<Music>();

		try {
			conn = connectionFactory.createConnection();
			psmt = conn.prepareStatement(sql.toString());
			psmt.setString(1, "%"+name+"%");
			rs = psmt.executeQuery();
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
			JdbcUtils.close(rs, psmt, conn);
		}

		return musics;
	}

	@Override
	public List<Music> readAll() {
		//
		String sql = "SELECT ID, NAME, ARTIST_NAME, ALBUM_TITLE, IMAGE, AGENT_NAME FROM MUSIC_TB" ;

		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Music> musics = new ArrayList<Music>();

		try {
			conn = connectionFactory.createConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
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
			JdbcUtils.close(rs, statement, conn);
		}

		return musics;
	}

}
