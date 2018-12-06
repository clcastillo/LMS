import java.io.Serializable;
import java.util.Scanner;

class Main //implements Serializable
{
	public static void main(String args[]) 
	{
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		Library libInstance = Library.getInstance();
		libInstance.deserialize();

		do
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("\tWelcome to Library Management System");
			System.out.println("--------------------------------------------------------");
			System.out.println("Following Functionalities are available: \n");
			System.out.println("1- User Login");
			System.out.println("2- Admin Login "); // Administration has access only
			System.out.println("3- Exit");
			System.out.println("-----------------------------------------\n");
			
			choice = takeInput(0, 4);
			
			if (choice == 1) 
			{
				int memberChoice;
				User userInstance = new User();
	
				System.out.println("--------------------------------------------------------");
				System.out.println("\tWelcome to the User Portal");
				System.out.println("--------------------------------------------------------");
				do 
				{
					memberChoice = userInstance.prompt();
					if (memberChoice == 1) 
						userInstance.searchTitle();// Search an Item
					else if (memberChoice == 2) 
						userInstance.searchAuthor();// Search for an Author
					else if (memberChoice == 3) 
						userInstance.getItems();// All books
					else if (memberChoice == 4) 
					{
						userInstance.getItems();
						userInstance.checkOut();// Check out an item
					}
					else if (memberChoice == 5) 
					{
						userInstance.getItems();
						userInstance.returnItem();// Return a book
					}
				} while (memberChoice != 6);
				libInstance.serialize();
				System.out.println("Goodbye!");
			} 
			else if (choice == 2) 
			{
				int classChoice;
				Admin adminInstance = new Admin();
				
				if(adminInstance.hasAccess())
				{
					System.out.println("--------------------------------------------------------");
					System.out.println("\tWelcome to Admin's Portal");
					System.out.println("--------------------------------------------------------");
					do 
					{
						classChoice = adminInstance.prompt();
						
						if (classChoice == 1) 
							adminInstance.addItem(); // Add an item
						else if (classChoice == 2) 
							adminInstance.deleteItem();// Delete Item
						else if (classChoice == 3) 
							adminInstance.issuedItems(); // View Issued Books History
						else if (classChoice == 4) 
							adminInstance.getItems();// View All Books in Library
					} while (classChoice != 5);
					libInstance.serialize();
					System.out.println("RETURNING TO MAIN MENU...");
					System.out.println();
				}
				else
				{
					System.out.println("ACCESS DENIED. PLEASE SEE AN ADMINISTRATOR.");
					classChoice= 5;
				}
			} 
			
		}while (choice != 3);
		if(choice==3)
		{
			//libInstance.serialize();
			System.out.println("Goodbye!");
		}
	}

	// Asking for Input as Choice
	public static int takeInput(int min, int max) 
	{
		String choice;
		Scanner input = new Scanner(System.in);

		while (true) 
		{
			System.out.print("\nEnter Choice: ");
			choice = input.next();
			if ((!choice.matches(".*[a-zA-Z]+.*"))
					&& (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max)) 
				return Integer.parseInt(choice);
			

			else
				System.out.println("\nInvalid Input.");
		}
	}

	public static String checkedOut(int choice) 
	{
		String str;
		if (choice == 1)
			return str = "Checked Out";
		else if (choice == 2)
			return str = "Not checked Out";
		else
			return str = "Invalid";
	}

	public static int saveYorN() 
	{
		Scanner keyboard = new Scanner(System.in);
		String saveStr;
		char saveChar;
		System.out.println("Save (y/n)");
		saveStr = keyboard.next();
		saveChar = saveStr.charAt(0);
		if (saveChar == 'N' || saveChar == 'n')
			return 0;
		else
			return 1;
	}

}

