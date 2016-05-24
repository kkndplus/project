package service;
import java.util.List;

import domain.Music;


public interface UserMusicService {
	//
	boolean register(String userId, int musicId);
	boolean remove(String userId, int musicId);
	List<Music> findMusicsByUser(String userId);
}
