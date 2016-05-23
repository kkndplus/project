package store.mapper;

import java.util.List;

import domain.Music;

public interface UserMusicStoreMapper {
	
	void create(String userId, int music_id);
	
	void delete(String userId, int music_id);
	
	void existUserMusic(String userId, int music_id);
	
	List<Music> readMusicsByUser(String userId);
}
