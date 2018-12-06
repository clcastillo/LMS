import java.io.Serializable;
import java.util.ArrayList;

public class LibraryCat extends Library implements Serializable
{
	private static final long serialVersionUID = 8836651487362500513L;
	protected String title;
	protected String author;
	protected String iSBN;
	protected String checkedOut;
	protected int returnDate;

	protected Book books;
	/*----Following Singleton Design Pattern (Lazy Instantiation)------------*/
	private static LibraryCat obj = null;
	/*
	 * public LibraryCat(String bookTitle, String bookAuthor, String iSBN2, String
	 * checkedOut2) { // TODO Auto-generated constructor stub }
	 * 
	 * public LibraryCat() { // TODO Auto-generated constructor stub }
	 */

	public static LibraryCat getInstance() {
		if (obj == null) {
			obj = new LibraryCat();
		}

		return obj;
	}

	/*---------------------------------------------------------------------*/

}
