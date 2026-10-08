package Library;

public class Library {

	private Book[] books;
	
	Library(Book[] books)
	{
		this.books = books;
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
	}

