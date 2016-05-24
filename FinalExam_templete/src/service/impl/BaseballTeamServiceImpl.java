package service.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BaseballTeam;
import service.mapper.BaseballTeamServiceMapper;

public class BaseballTeamServiceImpl implements BaseballTeamServiceMapper {

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
	
	private BaseballTeamServiceMapper getBaseballTeamServiceMapper(){
		return createSessionFactory().openSession(true).getMapper(BaseballTeamServiceMapper.class);
	}

	
	@Override
	public BaseballTeam findTeam(String teamId) {
		return getBaseballTeamServiceMapper().findTeam(teamId);
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return getBaseballTeamServiceMapper().findAllTeams();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		return getBaseballTeamServiceMapper().findAllTeamsWithPlayers();
	}

	@Override
	public List<BaseballTeam> findTradeTargetPlayers(String teamId) {
		return getBaseballTeamServiceMapper().findTradeTargetPlayers(teamId);
	}

}
