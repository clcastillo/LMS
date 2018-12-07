import java.util.Scanner;

class Main
{
	public static void main(String args[]) 
	{
		int choice;
		Library libInstance = Library.getInstance();
		libInstance.deserialize();

		do
		{
			System.out.println("--------------------------------------------------------");
			System.out.println("\tWelcome to Library Management System");
			System.out.println("--------------------------------------------------------");
			System.out.println("Following functionalities are available: \n");
			System.out.println("1- User login");
			System.out.println("2- Admin login ");
			System.out.println("3- Exit");
			System.out.println("-----------------------------------------\n");
			
			choice = takeInput(0, 4);
			
			if (choice == 1) 
			{
				int memberChoice;
				User userInstance = new User();
	
				System.out.println("--------------------------------------------------------");
				System.out.println("\tWelcome to User Portal");
				System.out.println("--------------------------------------------------------");
				do 
				{
					memberChoice = userInstance.prompt();
					if (memberChoice == 1) 
						userInstance.searchTitle();
					else if (memberChoice == 2) 
						userInstance.searchID();
					else if (memberChoice == 3)
						userInstance.getItems();
					else if (memberChoice == 4)
					{
						userInstance.getItems();
						userInstance.checkOut();
					}
					else if (memberChoice == 5)
					{
						userInstance.getItems();
						userInstance.returnItem();
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
					System.out.println("\tWelcome to Admin Portal");
					System.out.println("--------------------------------------------------------");
					do 
					{
						classChoice = adminInstance.prompt();
						
						if (classChoice == 1) 
							adminInstance.addItem();
						else if (classChoice == 2) 
							adminInstance.deleteItem();
						else if (classChoice == 3) 
							adminInstance.issuedItems();
						else if (classChoice == 4) 
							adminInstance.getItems();
					} while (classChoice != 5);
					libInstance.serialize();
					System.out.println("RETURNING TO MAIN MENU...");
					System.out.println();
				}
				else
				{
					System.out.println("ACCESS DENIED. PLEASE SEE AN ADMINISTRATOR.");
				}
			} 
			
		}while (choice != 3);
		if(choice==3)
		{
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
			System.out.print("\nEnter choice: ");
			choice = input.next();
			if ((!choice.matches(".*[a-zA-Z]+.*"))
					&& (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max)) 
				return Integer.parseInt(choice);
			

			else
				System.out.println("\nInvalid input.");
		}
	}
}

