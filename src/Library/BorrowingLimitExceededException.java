package Library;

public class BorrowingLimitExceededException extends Exception{
	
	BorrowingLimitExceededException(String message)
	{
		super(message);
	}
}
