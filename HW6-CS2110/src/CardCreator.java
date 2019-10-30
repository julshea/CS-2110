import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Homework 6 Card Creator
 * 
 * This class defines the thread task that will
 * "come up with" and submit greeting card ideas
 * to the print queue.  We have added the code
 * necessary to read from the file, but it's up to
 * you to handle turning off the printer (keeping
 * track of how many threads are open) and adding
 * the read-in line from the inspiration file to
 * the queue.
 * 
 * @author jh2jf
 *
 */
public class CardCreator implements Runnable {
	
	/**
	 * Print queue to add new card ideas
	 */
	private PrintQueue printQueue;
	
	/**
	 * Inspiration file name
	 */
	private String filename;
	static int numThreads;
	
	public CardCreator(PrintQueue d, String filename) {
		printQueue = d;
		this.filename = filename;
	}

	/**
	 * Run method that is the main method for the thread
	 */
	@Override
	public void run() {
		Scanner s = null;
		try {
			numThreads+=1;
			s = new Scanner(new FileReader(filename));
			while (s.hasNextLine()) {
				
				// TODO: Read the next line from the inspiration file
				// TODO: Enqueue the line into the print queue
				String line = s.nextLine();
				line = line.trim();
				
				printQueue.enqueue(line);
				Thread.sleep(1000);			}
		}catch(InterruptedException e) {
				
		} catch (IOException e) {
			System.out.println("Could not read file");
		} finally {
			if (s != null)
				s.close();
				numThreads -=1;
			//Turn off the print queue (if applicable)
			if(numThreads == 0) {printQueue.turnOff();}
				

		}
	}

}
