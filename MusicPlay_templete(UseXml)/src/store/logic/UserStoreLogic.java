package store.logic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.User;
import store.UserStore;

public class UserStoreLogic implements UserStore {

	private SqlSessionFactory factory;

	public UserStoreLogic(){
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	@Override
	public void create(User user) {
		SqlSession session = factory.openSession();
		try {
			session.insert("createUser", user);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public User read(String id) {
		SqlSession session = factory.openSession();
		User user = null;
		try {
			user = session.selectOne("readUser", id);
		} finally {
			session.close();
		}
		return user;
	}

}
