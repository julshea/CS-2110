//jts6mq, Julia Shea
public interface Playable {
	/**Create a Java interface named Playable that includes the following methods (and only the following methods):

public void play();

public String getName(); // returns the name (for PlayList) or title (for Song) of Playable object.

public int getPlayTimeSeconds(); // For Song: returns the number of seconds in the song. For PlayList: returns the number of seconds in the entire PlayList 

public int numberOfSongs(); // For Song: returns 1.  For PlayList returns the number of songs in the playlist and all playlists contained within.  

Note: when writing getPlayTimeSeconds() and numberOfSongs() in the playlist class it can help to know that since both Playlist and Song implement these methods it doesn't matter what the type of the object is when calling this method.  

Both the Song and PlayList classes will implement this interface.


	 * 
	 */
	public void play();
	public String getName();
	public int getPlayTimeSeconds();
	public int numberOfSongs();
	
}
