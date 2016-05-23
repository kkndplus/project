package store.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import store.logic.UserStoreLogic;

public class UserStoreTest {
	
	private UserStoreLogic storeLogic;

	@Before
	public void initTest() {
		storeLogic = new UserStoreLogic();
	}
	
//	@Test
//	public void testCreate() {
//		User user = new User();
//		user.setLoginId("qwerty");
//		user.setName("qwe");
//		user.setPassword("qwerty");
//		storeLogic.create(user);
//	}

	@Test
	public void testRead() {
		User user = storeLogic.read("jjw");
		assertTrue(user.getName().equals("재원"));
		assertTrue(user.getPassword().equals("api"));
	}

}
