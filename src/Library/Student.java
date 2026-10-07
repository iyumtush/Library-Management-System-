package Library;

public class Student extends Member {

	private String course;
	
	Student(int id, String name , String course) {
		super(id, name);
		this.course = course;
	}
	
	public void setCourse(String course)
	{
		this.course = course;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + "\n Course : "+this.course;
	}
	
	@Override
	public int getBorrowLimit()
	{
		return 3;
	}
	
}
