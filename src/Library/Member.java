package Library;

import java.util.ArrayList;

public abstract class Member {

	private int id;
	private String name;
	private ArrayList<Book> borrowedBooks;
	
	Member(int id , String name )
	{
		this.id = id;
		this.name = name;
		this.borrowedBooks =new ArrayList<>();
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	
	public int getBorrowLimit()
	{
		return 0;
	}
	
	@Override
	public String toString()
	{
		return " Member Id : "+this.id+" \n Name of Member : "+this.name;
	}
	
	
	public void addBorrowedBook(Book book)
	{
		borrowedBooks.add(book);
	}
	
	public int getBorrowBookCount()
	{
		return borrowedBooks.size();
	}
	
	public void removeBorrowedBook(Book book)
	{
		borrowedBooks.remove(book);
	}
	
	public boolean hasBorrowedBook(Book book)
	{
		return borrowedBooks.contains(book);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}