package store.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import store.logic.BaseballTeamStoreLogic;

public class BaseballTeamStoreTest {

	private BaseballTeamStoreLogic storeLogic;
	
	@Before
	public void init(){
		storeLogic = new BaseballTeamStoreLogic();
	}
//	
//	@Test
//	public void testRetrieve() {
//		assertNotNull(storeLogic.retrieve("10"));
//	}

	@Test
	public void testRetrieveAll() {
		assertNotNull(storeLogic.retrieveAll());
		assertEquals(10, storeLogic.retrieveAll().size());
	}

}
