import java.io.Serializable;
import java.util.Scanner;

public class Admin extends Library {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5441115714932764431L;
	Scanner keyboard = new Scanner(System.in);
	Library libCatalogInstance = LibraryCat.getInstance();
	String name;
	int id;

	public int prompt() {
		System.out.println();
		System.out.println("Following Functionalities are available: \n");

		System.out.println("1- Add Item");
		System.out.println("2- Delete Item");
		System.out.println("3- View Issued Books History");
		System.out.println("4- View All Books in Library");
		System.out.println("5- Logout");
		System.out.println("---------------------------------------------");
		int userChoice = takeInput(0, 6);
		return userChoice;

	}

	public void addItem() {
		System.out.println("1- Add Book");
		System.out.println("2- Add Movie");
		System.out.println("---------------------------------------------");
		int adminChoice = keyboard.nextInt();

		if (adminChoice == 1) {
			Book addBook = new Book();
			addBook.requestInfo();
		}
		if (adminChoice == 2) {

		}
	}

	public void deleteItem() {
		getItems();

		System.out.println();
		if (catalogList.size() == 0) {
			System.out.println("Error library has no items");
		}
		System.out.println("Select the number you want to delete");

		int deleteNumb = keyboard.nextInt();
		int delete = deleteNumb - 1;
		catalogList.remove(delete);
		System.out.println("Item deleted");
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
