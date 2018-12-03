import java.util.Scanner;
 class Main {

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		Library libInstance = Library.getInstance();
		libInstance.deserialize();

		System.out.println("--------------------------------------------------------");
		System.out.println("\tWelcome to Library Management System");
		System.out.println("--------------------------------------------------------");

		System.out.println("Following Functionalities are available: \n");
		System.out.println("1- Login");
		System.out.println("2- Exit");
		System.out.println("3- Login Administrator"); // Administration has access only

		System.out.println("-----------------------------------------\n");

		int choice = 0;
		int userChoice = 0;

		choice = takeInput(0, 4);
		if (choice == 1) {
			int memberChoice;
			User userInstance = new User();

			System.out.println("\tWelcome to User's Portal");
			do {
				memberChoice = userInstance.prompt();
				if (memberChoice == 1) {
					// Search an Item
				} else if (memberChoice == 2) {
//Search for an Author
				} else if (memberChoice == 3) {
					// Check out an item
				} else if (memberChoice == 4) {
//4- Return a book
				}
			} while (memberChoice != 5);
		} else if (choice == 3) {
			int option, count, checkedOutChoice, adminChoice, classChoice;

			String bookTitle, iSBN, checkedOut;
			System.out.println("--------------------------------------------------------");
			System.out.println("\tWelcome to Admin's Portal");
			System.out.println("--------------------------------------------------------");
			do {
				Admin adminInstance = new Admin();
				classChoice = adminInstance.prompt();
				if (classChoice == 1) {
					// Add an item
					adminInstance.addItem();
				} else if (classChoice == 2) {
					// ("2- Delete Item");

					adminInstance.deleteItem();

				} else if (classChoice == 3) {
					// 3- View Issued Books History
					adminInstance.getItems();
				} else if (classChoice == 4) {
					// 4- View All Books in Library
				}
			} while (classChoice != 5);
			libInstance.serialize();

			System.out.println("Goodbye!");

		} else if (choice == 2) {
			libInstance.serialize();

			System.out.println("Goodbye!");
			// break;
		}

	}

	// Asking for Input as Choice
	public static int takeInput(int min, int max) {
		String choice;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("\nEnter Choice: ");

			choice = input.next();

			if ((!choice.matches(".*[a-zA-Z]+.*"))
					&& (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max)) {
				return Integer.parseInt(choice);
			}

			else
				System.out.println("\nInvalid Input.");
		}

	}

	public static String checkedOut(int choice) {
		String str;
		if (choice == 1)
			return str = "Checked Out";
		else if (choice == 2)
			return str = "Not checked Out";
		else
			return str = "Invalid";
	}

	public static int saveYorN() {
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
	
	
	/*
	  public void readTable(String fileName){
	        Scanner inputFile=null;
	        int i=0;
	        try{
	        inputFile = new Scanner(new File(fileName));

	        while (inputFile.hasNext()){
	           int atomicnumber = inputFile.nextInt();
	           String abb = inputFile.next();
	           String atomicname = inputFile.next();
	           float atomicweight = inputFile.nextFloat(); 
	           table[i]=new PeriodicElement(atomicnumber,abb,atomicname,atomicweight);
	            ++i;
	        }
	        }catch(FileNotFoundException e){
	            System.out.println(fileName+"not found");
	            System.exit(0);
	        }
	        realElements=i;
	        inputFile.close();
	        }*/

}
