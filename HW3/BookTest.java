import org.junit.*;
public class BookTest {
	//equals() test #1:
	@Test(timeout = 100)
	public void testEquals() {
		Object o = new Object;
		Book b = new Book;
		AssertFalse(b.getClass() != o.getClass());
		
	}
	
}