package store.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Music;
import store.logic.UserMusicStoreLogic;

public class UserMusicStoreTest {

	private UserMusicStoreLogic storeLogic;

	@Before
	public void initTest() {
		storeLogic = new UserMusicStoreLogic();
	}
	
	@Test
	public void testCreate() {
		assertTrue(storeLogic.create("jjw", 6));
	}

//	@Test
//	public void testDelete() {
//		assertTrue(storeLogic.delete("jjw", 3));
//	}

//	@Test
//	public void testExistUserMusic() {
//		assertTrue(storeLogic.existUserMusic("jjw", 4));
//	}

	@Test
	public void testReadMusicsByUser() {
		List<Music> list = storeLogic.readMusicsByUser("jjw");
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
