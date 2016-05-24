package store.logic;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BaseballTeam;
import store.BaseballTeamStore;
import store.mapper.BaseballTeamStoreMapper;

public class BaseballTeamStoreLogic implements BaseballTeamStore {

	private final String RESOURCE = "store/config.xml";
	private SqlSessionFactory factory;

	private SqlSessionFactory createSessionFactory() {

		if (factory == null) {
			try {
				Reader reader = Resources.getResourceAsReader(RESOURCE);
				factory = new SqlSessionFactoryBuilder().build(reader);
			} catch (IOException e) {
				throw new RuntimeException("MyBatis Factory Error");
			}
		}
		return factory;
	}
	
	private BaseballTeamStoreMapper getBaseballTeamStoreMapper(){
		return createSessionFactory().openSession(true).getMapper(BaseballTeamStoreMapper.class);
	}

	@Override
	public BaseballTeam retrieve(String teamId) {
		return getBaseballTeamStoreMapper().retrieve(teamId);
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		return getBaseballTeamStoreMapper().retrieveAll();
	}

}
