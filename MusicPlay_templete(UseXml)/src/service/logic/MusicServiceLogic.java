package service.logic;

import java.util.List;

import domain.Music;
import service.MusicService;
import store.MusicStore;
import store.logic.MusicStoreLogic;

public class MusicServiceLogic implements MusicService {
	
	private MusicStore musicStore;

	public MusicServiceLogic() {
		musicStore = new MusicStoreLogic();
	}
	
	@Override
	public Music find(int id) {
		// 곡 찾기
		return musicStore.read(id);
	}

	@Override
	public List<Music> findByName(String name) {
		// 이름으로 곡 찾기
		return musicStore.readByName(name);
	}

	@Override
	public List<Music> findAll() {
		// 전체 곡 리스트로 띄우기
		return musicStore.readAll();
	}

}
