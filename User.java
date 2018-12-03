import java.io.Serializable;

public class User extends Library  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -16820323213541553L;
	//private static final long serialVersionUID = -1626403704913725407L;

	int userChoice;
	public int prompt() {
		do {
			System.out.println("Following Functionalities are available: \n");
			System.out.println("1- Search an Item");
			System.out.println("2- Search for an Author");
			System.out.println("3- Check out an item");
			System.out.println("4- Return a book");
			System.out.println("5- Logout");
			System.out.println("---------------------------------------------");
			userChoice = takeInput(0, 6);
			return userChoice;
		} while (userChoice != 5);

	}

	public Item searchItem() {
		return null;
	}

	public Item searchAuthor() {
		return null;
	}

	public Item checkOut() {
		return null;
	}

	public Item returnItem() {
		return null;
	}
}
