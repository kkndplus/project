package service.impl;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Player;
import service.mapper.BaseballPlayerServiceMapper;

public class BaseballPlayerServiceImpl implements BaseballPlayerServiceMapper {

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
	
	private BaseballPlayerServiceMapper getBaseballPlayerServiceMapper(){
		return createSessionFactory().openSession(true).getMapper(BaseballPlayerServiceMapper.class);
	}

	
	@Override
	public Player findPlayer(String playerId) {
		return getBaseballPlayerServiceMapper().findPlayer(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		getBaseballPlayerServiceMapper().tradePlayer(sourcePlayerId, targetPlayerId);
	}

	@Override
	public List<Player> findAllPlayer() {
		return getBaseballPlayerServiceMapper().findAllPlayer();
	}

	@Override
	public List<Player> findPlayerByTeam(String teamId) {
		return getBaseballPlayerServiceMapper().findPlayerByTeam(teamId);
	}

}
