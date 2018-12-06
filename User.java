import java.io.Serializable;
import java.util.Scanner;

public class User extends Library {
	private static final long serialVersionUID = -16820323213541553L;
	Scanner keyboard = new Scanner(System.in);
	int userChoice;
	boolean status=false;

	public int prompt() {
		do {
			System.out.println();
			System.out.println("Following Functionalities are available: \n");
			System.out.println("1- Search an Item");
			System.out.println("2- Search for an Author");
			System.out.println("3- View all items");
			System.out.println("4- Check out an item");
			System.out.println("5- Return a book");
			System.out.println("6- Logout");
			System.out.println("---------------------------------------------");
			userChoice = takeInput(0, 7);
			return userChoice;
		} while (userChoice != 6);
	}
	public String searchTitle() {
		System.out.println("Enter item title to search:");
		String title = keyboard.nextLine().toUpperCase();
		for (int i = 0; i < catalogList.size(); i++) {
			// System.out.println(((Book) catalogList.get(i)).getTitle() + "= " + title);
			if (((Book) catalogList.get(i)).getTitle().equals(title)) {
				System.out.println("Its in the library: Item " + (i + 1));
				status = true;
			}
		}if(status==false) {
			System.out.println("Sorry, we don't have that item");
		}
		return null;

	}

	public String searchAuthor() {
		System.out.println("Enter item author to search:");
		String author = keyboard.nextLine().toUpperCase();
		for (int i = 0; i < catalogList.size(); i++) {
			if (((Book) catalogList.get(i)).getAuthor().equals(author)) {
				System.out.println("Its in the library: Item " + (i + 1));
				status=true;
			}
		}if(status==false) {
			System.out.println("Sorry, we don't have that author");
		}
		return null;
	}

	public String checkOut() {
		System.out.println("Enter the item number to check out:");
		int checkOut = keyboard.nextInt();
		if (((Book) catalogList.get(checkOut - 1)).getCheckedStatus()) {
			System.out.println("This item is already checked out.");
		} else {
			((Book) catalogList.get(checkOut - 1)).setCheckedOut();
			System.out.println("Done.");
		}
		return null;
	}

	public String returnItem() {
		System.out.println("Enter the item number to return:");
		int returnItem = keyboard.nextInt();
		((Book)catalogList.get(returnItem - 1)).setReturned();
		System.out.println("Done.");

		return null;
	}

	public void getItems() {
		int c = 1;
		System.out.println("Library Catalog Items: ");
		for (Library i : Library.catalogList) {
			System.out.println(c + "." + i);
			c++;
		}
	}
}
