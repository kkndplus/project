package service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import service.logic.BaseballTeamServiceLogic;

public class ServiceTest {
	private BaseballTeamServiceLogic store;
	
	@Before
	public void init(){
		store = new BaseballTeamServiceLogic();
	}
	
//	@Test
//	public void testFindTeam() {
//		assertNotNull(store.findTeam("10"));
//		assertTrue(store.findTeam("10").getManager().equals("김성근"));
//		assertTrue(store.findTeam("10").getName().equals("한화이글스"));
//	}

//	@Test
//	public void testFindAllTeams() {
//		assertNotNull(store.findAllTeams());
//		assertEquals(10, store.findAllTeams().size());
//		assertTrue(store.findAllTeams().get(3).getTeamId().equals("4"));
//		assertNull(store.findAllTeams().get(3).getPlayers());
//	}

//	@Test
//	public void testFindAllTeamsWithPlayers() {
//		assertNotNull(store.findAllTeamsWithPlayers());
//		assertEquals(10, store.findAllTeamsWithPlayers().size());
//		assertTrue(store.findAllTeamsWithPlayers().get(2).getTeamId().equals("3"));
//		assertNotNull(store.findAllTeamsWithPlayers().get(2).getPlayers());
//		assertTrue(store.findAllTeamsWithPlayers().get(2).getPlayers().size()==5);
//		assertTrue(store.findAllTeamsWithPlayers().get(2).getPlayers().get(2).getName().equals("김현수"));
//	}

//	@Test
//	public void testFindTradeTargetPlayers() {
//		assertNotNull(store.findTradeTargetPlayers("1"));
//		assertEquals(9, store.findTradeTargetPlayers("1").size());
//		assertTrue(store.findTradeTargetPlayers("1").get(8).getTeamId().equals("10"));
//		assertNotNull(store.findTradeTargetPlayers("1").get(8).getPlayers());
//		assertTrue(store.findTradeTargetPlayers("1").get(8).getPlayers().size()==5);
//		assertTrue(store.findTradeTargetPlayers("1").get(8).getPlayers().get(2).getName().equals("권혁"));
//	}

//	@Test
//	public void testFindPlayer() {
//		assertNotNull(store.findPlayer("4"));
//		assertTrue(store.findPlayer("4").getName().equals("김경언"));
//	}

	@Test
	public void testTradePlayer() {
		store.tradePlayer("3", "6");
		assertEquals(store.findPlayer("3").getTeamId(),"6");
		assertTrue(store.findPlayer("6").getTeamId().equals("10"));
	}

}
