package service.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Music;
import service.logic.UserMusicServiceLogic;

public class UserMusicServiceTest {
	
	private UserMusicServiceLogic serviceLogic;

	@Before
	public void initTest() {
		serviceLogic = new UserMusicServiceLogic();
	}
	
//	@Test
//	public void testRegister() {
//		assertTrue("항목이 이미 있습니다.",serviceLogic.register("jjw", 6));
//	}

//	@Test
//	public void testRemove() {
//		assertTrue("요청하신 항목이 없습니다.",serviceLogic.remove("jjw", 6));
//	}

	@Test
	public void testFindMusicsByUser() {
		List<Music> list = serviceLogic.findMusicsByUser("jjw");
		assertNotNull(list);
		assertEquals(3,list.size());
		assertTrue(list.get(0).getId() == 6);
		assertTrue(list.get(0).getName().equals("봄인가 봐 (Spring Love)"));
		assertTrue(list.get(0).getArtist().equals("에릭남, 웬디"));
		assertTrue(list.get(0).getAlbum().equals("봄인가 봐 (Spring Love)"));
		assertTrue(list.get(0).getImage().equals("album_6.JPG"));
		assertTrue(list.get(0).getAgent().equals("SMTOWN"));
	}

}
