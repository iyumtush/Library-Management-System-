package Library;

public class Book {

	private int id ;
	private String title;
	private String author;
	private boolean available;
	
	Book(int id,String title,String author,boolean available)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.available = available;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getId()
	{
		return id;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
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
		return " The book id : "+ this.id + "\n Title : " + this.title 
				+ "\n Author Name : " + this.author + "\n Availablity : " + this.available ;
	}
}
