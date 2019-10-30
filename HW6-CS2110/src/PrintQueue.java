import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Homework 6 PrintQueue
 * 
 * Implement the class below as specified in the
 * homework 6 document.
 * 
 * @author jts6mq
 *
 */
 
 // Don't forget to include the appropriate import statements
 
 
 
public class PrintQueue {
	
	private Queue<String> queue;      // the print queue (called "queue")
	private Lock documentChangeLock;  // a ReentrantLock lock
	private Condition hasPrintTask;   // a condition object
	private boolean isOn; // boolean variable describing if the queue is on or off
	 
	public PrintQueue() {
		// initializes fields isOn, documentChangeLock, hasPrintTask, and queue
		isOn = true;
		documentChangeLock = new ReentrantLock();
		hasPrintTask = documentChangeLock.newCondition();
		queue = new LinkedList<String>();
		
	}
	
	/**
	 * public String dequeue() : Remove the head element off the queue (if there is something
		in the queue) and return it
	 * @return head element of the queue
	 */
	public String dequeue() {
		if (isOn) { // method only can run when printerQueue is on/accepting jobs
			documentChangeLock.lock();
			try {
				return queue.remove();
			}catch(Exception NoSuchElementException){ // in case there is nothing to print
				return null;
			}finally {
				documentChangeLock.unlock();
			}
		}
		return null;
	}
	
	/**
	 * Add the greeting given by the String parameter
		onto the end of the print queue.
	 * @param greeting
	 */
	public void enqueue(String greeting) {
		documentChangeLock.lock();
		try {
			if (isOn && (greeting != null)) {
				queue.add(greeting);
				hasPrintTask.signalAll();}
	}finally {
		documentChangeLock.unlock();
		}
	}
	
	/**
	 * Returns the state (value) of isOn. It should return true if the
		PrintQueue is still accepting jobs, false if it has been “turned off."
	 * @return isOn
	 */
	public boolean isOn() {
		return isOn;
	}
	
	/**
	 * Turn off the print queue (i.e. set a boolean field denoting that the
		PrintQueue is no longer accepting jobs)
	 */
	public void turnOff() {
		documentChangeLock.lock();
		try {
			if (queue.isEmpty()) { //must be no jobs currently in the queue
				isOn = false;
				hasPrintTask.signalAll(); //notifies waiting threads of the condition
			}
			//we always want this to unlock at the end
		}finally {
			documentChangeLock.unlock();
		}
	}
}
