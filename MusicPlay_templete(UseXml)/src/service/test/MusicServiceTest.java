package service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Music;
import service.logic.MusicServiceLogic;

public class MusicServiceTest {

	private MusicServiceLogic serviceLogic;

	@Before
	public void initTest() {
		serviceLogic = new MusicServiceLogic();
	}
	
//	@Test
//	public void testFind() {
//		Music music = serviceLogic.find(3);
//		assertTrue(music.getName().equals("ALWAYS"));
//		assertTrue(music.getArtist().equals("윤미래"));
//		assertTrue(music.getAlbum().equals("태양의 후예 OST PART 1"));
//		assertTrue(music.getImage().equals("album_3.JPG"));
//		assertTrue(music.getAgent().equals("뮤직앤뉴"));
//	}

//	@Test
//	public void testFindByName() {
//		List<Music> list = serviceLogic.findByName("이");
//		assertNotNull(list);
//		assertEquals(3,list.size());
//		assertTrue(list.get(0).getId() == 2);
//		assertTrue(list.get(0).getName().equals("이 사랑"));
//		assertTrue(list.get(0).getArtist().equals("다비치"));
//		assertTrue(list.get(0).getAlbum().equals("태양의 후예 OST PART 3"));
//		assertTrue(list.get(0).getImage().equals("album_2.JPG"));
//		assertTrue(list.get(0).getAgent().equals("뮤직앤뉴"));
//	}

	@Test
	public void testFindAll() {
		List<Music> list = serviceLogic.findAll();
		assertNotNull(list);
		assertEquals(20,list.size());
		assertTrue(list.get(1).getId() == 2);
		assertTrue(list.get(1).getName().equals("이 사랑"));
		assertTrue(list.get(1).getArtist().equals("다비치"));
		assertTrue(list.get(1).getAlbum().equals("태양의 후예 OST PART 3"));
		assertTrue(list.get(1).getImage().equals("album_2.JPG"));
		assertTrue(list.get(1).getAgent().equals("뮤직앤뉴"));
	}

}
