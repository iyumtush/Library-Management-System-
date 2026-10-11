package Library;

import java.util.ArrayList;

public class Library {

	private ArrayList<Book> books;
	
	Library()
	{
		this.books = new ArrayList<>();
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
			 System.out.println("\nBook added succesesfully !");
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
}

