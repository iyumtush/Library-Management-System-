package Library;

public class Member {

	private int id;
	private String name;
	
	Member(int id , String name)
	{
		this.id = id;
		this.name = name;
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
	
	public String toString()
	{
		return "  Member Id : "+this.id+" \n Name of Member : "+this.name;
	}
}
