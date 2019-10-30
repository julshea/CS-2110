/*
Julia Shea
jts6mq
Homework 3
people/sources: multiple TAs during office hours, stack overflow for syntax and Gregorian Calander explanation
fellow classmates Kristen Lucas and Tricia Bonner for concept explanation!
 */

import java.util.*;


public class Library{
	//establish fields libraryBooks, patrons, name, numBooks, numPeople, currentDate
	private ArrayList<Book> libraryBooks = new ArrayList<Book>();
	private ArrayList<Person> patrons = new ArrayList<Person>();
	private String name;
	private int numBooks; //number of books available to be checked out
	private int numPeople; //number of patrons to the library
	private String currentDate;


	//write accessor methods for fields: libraryBooks, patrons, name, numBooks, numPeople, currentDate
	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}
	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	public String getName() {
		return name;
	}

	public int getNumBooks() {
		this.numBooks = libraryBooks.size();
		for(int i = 0; i < libraryBooks.size(); i++) {
			if(libraryBooks.get(i).isCheckedOut()) {
				this.numBooks = this.numBooks - 1;
			}
		}
		return this.numBooks;
	}

	public int getNumPeople() {
		return this.numPeople;
	}

	public String getCurrentDate() {
		return currentDate;
	}




	//write mutator methods for fields: libraryBooks, patrons, name, currentDate
	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}
	public void setPatrons(ArrayList<Person> patrons) {
		this.numPeople = patrons.size();
		this.patrons = patrons;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}



	//write a constructer that takes in a string for the name of the Library
	public Library(String name) {
		this.name = name;
		this.numBooks = 0;
		this.numPeople = 0;
	}



	/*method that takes in the A method that takes in a string for the title and author of a book
	and returns the number of copies of this book in the library (both checked out and available)
	 */
	public int checkNumCopies( String title, String author) {
		int copyCount = 0;
		for(int i = 0; i < libraryBooks.size(); i ++) {
			Book bookCopy = libraryBooks.get(i);
			String bookTitle = bookCopy.getTitle();
			String bookAuthor = bookCopy.getAuthor();
			if(bookTitle.equals(title) && bookAuthor.equals(author)) {
				copyCount ++;

			}
		}
		return copyCount;
	}		
	//returns the number of books in the library (either checked out or not)
	public int totalNumBooks() {
		return libraryBooks.size();
	}

	//returns true if a books is able to be checked out to a given patron
	//the person must be a patron, and the book must not be checked out already
	public boolean checkOut(Person p, Book b, String dueDate) {
		//checks if person is a patron
		if(patrons.contains(p)) {
			for(int i = 0; i < libraryBooks.size(); i++) {
				if(libraryBooks.get(i).equals(b) && !(libraryBooks.get(i).isCheckedOut())) {
					libraryBooks.get(i).setDueDate(dueDate);
					libraryBooks.get(i).setCheckedOut(true);
					p.addBook(libraryBooks.get(i));
					numBooks = numBooks - 1;
					return true;
				}
			}

		}
		//if any of the above isnt true, return false
		return false;
	}


	//returns an ArrayList of books due on a given date
	public ArrayList<Book> booksDueOnDate(String date) {
		ArrayList <Book> booksDue = new ArrayList<Book>();
		//loops through libraryBooks and checks to see if the due date of the book at each index equals the date passed in the method
		//if it does, adds it to booksDue
		for (int i = 0; i < libraryBooks.size(); i ++) {
			if (date.equals(libraryBooks.get(i).getDueDate())) {
				booksDue.add(libraryBooks.get(i));

			}
		}
		return booksDue;
	}


	//returns the amount of late fees a person owes
	public double lateFee(Person p) {
		//get the current date in integer form to be able to do math with it later
		String day = currentDate.substring(0,2);
		String month = currentDate.substring(3,5);
		String year = currentDate.substring(6,10);

		int numberDays = Integer.parseInt(day);
		int numberMonths = Integer.parseInt(month) - 1;
		int numberYears = Integer.parseInt(year);

		//working with the Gregorian Calander to get the time value of the current date in milliseconds
		GregorianCalendar todaysDate = new GregorianCalendar(numberYears, numberMonths, numberDays);
		long longOfTodaysDate = todaysDate.getTimeInMillis();

		double totalFee = 0.0;
		for(int i = 0; i < p.getCheckedOut().size(); i++) {
			Book bookCheckedOut = p.getCheckedOut().get(i);
			String bookDate = bookCheckedOut.getDueDate();

			//to do math and interact with with the above format of currentDate, cast the due date string to an integer
			String day1 = bookDate.substring(0,2);
			String month1 = bookDate.substring(3,5);
			String year1 = bookDate.substring(6,10);

			int numberDays1 = Integer.parseInt(day1);
			int numberMonths1 = Integer.parseInt(month1) - 1;
			int numberYears1 = Integer.parseInt(year1);


			//got this time value in milliseconds using Gregorian calander
			GregorianCalendar bookIsDue = new GregorianCalendar(numberYears1, numberMonths1, numberDays1);
			long longOfBookIsDue = bookIsDue.getTimeInMillis();


			long differenceInDates = longOfTodaysDate - longOfBookIsDue;
			long numDays = (differenceInDates/86400000);
			numDays = (int)numDays;


			if (numDays > 0) {
				double checkValue = p.getCheckedOut().get(i).getBookValue();
				double fee = ((.01 * checkValue)* numDays);
				totalFee = totalFee + fee;

			}


		}
		return totalFee;
	}

}


	
