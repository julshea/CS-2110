/*
 * /*jts6mq--Julia Shea
 * Prof Stone, MWF 12PM
 * The awesome TAs helped me during OH!
 * 
 * */
 
import static org.junit.Assert.*;

import org.junit.Before;
/**
 * Methods to test:
 * //getName--done

//equals for song--done
 * for playlist--done

//getPlayTimeSeconds

//numberofSongs

//loadSongs--done

//clear--done

//addSong--done

//removePlayable--done

//removePlayable--done

//getPlayable--done

//addPlayList--done

//sortByName

//sortByTime

//compareTo
 */
//import java.util.*;
import org.junit.Test;

public class TestHW4 {
	Song song1, song2, song3, song4, song5, song6;
	PlayList myPlayList, myPlayList2, myPlayList3;
	
	@Before
	public void settingUp() throws Exception{
		Song song1 = new Song("Journey", "Don't Stop Believing", 2, 45);
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer", 4, 35); 
		Song song4 = new Song("Nicki Minaj", "FEFE", 3, 11);
		//Song song5 = new Song("Nicki Minaj", "Superbass", 3, 11);
		//Song song6 = new Song("Journey", "Don't Stop Believing", 3, 7);
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		myPlayList.getPlayableList().add(myPlayList2);
		myPlayList.getPlayableList().clear();
	}
	
	/**
	 * first test of the addSong() method
	 */
	@Test
	public void testAddSong() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		myPlayList.addSong(song1);
		myPlayList.addSong(song2);
		myPlayList.addSong(song3);
		myPlayList.addSong(song4);
		
		assertTrue(myPlayList.getPlayableList().contains(song3));
		assertFalse(myPlayList.getPlayableList().isEmpty());
	}

	/**
	 *  second test of the addSong() method
	 */
	@Test
	public void testAddSong2() {
		
	}
	
	/**
	 * first test of the clear() method
	 * @param playableList 
	 */
	@Test
	public void testClear() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		myPlayList.getPlayableList().add(myPlayList2);
		myPlayList.getPlayableList().clear();
		
		assertTrue(myPlayList.getPlayableList().size() == 0);
		assertFalse(myPlayList.getPlayableList().contains(myPlayList2));
	}



	/**
	 *  second test of the clear() method
	 */
	@Test
	public void testClear2() {

	}



	/**
	 *  first test of the removePlayable(index) method
	 */
	@Test
	public void testRemovePlayable() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		PlayList myPlayList3 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		myPlayList.getPlayableList().add(myPlayList2);
		myPlayList.getPlayableList().add(myPlayList3);
		
		myPlayList.removePlayable(1);
		assertEquals(5, myPlayList.getPlayableList().size());
		assertFalse(myPlayList.getPlayableList().contains(song2));
	}
	
	/**
	 * second test of the removePlayable(index) method
	 */
	@Test
	public void testRemovePlayable2() {
		
	}
	
	/**
	 *  first test of the removePlayable(Playable) method
	 */
	@Test
	public void removePlayableTest() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		PlayList myPlayList3 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		myPlayList.getPlayableList().add(myPlayList2);
		myPlayList.getPlayableList().add(myPlayList3);
		
		myPlayList.removePlayable(song1);
		
		assertFalse(myPlayList.getPlayableList().contains(song1));
		
		
	}
	
	/**
	 *  second test of the removePlayable(Playable) method
	 */
	@Test
	public void removePlayableTest2() {
	}
	

	/**
	 * first test of the getPlayable method
	 */

	@Test
	public void testGetPlayable() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		PlayList myPlayList3 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		myPlayList.getPlayableList().add(myPlayList2);
		myPlayList.getPlayableList().add(myPlayList3);
		
		assertEquals(song3, myPlayList.getPlayable(2));
	}
	
	/**
	 * second test of the getPlayable method
	 */

	@Test
	public void testGetPlayable2() {
		
	}

	/**
	 * first test of the addPlayList method
	 */

	@Test
	public void testAddPlayList() {
		Song song1 = new Song("Journey", "Don't Stop Believing");
		Song song2 = new Song("Drake", "God's Plan");
		Song song3 = new Song("Bon Jovi", "Living on a Prayer"); 
		Song song4 = new Song("Nicki Minaj", "FEFE");
		PlayList myPlayList = new PlayList();
		PlayList myPlayList2 = new PlayList();
		myPlayList.getPlayableList().add(song1);
		myPlayList.getPlayableList().add(song2);
		myPlayList.getPlayableList().add(song3);
		myPlayList.getPlayableList().add(song4);
		
		myPlayList.getPlayableList().add(myPlayList2);
		assertFalse(myPlayList.addPlayList(myPlayList2));
	}
	
	/**
	 *second test of the addPlayList method
	 */

	@Test
	public void testAddPlayList2() {
		
	}

	
	/**
	 * first test of the equals method
	 * this test will test the equals method for song 
	 */
	public void testEquals() {
		Song song1 = new Song("Journey", "Don't Stop Believing", 2, 45);
		Song song6 = new Song("Journey", "Don't Stop Believing", 3, 7);
		assertFalse(song1.equals(song6));
	}
	
	/**
	 * second test of the equals method
	 * this test will test the equals method for playlist
	 */
	public void testEquals2() {
		PlayList myPlayList2 = new PlayList("Party!");
		PlayList myPlayList3 = new PlayList("Party!");
		PlayList myPlayList4 = new PlayList("Party");
		
		assertTrue(myPlayList3.equals(myPlayList2));
		assertFalse(myPlayList2.equals(myPlayList4));
	}

	/**
	 * first test of the getName method
	 * 
	 */
	@Test
	public void testGetName() {
		Song song3 = new Song("Bon Jovi", "Living on a Prayer", 4, 35); 
		//Song song4 = new Song("Nicki Minaj", "FEFE", 3, 11);
		
		assertEquals("Living on a Prayer", song3.getName());
		
	}

	/**
	 * first test of the getName method
	 * 
	 */
	@Test
	public void testGetName2() {
		Song song3 = new Song("Bon Jovi", "Living on a Prayer", 4, 35); 
		Song song4 = new Song("Nicki Minaj", "FEFE", 3, 11);
		assertFalse(song3.getName().equals(song4.getName()));
	}
	/**
	 * first test of loadSongs
	 */
	@Test
	public void testLoadSongs() {
		PlayList myPlayList = new PlayList();
		myPlayList.loadSongs("Test.loadSongs.txt");
		if(myPlayList.getPlayableList().size() > 0 )
			assertEquals(myPlayList.getPlayableList().get(0).getPlayTimeSeconds(), 253);
		myPlayList.clear();
		
	}
	/**
	 * second test of loadSongs
	 */
	@Test
	public void testLoadSongs2() {
		PlayList myPlayList = new PlayList();
		myPlayList.loadSongs("Test.loadSongs.txt");
		if(myPlayList.getPlayableList().size() > 0 )
			assertEquals(myPlayList.getPlayableList().get(0).getName(),"Bon Jovi");
		myPlayList.clear();
	}


}









