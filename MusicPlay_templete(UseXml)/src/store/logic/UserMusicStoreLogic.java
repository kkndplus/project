package store.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.Music;
import store.UserMusicStore;

public class UserMusicStoreLogic implements UserMusicStore {

	private SqlSessionFactory factory;

	public UserMusicStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean create(String userId, int music_id) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("music_id", music_id);
		int count = 0;
		try {
			count = session.insert("createUserMusic", map);
			session.commit();
		} finally {
			session.close();
		}
		return count>0;
	}

	@Override
	public boolean delete(String userId, int music_id) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("music_id", music_id);
		int count = 0;
		try {
			count = session.delete("deleteUserMusic", map);
			session.commit();
		} finally {
			session.close();
		}
		return count>0;
	}

	@Override
	public boolean existUserMusic(String userId, int music_id) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("music_id", music_id);
		try {
			if (session.selectOne("existUserMusic", map) != null) {
				return true;
			} else
				return false;
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		SqlSession session = factory.openSession();
		List<Music> list = new ArrayList<Music>();
		try {
			List<String> music_id = session.selectList("readUserMusic", userId);
			for(String musicId : music_id){
				Music music = session.selectOne("readMusicsByUser", musicId);
				System.out.println(music.getAlbum());
				list.add(music);
			}
		} finally {
			session.close();
		}
		return list;
	}

}
