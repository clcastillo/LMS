import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Pattern;

public class Book extends Item implements Serializable
{
	private static final long serialVersionUID = 3497279689453444576L;
	private String author, isbn;
	private boolean isbnMatches;
	//VALID ISBN: 0-940016-64-8 or 978-0-940016-64-4 17
	Pattern isbn10 = Pattern.compile("\\d{1}-\\d{6}-\\d{2}-\\d{1}");
	Pattern isbn13 = Pattern.compile("\\d{3}-\\d{1}-\\d{6}-\\d{2}-\\d{1}");

	Book(String id, String bookTitle, String bookAuthor, String iSBN, String checkedOut) throws IOException {
		title= bookTitle;
		isbn= iSBN;
		chkout= checkedOut;
		author = bookAuthor;
		isbn = iSBN;
		libID= id;
	}

	public Book() 
	{}

	public void addBook() {
		try {
			libInstance = new Book(libID, title, author, isbn, chkout);
			addItem(libInstance);
			//catalogList.add(libInstance);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void requestBook()
	{
		
		requestInfo();
		System.out.print("Author: ");
		author = keyboard.nextLine().toUpperCase();
		do
		{
			System.out.print("ISBN: ");
			isbn = keyboard.next();
			isbnMatches= (isbn13.matcher(isbn).matches() || isbn10.matcher(isbn).matches());
			if(!isbnMatches)
				System.out.print("Please enter a valid ISBN10 or ISBN13 value, including dashes");
		}while(!isbnMatches);

		System.out.print("Checked Out (1. Yes 2. No): ");
		chkout = checkedOut(keyboard.nextInt());
		if (saveYorN()==1) 
			addBook();
	}
	
	public String getAuthor() {
	
		return author;
	}
	 
	public String toString() 
	{	
		return String.format("Book-  ID: %6s, Title: %20s, Author: %22s, ISBN: %16s, Status: %15s",
				libID, title.substring(0, Math.min(title.length(), 20)), author.substring(0, Math.min(author.length(), 20)), isbn, chkout); 
	}

}
