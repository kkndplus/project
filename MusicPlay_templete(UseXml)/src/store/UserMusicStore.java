package store;

import java.util.List;

import domain.Music;

public interface UserMusicStore {
	//
	boolean create(String userId, int music_id);
	boolean delete(String userId, int music_id);
	boolean existUserMusic(String userId, int music_id);
	List<Music> readMusicsByUser(String userId);
}
