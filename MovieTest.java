import static org.junit.Assert.*;
import org.junit.*;

public class MovieTest {

	private Movie m;

	@BeforeClass
	public void testBefore() {
		m = new Movie("2010", "Inception", "Christopher Nolan", "Science Fiction", "Not checked Out");
	}

	@Test
	public void testGetTitle() {
		assertTrue(m.getTitle().equals("Inception"));
	}

	@Test
	public void testGetCheckedStatus() {
		assertFalse(m.getTitle().getCheckedStatus());
	}
}