import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Library implements Serializable, Comparable<Library> {
	private static final long serialVersionUID = -8037046062196866724L;
	private String filename = "librarycatalog.txt";
	protected static ArrayList<LibraryCat> catalogList = new ArrayList<LibraryCat>();

	/*----Following Singleton Design Pattern (Lazy Instantiation)------------*/
	private static Library obj = null;

	public static Library getInstance() {
		if (obj == null) {
			obj = new Library();
		}
		return obj;
	}

	public void serialize() {
		try {
			ObjectOutputStream objectOutputFile = new ObjectOutputStream(new FileOutputStream(filename));
			objectOutputFile.writeObject(catalogList);
			objectOutputFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public void deserialize() {
		File f = new File(filename);
		if (f.exists()) {
			try {
				ObjectInputStream objectInputFile = new ObjectInputStream(new FileInputStream(filename));
				 catalogList = (ArrayList<LibraryCat>) objectInputFile.readObject();
				 Collections.sort(catalogList);
				objectInputFile.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
				return;
			} catch (ClassNotFoundException c) {
				System.out.println("Class not found");
				c.printStackTrace();
				return;
			}

		}

	}

	public static int takeInput(int min, int max) {
		String choice;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("\nEnter Choice: ");

			choice = input.next();

			if ((!choice.matches(".*[a-zA-Z]+.*"))
					&& (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max)) {
				return Integer.parseInt(choice);
			}

			else
				System.out.println("\nInvalid Input.");
		}

	}

	public static String checkedOut(int choice) 
	{
		if (choice == 1)
			return "Checked Out";
		else if (choice == 2)
			return "Not checked Out";
		else
			return "Invalid";
	}

	public static int saveYorN() {
		Scanner keyboard = new Scanner(System.in);
		String saveStr;
		char saveChar;
		System.out.print("Save (y/n): ");
		saveStr = keyboard.next();
		saveChar = saveStr.charAt(0);
		if (saveChar == 'N' || saveChar == 'n')
			return 0;
		else
			return 1;
	}

	@Override
	public int compareTo(Library o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
