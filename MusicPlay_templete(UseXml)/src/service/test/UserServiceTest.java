package service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.User;
import service.logic.UserServiceLogic;

public class UserServiceTest {

	private UserServiceLogic serviceLogic;

	@Before
	public void initTest() {
		serviceLogic = new UserServiceLogic();
	}
	
//	@Test
//	public void testLogin() {
//		User user = new User();
//		user.setLoginId("cruel");
//		user.setName("쨰");
//		user.setPassword("1234");
//		assertTrue(serviceLogic.login(user)!=null);
//	}

//	@Test
//	public void testRegister() {
//		User user = new User();
//		user.setLoginId("cruel");
//		user.setName("쨰");
//		user.setPassword("1234");
//		assertTrue(serviceLogic.register(user));
//	}

	@Test
	public void testFind() {
		User user = serviceLogic.find("jjw");
		assertTrue(user.getName().equals("재원"));
		assertTrue(user.getPassword().equals("api"));
	}

}
