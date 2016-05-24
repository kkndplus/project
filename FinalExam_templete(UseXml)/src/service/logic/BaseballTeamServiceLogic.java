package service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;

public class BaseballTeamServiceLogic implements BaseballTeamService {

	private SqlSessionFactory factory;

	public BaseballTeamServiceLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	// team
	// 팀 아이디로 해당 팀 선택
	public BaseballTeam findTeam(String teamId) {
		SqlSession session = factory.openSession();
		BaseballTeam team = null;
		try {
			team = session.selectOne("findTeam", teamId);
		} finally {
			session.close();
		}
		return team;
	}

	// 모든 팀 선택
	public List<BaseballTeam> findAllTeams() {
		SqlSession session = factory.openSession();
		List<BaseballTeam> list = null;
		try {
			list = session.selectList("findAllTeams");
		} finally {
			session.close();
		}
		return list;
	}

	// 모든 선수 선택(선수 목록 출력)
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		SqlSession session = factory.openSession();
		List<BaseballTeam> list = null;
		list = session.selectList("findAllTeams");
		for (BaseballTeam team : list) {
			String teamId = team.getTeamId();
			List<Player> playerList = session.selectList("findPlayerByTeam", teamId);
			team.setPlayers(playerList);
		}
		return list;
	}

	// 트레이드 하기 위해 해당 팀 이외의 선수들 출력
	public List<BaseballTeam> findTradeTargetPlayers(String teamId) {
		SqlSession session = factory.openSession();
		List<BaseballTeam> list;
		try {
			list = session.selectList("findTradeTarget", teamId);
			for (BaseballTeam team : list) {
				String id = team.getTeamId();
				List<Player> playerList = session.selectList("findPlayerByTeam", id);
				team.setPlayers(playerList);
			}
		} finally {
			session.close();
		}
		return list;
	}

	// player
	// 선수 찾기
	public Player findPlayer(String playerId) {
		SqlSession session = factory.openSession();
		Player player = null;
		try {
			player = session.selectOne("findPlayer", playerId);
		} finally {
			session.close();
		}
		return player;
	}

	// 전체 선수 찾기
	public List<Player> findAllPlayer() {
		SqlSession session = factory.openSession();
		List<Player> list = null;
		try {
			list = session.selectList("findAllPlayer");
		} finally {
			session.close();
		}
		return list;
	}

	// 팀별 선수 목록
	public List<Player> findPlayerByTeam(String teamId) {
		SqlSession session = factory.openSession();
		List<Player> list = null;
		try {
			list = session.selectList("findPlayerByTeam", teamId);
		} finally {
			session.close();
		}
		return list;
	}

	// 선수 트레이드
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {

		Player sourceplayer = this.findPlayer(sourcePlayerId);
		Player targetplayer = this.findPlayer(targetPlayerId);
		String targetTeamId = targetplayer.getTeamId();
		String sourceTeamId = sourceplayer.getTeamId();
		sourceplayer.setTeamId(targetTeamId);
		targetplayer.setTeamId(sourceTeamId);
		
		SqlSession session = factory.openSession();
		try {
			session.update("updatePlayer", sourceplayer);
			session.update("updatePlayer", targetplayer);
			session.commit();
		} finally {
			session.close();
		}

		// try {
		// session.commit();
		// } finally {
		// session.close();
		// }
	}
}
