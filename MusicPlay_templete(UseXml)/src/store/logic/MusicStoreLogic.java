package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.Music;
import store.MusicStore;

public class MusicStoreLogic implements MusicStore {

	private SqlSessionFactory factory;
	
	public MusicStoreLogic(){
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public Music read(int id) {
		SqlSession session = factory.openSession();
		Music music = null;
		try {
			music = session.selectOne("readById", id);
		} finally {
			session.close();
		}
		return music;
	}

	@Override
	public List<Music> readByName(String name) {
		SqlSession session = factory.openSession();
		List<Music> list = null;
		try {
			list = session.selectList("readByName", name);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Music> readAll() {
		SqlSession session = factory.openSession();
		List<Music> list = null;
		try {
			list = session.selectList("readAll");
		} finally {
			session.close();
		}
		return list;
	}

}
