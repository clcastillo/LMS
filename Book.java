import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Book extends LibraryCat  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3497279689453444576L;
	private String bookTitle, bookAuthor, iSBN, checkedOut, checkedPerson;
	LibraryCat libInstance = LibraryCat.getInstance();

	Book(String bookTitle, String bookAuthor, String iSBN, String checkedOut, String checkedPerson) throws IOException {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.iSBN = iSBN;
		this.checkedOut = checkedOut;
		this.checkedPerson = checkedPerson;
	}

	public Book() {
	}

	public void requestInfo() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Title:");
		bookTitle = keyboard.nextLine();
		//bookTitle = bookTitle.toUpperCase();
		System.out.println("Author: ");
		bookAuthor = keyboard.nextLine();
		System.out.println("ISBN: ");
		iSBN = keyboard.next();
		System.out.println("Checked Out: \n 1. Yes 2. No");
		int checkedOutChoice = keyboard.nextInt();
		checkedOut = checkedOut(checkedOutChoice);
		if (saveYorN() == 1) {
			addItem();
		}
	}

	public void addItem() {
		try {
			libInstance = new Book(bookTitle, bookAuthor, iSBN, checkedOut, checkedPerson);
			catalogList.add(libInstance);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String toString() {
		String str;
		str = "Book: " + " Title: " + bookTitle + " Book Author:" + bookAuthor + " ISBN:" + iSBN + "" + " Checked Out: "
				+ checkedOut;
		return str;
	}

}
