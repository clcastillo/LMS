import static org.junit.Assert.*;
import org.junit.*;

public class BookTest {

	private Book b;

	@BeforeClass
	public void testBefore() {
		b = new Book("1960", "To Kill a Mockingbird", "Harper Lee", "9780446777889", "Not checked Out");
	}

	@Test
	public void testGetTitle() {
		assertTrue(b.getTitle().equals("To Kill a Mockingbird"));
	}

	@Test
	public void testGetCheckedStatus() {
		assertFalse(b.getTitle().getCheckedStatus());
	}

	@Test
	public void testGetAuthor() {
		assertTrue(b.getAuthor().equals("Harper Lee"));
	}
}