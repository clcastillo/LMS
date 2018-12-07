import java.io.Serializable;
import java.util.Scanner;

public class Admin extends Library implements Serializable 
{
	
	public static final String PASSWORD= "adminlib";
	
	private static final long serialVersionUID = 5441115714932764431L;
	Scanner keyboard = new Scanner(System.in);
	Library libCatalogInstance = LibraryCat.getInstance();
	String name, password;
	int id, choice;

	public int prompt() {
		System.out.println();
		System.out.println("Following Functionalities are available: \n");

		System.out.println("1- Add Item");
		System.out.println("2- Delete Item");
		System.out.println("3- View Issued Items History");
		System.out.println("4- View All Items in Library");
		System.out.println("5- Logout");
		System.out.println("---------------------------------------------");
		choice = takeInput(0, 6);
		return choice;

	}
	
	public boolean hasAccess()
	{
		System.out.print("Please enter the admin password: ");
		password= keyboard.next();
		if (password.equals(PASSWORD))
			return true;
		else
			return false;
	}

	public void addItem() {
		System.out.println("1- Add Book");
		System.out.println("2- Add Movie");
		System.out.println("---------------------------------------------");
		System.out.print("Enter Choice: ");
		choice = keyboard.nextInt();

		if (choice == 1) {
			Book addBook = new Book();
			addBook.requestBook();
		}
		if (choice == 2) 
		{
			Movie addMovie= new Movie();
			addMovie.requestMovie();
		}
	}

	public void deleteItem() {
		getItems();

		System.out.println();
		if (catalogList.size() == 0) 
		{
			System.out.println("Error: library has no items");
		}
		else
		{
			System.out.print("Select the number you want to delete, or enter -1 to exit: ");
			choice= keyboard.nextInt();
			//int deleteNumb = keyboard.nextInt();
			//int delete = deleteNumb - 1;
			while(choice != -1)
			{
				catalogList.remove(choice);
				System.out.println("Item deleted");
			}
		}
	}

	public void issuedItems() {
		System.out.println("Issued Items: ");
		for (int i = 0; i < catalogList.size(); i++) {
			if (((Book) catalogList.get(i)).getCheckedStatus() == true) {
				System.out.println(catalogList.get(i));
			}
		}

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
