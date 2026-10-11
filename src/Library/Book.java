package Library;

public class Book implements Borrowable{

	final private int id ;
	final private String title;
	final private String author;
	private boolean available;
	
	Book(int id,String title,String author,boolean available)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.available = available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	final public int getId()
	{
		return id;
	}
	final public String getTitle()
	{
		return title;
	}
	final public String getAuthor()
	{
		return author;
	}
	public boolean getAvailable()
	{
		return available;
	}
	
	@Override
	public String toString()
	{
		return " \n The book id : "+ this.id + "\n Title : " + this.title 
				+ "\n Author Name : " + this.author + "\n Availablity : " + this.available ;
	}

	@Override
	public void borrowing() {
		
		if(this.available == true)
		{
			System.out.println("\nThe book "+this.title+" is available you can borrow\n");
			this.available = false;
		}
		else{
		 System.out.println("The book "+this.title+" you are looking is not available , check after some time\n");
		}
		
	}

	@Override
	public void returning() {
		if(this.available == false)
		{
			this.available = true;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
