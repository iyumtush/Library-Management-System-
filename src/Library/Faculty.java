package Library;

public class Faculty extends Member{

	private String department;
	
	Faculty(int id, String name , String department) {
		super(id, name);
		this.department = department;
	}
	
	public void setDepartment(String department)
	{
		this.department = department;
	}
	
	public String getDepartment()
	{
		return department;
	}

	@Override
	public String toString()
	{
		return super.toString() + "\n Department : "+this.department;
	}
	
	@Override
	public int getBorrowLimit()
	{
		return 5;
	}
}
