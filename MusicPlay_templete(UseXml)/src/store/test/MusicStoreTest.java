package store.test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import domain.Music;
import store.logic.MusicStoreLogic;

public class MusicStoreTest {

	private MusicStoreLogic storeLogic;

	@Before
	public void initTest() {
		storeLogic = new MusicStoreLogic();
	}

	@Test
	public void testRead() {
		Music music = storeLogic.read(3);
		assertTrue(music.getName().equals("ALWAYS"));
		assertTrue(music.getArtist().equals("윤미래"));
		assertTrue(music.getAlbum().equals("태양의 후예 OST PART 1"));
		assertTrue(music.getImage().equals("album_3.JPG"));
		assertTrue(music.getAgent().equals("뮤직앤뉴"));
	}

//	@Test
//	public void testReadByName() {
//		List<Music> list = storeLogic.readByName("이");
//		assertNotNull(list);
//		assertEquals(3,list.size());
//		assertTrue(list.get(0).getId() == 2);
//		assertTrue(list.get(0).getName().equals("이 사랑"));
//		assertTrue(list.get(0).getArtist().equals("다비치"));
//		assertTrue(list.get(0).getAlbum().equals("태양의 후예 OST PART 3"));
//		assertTrue(list.get(0).getImage().equals("album_2.JPG"));
//		assertTrue(list.get(0).getAgent().equals("뮤직앤뉴"));
//	}

//	 @Test
//	 public void testReadAll() {
//		 List<Music> list = storeLogic.readAll();
//			assertNotNull(list);
//			assertEquals(20,list.size());
//			assertTrue(list.get(1).getId() == 2);
//			assertTrue(list.get(1).getName().equals("이 사랑"));
//			assertTrue(list.get(1).getArtist().equals("다비치"));
//			assertTrue(list.get(1).getAlbum().equals("태양의 후예 OST PART 3"));
//			assertTrue(list.get(1).getImage().equals("album_2.JPG"));
//			assertTrue(list.get(1).getAgent().equals("뮤직앤뉴"));
//	 }

}
