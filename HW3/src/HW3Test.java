/*
3Julia Shea
jts6mq
Homework 3
people/sources: stack overflow, as well as fellow classmates Kristen Lucas and Tricia Bonner for concept explanation!
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HW3Test {

	//test of numCopies method
	@Test
	public void testNumCopies() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create library
		Library library = new Library("Alderman");

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);

		assertEquals(2, library.checkNumCopies("Harry Potter", "J.K. Rowling"));
		//expected: returns 2 copies, JUnit test is successful 

	}

	//second test of numCopies method
	@Test
	public void testNumCopies2() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create library
		Library library = new Library("Alderman");

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);

		assertEquals(1, library.checkNumCopies("Economics Textbook", "McGraw-Hill"));
		//expected: returns 1 copy, JUnit test is successful
	}

	//test of checkOut method
	@Test
	public void testCheckOut() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create patrons
		Person person1 = new Person("Parisa", "12 Apple Ln", 123);
		Person person2 = new Person("Julia", "14 University Ave", 456);
		Person person3 = new Person("Anderson", "45 Church St", 789);

		//create library
		Library library = new Library("Alderman");

		//add patrons to library patrons
		library.getPatrons().add(person1);
		library.getPatrons().add(person2);
		library.getPatrons().add(person3);

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);


		//set books to either checked out or not checked out
		book1.setCheckedOut(false);

		assertTrue(library.checkOut(person1, book1, "09 30 2018"));
		//returns true because book1 is not checked out


	}
	//second test of checkout method
	@Test
	public void testCheckOut2() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create patrons
		Person person1 = new Person("Parisa", "12 Apple Ln", 123);
		Person person2 = new Person("Julia", "14 University Ave", 456);
		Person person3 = new Person("Anderson", "45 Church St", 789);

		//create library
		Library library = new Library("Alderman");

		//add patrons to library patrons
		library.getPatrons().add(person1);
		library.getPatrons().add(person2);
		library.getPatrons().add(person3);

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);


		//set books to either checked out or not checked out
		book4.setCheckedOut(false);

		assertTrue(library.checkOut(person3, book4, "09 30 2018"));
		//returns true because book1 isn't checked out

	}
	//test of due date method
	@Test
	public void testBooksDueDate() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);


		//create library
		Library library = new Library("Alderman");			 
		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);


		//set due dates for created books
		book1.setDueDate("09 20 2018");
		book2.setDueDate("09 21 2018");
		book3.setDueDate("09 22 2018");
		book4.setDueDate("09 22 2018");
		book5.setDueDate("09 23 2018");
		//create list of books matching 9/22
		ArrayList<Book> booksDueList = new ArrayList<Book>();
		booksDueList.add(book3);
		booksDueList.add(book4);
		ArrayList<Book> booksDuePassed = new ArrayList<Book>(library.booksDueOnDate("09 22 2018"));
		assertEquals(booksDueList, booksDuePassed);

	}

	//second test of due date
	@Test
	public void testBooksDueDate2() {
		//create books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);


		//create library
		Library library = new Library("Alderman");			 
		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);


		//set due dates for created books
		book1.setDueDate("09 20 2018");
		book2.setDueDate("09 21 2018");
		book3.setDueDate("09 22 2018");
		book4.setDueDate("09 22 2018");
		book5.setDueDate("09 23 2018");
		//create list of books matching 9/21
		ArrayList<Book> booksDueList2 = new ArrayList<Book>();
		booksDueList2.add(book2);
		ArrayList<Book> booksDuePassed2 = new ArrayList<Book>(library.booksDueOnDate("09 21 2018"));
		assertEquals(booksDueList2, booksDuePassed2);

	}

	//testing the late fee
	@Test
	public void testLateFee() {

		//creating books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create patrons
		Person person1 = new Person("Parisa", "12 Apple Ln", 123);
		Person person2 = new Person("Julia", "14 University Ave", 456);
		Person person3 = new Person("Anderson", "45 Church St", 789);

		//create library
		Library library = new Library("Alderman");

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);

		//add patrons to library patrons
		library.getPatrons().add(person1);
		library.getPatrons().add(person2);
		library.getPatrons().add(person3);

		//person1 checks out book1
		book1.setDueDate("20 09 2018");
		person1.getCheckedOut().add(book1);
		//set current date and expected fee
		library.setCurrentDate("29 09 2018");
		double fee = 1.0791;

		assertEquals(fee, library.lateFee(person1), 0);

	}


	//testing the late fee again
	@Test
	public void testLateFee2() {

		//creating books
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 123456, 11.99);
		Book book2 = new Book("Economics Textbook", "McGraw-Hill", 23457, 12.00);
		Book book3 = new Book("Harry Potter", "J.K. Rowling", 78910, 11.99);
		Book book4 = new Book("Computer Science Textbook", "McGraw-Hill", 10039, 4.50);
		Book book5 = new Book("The Cat in The Hat", "Dr. Seuss", 890, 9.99);

		//create patrons
		Person person1 = new Person("Parisa", "12 Apple Ln", 123);
		Person person2 = new Person("Julia", "14 University Ave", 456);
		Person person3 = new Person("Anderson", "45 Church St", 789);

		//create library
		Library library = new Library("Alderman");

		//add created books to the library
		library.getLibraryBooks().add(book1);
		library.getLibraryBooks().add(book2);
		library.getLibraryBooks().add(book3);
		library.getLibraryBooks().add(book4);
		library.getLibraryBooks().add(book5);

		//add patrons to library patrons
		library.getPatrons().add(person1);
		library.getPatrons().add(person2);
		library.getPatrons().add(person3);

		//person1 checks out book1
		book2.setDueDate("20 09 2018");
		person2.getCheckedOut().add(book2);
		//set current date and expected fee
		library.setCurrentDate("20 09 2018");
		double fee = 0.0;

		assertEquals(fee, library.lateFee(person2), .1);

	}

}

