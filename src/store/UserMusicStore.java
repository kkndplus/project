package store;

import java.util.List;

import domain.Music;

public interface UserMusicStore {
	//
	boolean create(String userId, int musicId);
	boolean delete(String userId, int musicId);
	boolean existUserMusic(String userId, int musicId);
	List<Music> readMusicsByUser(String userId);
}
