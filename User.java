import java.io.Serializable;
import java.util.Scanner;

public class User extends Library implements Serializable
{
	private static final long serialVersionUID = -16820323213541553L;
	Scanner keyboard = new Scanner(System.in);
	int userChoice;
	String input;
	boolean status;

	public int prompt() {
		do {
			System.out.println();
			System.out.println("Following Functionalities are available: \n");
			System.out.println("1- Search library by title");
			System.out.println("2- Search library by library ID");
			System.out.println("3- View all items");
			System.out.println("4- Check out an item");
			System.out.println("5- Return an item");
			System.out.println("6- Logout");
			
			System.out.println("---------------------------------------------");
			userChoice = takeInput(0, 8);
			return userChoice;
		} while (userChoice != 7);
	}
	public void searchTitle() 
	{
		status = false;
		System.out.print("Enter item title to search: ");
		input = keyboard.nextLine().toUpperCase();
		for (int i = 0; i < catalogList.size(); i++) 
		{
			if (((Item) catalogList.get(i)).getTitle().equals(input)) 
			{
				System.out.println("It's in the library: Item " + (i + 1));
				status = true;
			}
		}
		
		if (status == false)
			System.out.println("Sorry, we don't have that item.");
	}
	
	public void searchID() {
		status = false;
		System.out.print("Enter item ID to search: ");
		input = keyboard.nextLine().toUpperCase();
		for (int i = 0; i < catalogList.size(); i++) 
		{
			if (((Item) catalogList.get(i)).getID().equals(input)) 
			{
				System.out.println("It's in the library: Item " + (i + 1));
				status = true;
			}
		}
		if (status == false)
			System.out.println("Sorry, we don't have that item.");
	}

	public void checkOut() 
	{
		System.out.print("\nEnter the item number to check out: ");
		userChoice= keyboard.nextInt();
		((Item) catalogList.get(userChoice - 1)).setCheckedOut();
		System.out.println("Done.");
	}

	public void returnItem() 
	{
		System.out.print("\nEnter the item number to return: ");
		
		userChoice= keyboard.nextInt();
		((Item)catalogList.get(userChoice- 1)).setReturned();
		System.out.println("Done.");
	}

	public void getItems() {
		int c = 1;
		System.out.println("Library Catalog Items: ");
		for (Library i : Library.catalogList) {
			System.out.println(c + ". " + i);
			c++;
		}
	}
}
