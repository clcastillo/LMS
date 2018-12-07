import java.io.IOException;
import java.io.Serializable;


public class Movie extends Item implements Serializable
{
	private static final long serialVersionUID = -1626403704913725407L;
	LibraryCat libInstance = LibraryCat.getInstance();
	String genre, director;
	
	Movie(String id, String movieTitle, String movieDirector, String movieGenre, String checkedOut) throws IOException {
		title= movieTitle;
		director= movieDirector;
		genre= movieGenre;
		chkout= checkedOut;
		libID= id;
	}
	
	public Movie()
	{}
	
	public void addMovie() {
		try {
			libInstance = new Movie(libID, title, director, genre, chkout);
			addItem(libInstance);
			//catalogList.add(libInstance);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void requestMovie()
	{
		requestInfo();
		
		System.out.print("Director: ");
		director = keyboard.nextLine().toUpperCase();
		System.out.print("Genre: ");
		genre = keyboard.nextLine().toUpperCase();
		
		System.out.print("Checked Out (1. Yes 2. No): ");
		chkout = checkedOut(keyboard.nextInt());
		if (saveYorN()==1) 
			addMovie();
	}
	public String toString() 
	{	
		return String.format("Movie- ID: %6s, Title: %20s, Director: %20s, Genre: %15s, Status: %15s",
				libID, title.substring(0, Math.min(title.length(), 20)), director.substring(0, Math.min(director.length(), 20)), genre.substring(0,  Math.min(genre.length(),  10)), chkout); 
	}
}
