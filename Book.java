import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Book extends LibraryCat {
	private static final long serialVersionUID = 3497279689453444576L;
	private String bookTitle, bookAuthor, iSBN, checkedOut;
	LibraryCat libInstance = LibraryCat.getInstance();

	Book(String bookTitle, String bookAuthor, String iSBN, String checkedOut) throws IOException {
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.iSBN = iSBN;
		this.checkedOut = checkedOut;
	}

	public Book() {
	}

	public void requestInfo() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Title:");
		bookTitle = keyboard.nextLine().toUpperCase();
		System.out.println("Author: ");
		bookAuthor = keyboard.nextLine().toUpperCase();
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
			libInstance = new Book(bookTitle, bookAuthor, iSBN, checkedOut);
			catalogList.add(libInstance);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getTitle() {
		return bookTitle;
	}

	public String getAuthor() {
		return bookAuthor;
	}
//returns true if its checked out
	public boolean getCheckedStatus() {
		if (checkedOut.equals("Checked Out")) {
			return true;
		} else
			return false;

	}

	public void setCheckedOut() {
		if (checkedOut == "Checked Out") {
			System.out.println("This item is already checked out");
		} else {
			this.checkedOut = "Checked Out";
		}
	}

	public void setReturned() {
		this.checkedOut = "Not checked Out";
	}

	public String toString() {
		String str;
		str = "Book: " + "    Title: " + bookTitle + "    Author:" + bookAuthor + "    ISBN:" + iSBN + ""
				+ "    Status: " + checkedOut;
		return str;
	}

}
