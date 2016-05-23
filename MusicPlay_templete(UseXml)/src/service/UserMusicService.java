package service;
import java.util.List;

import domain.Music;


public interface UserMusicService {
	//
	void register(String userId, int music_id);
	void remove(String userId, int music_id);
	List<Music> findMusicsByUser(String userId);
}
