/*
Julia Shea
jts6mq
Homework 3
people/sources: multiple TAs during office hours and stack overflow for concepts used in commonBooks method!


 */
import java.util.ArrayList;

public class Person {
	//field name, id, read, address, and libraraycardNum created; mutators for name and address created
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	//private int id; //will never change
	private ArrayList<Book> checkedOut; //an ArrayList of books the person has checked out
	private String address;
	public void setAddress(String address) {
		this.address = address;
	}
	private int libraryCardNum;


	//accessors for name, id, read, address, and libraryCardNum
	public String getName() {
		return this.name;
	}
	//public int getId() {
	//return this.id;
	//}
	public ArrayList<Book> getCheckedOut() {
		return this.checkedOut;
	}
	public String getAddress() {
		return this.address;
	}
	public int getLibraryCardNum() {
		return this.libraryCardNum;
	}
	//constructor that takes a name and an id
	public Person(String name, String address, int libraryCardNum){ 
		this.name = name;
		this.address = address;
		this.libraryCardNum = libraryCardNum;
		this.checkedOut = new ArrayList<Book>();
	}

	//if the book is not already in the current object's read books, add it to that list
	public boolean addBook(Book b) {
		if(this.getCheckedOut().contains(b)){
			return false;
		}
		else {
			this.getCheckedOut().add(b);
			return true;
		}	
	}

	//return true if the person object has read Book b
	public boolean hasRead(Book b) {
		if(this.getCheckedOut().contains(b)) {
			return true;
		}
		else{
			return false;
		}
	}

	//remove the book from the arraylist read if it's there--then return true
	//if book b isn't in the read arraylist, return false
	public boolean forgetBook(Book b) {
		if(this.getCheckedOut().contains(b)){
			this.getCheckedOut().remove(b);
			return(true);
		}
		else {
			return false;
		}

	}

	//returns the integer number of books the object has read
	public int numBooksRead() {
		return this.getCheckedOut().size();
	}


	//return true if the current person's id value is equal to the id value of the person object passed to equals()
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		if(this.getClass() != o.getClass()) {
			return false;
		}
		Person newPerson = (Person) o;
		if (this.libraryCardNum == newPerson.getLibraryCardNum()) {
			return true;
		}	
		else {
			return false;
		}
	}


	//shows the values of the fields name, id, and read
	@Override 
	public String toString() {
		return "Name: " + getName()+ "\nLibrary Card Number: " + getLibraryCardNum()+ "\nBooks read: " + getCheckedOut();

	}

	//returns an arraylist of the books that both person a and person b have read
	public static ArrayList<Book> commonBooks(Person a, Person b){
		ArrayList<Book> readByB = b.getCheckedOut();
		ArrayList<Book> sameBooks = new ArrayList<Book>();
		for (Book book : a.getCheckedOut()) {
			if (readByB.contains(book)) sameBooks.add(book);
		}
		return sameBooks;  	
	} 

	/* Returns a measure of how similar the reading preferences of two readers are 
	as a number between 0 and 1. If either reader has not read any books, the result is 0.0. 
	Otherwise, it is the number of commonBooks to both readers 
	divided by smaller of the number of books a has read and the number of books b has read.
	 */
	public static double similarity(Person a, Person b) {
		ArrayList<Book> checkedOutByA = a.getCheckedOut();
		ArrayList<Book> checkedOutByB = b.getCheckedOut();
		if(checkedOutByB.size() == 0 || checkedOutByA.size() == 0) {
			return 0;
		}
		else {
			return commonBooks(a, b).size()/Math.min((double) checkedOutByA.size(), (double) checkedOutByB.size());
		}

	}

}

