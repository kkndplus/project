package service.logic;

import java.util.List;

import domain.Music;
import service.UserMusicService;
import store.UserMusicStore;
import store.logic.UserMusicStoreLogic;

public class UserMusicServiceLogic implements UserMusicService {

	private UserMusicStore musicService;

	public UserMusicServiceLogic() {
		musicService = new UserMusicStoreLogic();
	}

	@Override
	public void register(String userId, int music_id) {
		// 재생목록 곡 등록
		if (musicService.existUserMusic(userId, music_id)) {
			throw new RuntimeException("이미 곡이 저장되어 있습니다.");
		}
		musicService.create(userId, music_id);
	}

	@Override
	public void remove(String userId, int music_id) {
		// 재생목록 곡 삭제
		musicService.delete(userId, music_id);
	}

	@Override
	public List<Music> findMusicsByUser(String userId) {
		// 해당 유저의 재생목록 찾기
		return musicService.readMusicsByUser(userId);
	}

}
