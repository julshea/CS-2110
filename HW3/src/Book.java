/*
Julia Shea
jts6mq
Homework 3
people/sources: none for Book.Java!


 */
public class Book {


	private final String title; //creates field: title
	public String getTitle() {	//getter, returns a reference to the field author
		return title;
	}						

	private final String author; //creates field: author
	public final String getAuthor() { //getter, returns a reference to the field author
		return author;
	}



	//the following are fields, accessor, and mutator methods for dueDate, checkedOut, bookId, and bookValue
	//the only one without a mutator is bookId, because the value is final
	private String dueDate; 
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDueDate() {
		return dueDate;
	}


	private boolean checkedOut; 
	public boolean isCheckedOut() { 
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}



	private int bookId;
	public int getBookId() {
		return bookId;
	}



	private double bookValue;
	public double getBookValue() {
		return bookValue;
	}
	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}



	public Book(String title, String author, int bookId, double bookValue){	//constructor that takes a title and an author
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.bookValue = bookValue;

	}	
	//the above code is causing problems when I try to make bookId final???

	/*equals() method will return true if the Book object passed to it EQUALS
		the title and author strings of the current Book object
		will return false if they don't
	 */
	public boolean equals(Object o) { 
		if(o == null) {
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}

		Book newBook = (Book) o;
		if (this.title == newBook.getTitle() && this.author == newBook.getAuthor()) {
			return true;
		}	
		else {
			return false;
		}
	}


	//generate a string that shows the values of title and author
	public String toString() {
		return "Title: " + getTitle() + "," +"Author: " + getAuthor();

	}

	//return a string that states when the  book is due (DD MM YYYY)

}

