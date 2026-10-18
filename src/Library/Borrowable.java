package Library;

public interface Borrowable {

	void borrowing() throws BookNotAvailableException;
	
	void returning();
	 
}
