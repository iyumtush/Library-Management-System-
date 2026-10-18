package Library;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {

	private ArrayList<Book> books;
	Library()
	{
	    try
	    {
	        this.books = DatabaseConnection.getAllBooks();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	        this.books = new ArrayList<>();
	    }
	}
	 
	public void searchBook(int id)
	{
		boolean found = false;
		 for(Book x : books)
		  {
			 if(id == x.getId())
			 {
				 found = true;
			 }
		  }
		 
		 if(found == true)
		  {
			  System.out.println("Your book found with id : "+id);
		  }
		  else
		  {
			  System.out.println("Can't find");
		  }	  
	    }
		
	public void searchBook(String title)
	{
		boolean found = false;
		 
		for(Book x : books)
		  {
			 if(title.equalsIgnoreCase(x.getTitle()))
			 {
				 found = true;
			 }
		  }
		 
		 if(found == true)
		  {
			  System.out.println("Your book found with title : "+title+"\n");
		  }
		  else
		  {
			  System.out.println("Can't find\n");
		  }	  
		 

	    }
	 
	public void addBook(Book book )
	 {
		if(isBookExist(book.getId()) == false)
		{
			 books.add(book);
			 
			 try {
				 DatabaseConnection.addBookToDatabase(book);
				System.out.println("\nBook added succesesfully !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("\nBook id already exist , add book with diffrent id");
		}
		 
	 }   
    public int getTotalBook( )
     {
    	return books.size();
     } 
    
    public void removeBook(int id)
    {
      books.remove(id);
		 System.out.println("\nBook with id : "+id+" is removed succesesfully");
    } 
    
    public void displayBook()
    {
    	if(books.isEmpty() == false)
    	{
    		System.out.println("\n Books available in the library : \n");
    		for(Book x : books)
    		{
    			System.out.println(x);
    		}
    	}
    	else
    	{
    		System.out.println("\nLibrary is empty at this time. Come back later...");
    	}
    } 
    
    public boolean isBookExist(int id)
    {
    	for(Book x : books)
		{
			if(id == x.getId())
			{
				return true;
			}
		}
    	
    	return false;
    }
    
    public void borrowBook(Member member)
	{
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the book id which you want to borrow "
				+ "\nID: ");
		int mbookid = scanner.nextInt();
		scanner.nextLine();
		
		Book foundBook = null;
		 for(Book x : books)
		  {
			 if(mbookid == x.getId())
			 {
				 foundBook = x;
				 break;
			 
		     }  
			 
	      }
		 
		 if(foundBook != null && foundBook.getAvailable() == true)
		 {
			 System.out.print("\nYour book found with id : "+mbookid+" "
			 		+ "\nBook Info : "+foundBook.toString());
			 System.out.print("\nDo you want to borrow this book ? (Yes/No) "
			 		+ "\n:");
			 String ansBorrow = scanner.nextLine();
			 
			 if(ansBorrow.equalsIgnoreCase("Yes"))
			 {
				 if(member.getBorrowBookCount() < member.getBorrowLimit())
				 {
				 member.addBorrowedBook(foundBook);
				 System.out.println("\nThe book has been borrowed succsesfully..."); 
				 foundBook.setAvailable(false);
				 }else
				    {
				        System.out.println("\nYou have reached your borrowing limit.");
				    }
			 }else
			 {
				 System.out.println("\nNo changes has been made");
			 }
		 }
		 else if(foundBook != null && foundBook.getAvailable() == false)
		  {
			  System.out.println("\nYour book found with id : "+mbookid+" , But currently its unavailable."
			  		+ " \n Book Info : "+foundBook.toString());
		  } else
		  {
			  System.out.println("\nYour book with id "+mbookid+" cannot find ");
		  }
	 }
    
    public void returnBook(Member member)
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.print("\nEnter the book id you want to remove. "
    			+ "\nID: ");
    	int bookId = scanner.nextInt();
    	
    	Book foundBook = null;
    	for(Book x : books)
    	{
    		if(bookId == x.getId())
    		{
    		foundBook = x;
    		break;
    		}
    	}
    	
    	if(foundBook == null)
    	{
    		System.out.println("\nBook not found");
    	}
    	else if(member.hasBorrowedBook(foundBook))
    	{
    		member.removeBorrowedBook(foundBook);
    		foundBook.setAvailable(true);
    	   System.out.println("\nBook removed sucssesfully..");
    	}
    	else
    	{
    	    System.out.println("\nYou have not borrowed this book.");
    	}
    }
}


