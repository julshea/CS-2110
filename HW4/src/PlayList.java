/*
 * /*jts6mq--Julia Shea
 * Prof Stone, MWF 12PM
 * The awesome TAs helped me during OH!
 * 
 * */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class PlayList implements Playable, Comparator<Playable>{

	private String name; 
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	ArrayList<Playable> playableList; //arraylist of playable elements
	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}
	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}
	
	/** the following 2 constructors create an empty playlist named "untitled" and another empty playlist
	 */
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}
	//
	public PlayList(String newName) {
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
		} 
	
	/** The toString method for the PlayList class iterates over the arraylist "playable" and returns the name of the playlist followed by it's contents
	 * each item is returned on a new line
	 */
	public String toString() {
		String playlistString = "";
		for(Playable p : playableList) {
			if(p instanceof Song) {
			p.toString();
			playlistString = playlistString + "\n" + p; 
			}
			if(p instanceof PlayList) {
				for(Playable s : ((PlayList) p).getPlayableList()) {
					s.toString();
					playlistString = playlistString + "\n" + s; 
				}
			}
		}
		return name + playlistString;
	}

	
	/** Accepts a string filename as a parameter, and returns true if the file was read
	 * 
	 */
	@SuppressWarnings("resource")
	public boolean loadSongs(String fileName) {

		File testLoadSongs = new File(fileName);

		try {
		Scanner fileScnr = new Scanner(testLoadSongs);
		while(fileScnr.hasNextLine()) {

			String songtitle = fileScnr.nextLine().trim();
			String songartist = fileScnr.nextLine().trim();
			String time = fileScnr.nextLine().trim();
			String blank = fileScnr.nextLine().trim();

			if(songartist.equals("") || songtitle.equals("") || time.equals("")) {
				return false;
			}
			if(!blank.equals("")) {
				return false;
			}
			String min = time.substring(0,time.indexOf(":"));
			String sec = time.substring(time.indexOf(":")+1);
			int songmin = Integer.parseInt(min);
			int songsec = Integer.parseInt(sec);

			Song song = new Song(songartist, songtitle, songmin, songsec);
			addSong(song);
		}
		return true;
		}
		catch (FileNotFoundException exception) {
			return false;
		}

	}

	
	
	/**removes ALL playable elements in the playlist, so we have to make sure that there's at least one element in the list.
	 * if the size of the list is 0, then the method will return false
	 */
	public boolean clear() {
		if(this.getPlayableList().size() == 0) {
			return false;
		}
		for(Playable p : this.getPlayableList()) {

			this.getPlayableList().remove(p);	
		}
		return true;
		}
	

	/**
	 * adds a song to the END of the current object's playableList, and
	 * returns true if successful
	 */
	public boolean addSong(Song s) {
		this.playableList.add(s); 
		return true;
	}

	/**remove playable element at given index from list, accepts the int of the index as a parameter
	 * returns the item that was removed
	 */
	public Playable removePlayable(int index) {
		Playable e = playableList.remove(index);
		return e;
	}

	public Playable removePlayable(Playable p) {
			boolean removedItem = this.getPlayableList().remove(p);
			if(removedItem == true) {
				return p;
			}
		return p;
	}


	/**
	 * returns the playable element at the appropriate index
	 * @param: index of the item you want to get
	 * @return: the element at the position of that index
	 */
	public Playable getPlayable(int index) {
		if(playableList.size() > index && index > 0) {
			return playableList.get(index);
		}
		else {
			return null;
		}
	}
	/**adds the PlayList that is being passed to the end of the playableList and returns true 
	 * unless the playableList already contains a playlist with the same name, in this case, 
	 * do not add the playlist and return false.  
	 * PlayLists are uniquely identified by name, so your program should not allow there to be two playlists with the same name.
	 */
	public boolean addPlayList(PlayList pl) {
		for(Playable item : this.getPlayableList()) {
			if(item instanceof PlayList){
				if(item.getName().equals(pl.getName())){

					return false;
				}
			}
		}

		this.getPlayableList().add(pl);
		return true;	

	}
	
	public void sortByName() {
		ArrayList<String> sortNameList = new ArrayList<String>();
		ArrayList<Playable> sortNameList2 = new ArrayList<Playable>();
		for(Playable p:playableList) {
			sortNameList.add(p.getName());
			sortNameList2.add(p);

		}
		Collections.sort(sortNameList);
		playableList.clear();
		for(String name: sortNameList) {
			for (Playable p: sortNameList2) {
				if(p.getName().equals(name)) {
					playableList.add(p);
				}
			}
		}
	}
	

	
	
	public void sortByTime() {
		ArrayList<Integer> sortTimeList = new ArrayList<Integer>();
		ArrayList<Playable> sortTimeList2 = new ArrayList<Playable>();
		for(Playable p : playableList) {
			sortTimeList.add(p.getPlayTimeSeconds());
			sortTimeList2.add(p);
		}
		Collections.sort(sortTimeList);
		playableList.clear();
		for(int time: sortTimeList) {
			for (Playable p: sortTimeList2) {
				if(p.getPlayTimeSeconds()==time) {
					playableList.add(p);
				}
			}
		}

	}

	@Override
	public void play() {
		for(Playable item : this.getPlayableList()) {
			item.play();
		}
		
	}
	
	@Override
	public int getPlayTimeSeconds() {
		int totalSeconds = 0;
		for (int i = 0; i<playableList.size(); i++) {
			totalSeconds += playableList.get(i).getPlayTimeSeconds();
		}
		return totalSeconds;
	}

		
	@Override
	public int numberOfSongs() {
		int songCounter = 0;
		for(Playable item : this.getPlayableList()) {
			if(item instanceof Song) {
				songCounter++;
			}
			if(item instanceof PlayList) {
				for(Playable i : ((PlayList) item).getPlayableList()) {
					
					if(i instanceof Song) {
						songCounter++;
					
					}
				}
			}
		}
		return songCounter;
	}
	@Override
	public int compare(Playable o1, Playable o2) {
		return o1.getName().compareTo(o2.getName());
	}

}

//to do: loadSongs method, comment code correctly before headers, look over boolean methods and made sure they're returning the right thing
//see if you actually need the compare method??
