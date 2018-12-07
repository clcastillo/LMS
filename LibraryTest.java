import static org.junit.Assert.*;
import org.junit.*;

public class LibraryTest {

	private Library l;

	@BeforeClass
	public void testBeforeClass() {
		l = Library.getInstance();
	}

	@Test
	public void testSerialize() {
		assertTrue(new File("librarycatalog.txt").exists());
	}

	@Test
	public void testDeserialize() {
		assertTrue(new File("librarycatalog.txt").exists());
	}
}