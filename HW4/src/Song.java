/*jts6mq--Julia Shea
 * Prof Stone, MWF 12PM
 * The awesome TAs helped me during OH!
 * 
 * */
 
public class Song implements Comparable<Song>, Playable{

	//class fields
	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	//getters and setters for all fields: artist, title, minutes, and seconds
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	//3 constructors, each with all fields initialized
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;

	}

	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes + (seconds/60);
		this.seconds = seconds % 60;

	}

	public Song(Song s) {
		this.artist = s.getArtist();
		this.title = s.getTitle();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
	}

	
	//equals method for the Song class, 2 songs are equal if ALL FOUR FIELDS are equal
	@Override
	public boolean equals(Object o) {
	if (o != null && o instanceof Song) {
		Song otherSong =(Song) o;
		if (this.artist.equals(otherSong.getArtist()) 
				&& this.title.equals(otherSong.getTitle() ) 
				&& this.minutes == otherSong.getMinutes() 
				&& this.seconds == otherSong.getSeconds()) {
			return true;
		}
	}
	return false;
}

	//toString method for the song class (given in HW description)
	public String toString() { 

		return "{Song: title = " + title + " artist = " + artist + "}";

	}

	//play method for song class (given in HW description)
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);
	}

	/*compareTo method that orders songs by the artist in ascending order. 
	If the artists are the same, then by title in ascending order. 
	If both artist and title are the same, then any order is acceptable.*/
	public int compareTo(Song otherSong) {
		if(this.artist != otherSong.artist) {
			return this.artist.compareTo(otherSong.artist);
		}
		else if(this.title != otherSong.title) {
			return this.title.compareTo(otherSong.title);
		}	

		else {
			return 0;
		}
	}

	//The following are the methods needed to implement the comparable interface:
	@Override
	public String getName() {
		return this.title;
	}
	@Override
	public int getPlayTimeSeconds() {
		return minutes * 60 + seconds;
	}
	@Override
	public int numberOfSongs() {
		return 1;
	}
}



