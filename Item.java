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
		if (chkout == "Checked out") {
			System.out.println("This item is already checked out");
		} else {
			chkout = "Checked out";
		}
	}

	public void setReturned() {
		this.chkout = "Not checked out";
	}
	public boolean getCheckedStatus() 
	{
		if (chkout.equals("Checked out"))
			return true;
		else
			return false;

	}
	
	public boolean dupeID(String id)
	{
		boolean dupe= false;
		for (int i = 0; i < catalogList.size(); i++) 
		{
			if (((Item) catalogList.get(i)).getID().equals(id)) 
			{
				dupe= true;
				break;
			}
		}
		
		return dupe;
	}
	public void addItem(LibraryCat lib)
	{
		catalogList.add(lib);
	}
	protected void requestInfo() 
	{
		String tempID; 
		System.out.print("Title: ");
		title = keyboard.nextLine().toUpperCase();
		do
		{
			System.out.print("Library ID: ");
			tempID= keyboard.nextLine();
			if(tempID.length()>6 || tempID.length() == 0)
				System.out.println("Please enter a 6 character alphanumeric ID");
			if(dupeID(tempID))
				System.out.println("ID " + tempID + " already exists in library. Please enter another ID. ");
		}while(tempID.length()>6 || tempID.length() == 0 || dupeID(tempID));
		
		libID= tempID;
	}
}