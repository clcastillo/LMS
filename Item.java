import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public abstract class Item extends LibraryCat implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1353135714407906490L;
	protected String title, chkout, libID;
	protected transient Scanner keyboard= new Scanner(System.in);
	protected LibraryCat libInstance = LibraryCat.getInstance();
	
	public String getTitle()
	{
		return title;
	}
	
	public String getID()
	{
		return libID;
	}

	public void setCheckedOut() {
		if (chkout == "Checked Out") {
			System.out.println("This item is already checked out");
		} else {
			chkout = "Checked Out";
		}
	}

	public void setReturned() {
		this.chkout = "Not checked Out";
	}
	public boolean getCheckedStatus() 
	{
		if (chkout.equals("Checked Out")) 
			return true;
		else
			return false;

	}
	public void addItem(LibraryCat lib)
	{
		catalogList.add(lib);
	}
	protected void requestInfo() 
	{
		System.out.print("Title:");
		title = keyboard.nextLine().toUpperCase();
		do
		{
			System.out.print("Library ID: ");
			libID= keyboard.nextLine();
			if(libID.length()>6 || libID.length() == 0)
				System.out.println("Please enter a 6 character alphanumeric ID");
		}while(libID.length()>6 || libID.length() == 0);
	}
}
