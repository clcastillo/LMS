import java.io.Serializable;
import java.util.ArrayList;

public class LibraryCat extends Library {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8836651487362500513L;
	protected String title;
	protected String author;
	protected String iSBN;
	protected String checkedOut;
	protected int returnDate;

	protected Book books;
	
	/*----Following Singleton Design Pattern (Lazy Instantiation)------------*/
	private static LibraryCat obj = null;

	public static LibraryCat getInstance() {
		if (obj == null) {
			obj = new LibraryCat();
		}

		return obj;
	}

	/*---------------------------------------------------------------------*/

}
