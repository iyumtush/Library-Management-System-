package Library;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseConnection 
{
	public static Connection getConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/Library_Management";
		String username = "root";
		String password = "TushNIIT123#";

		return DriverManager.getConnection(url, username, password);
	}
	
	public static void addBookToDatabase(Book book) throws SQLException
	{
		String sql = "INSERT INTO books (id , title , author , available) VALUES (?,?,?,?)";
		
		Connection con = getConnection();
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1,book.getId());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getAuthor());
	    ps.setBoolean(4, book.getAvailable());

	    ps.executeUpdate();

	    ps.close();

	    con.close();
	}
	
	public static  ArrayList<Book> getAllBooks() throws SQLException
	{
		ArrayList<Book> books = new ArrayList<>();
		
		String sql = "SELECT * FROM BOOKS";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			boolean available = rs.getBoolean("AVAILABLE");
			
			Book book = new Book(id , title, author, available);
			book.setAvailable(available);
			
			books.add(book);
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return books;
	}
	
	public static void addMemberToDatabase(Member Member) throws SQLException
	{
		String sql = "INSERT INTO MEMBERS (ID, NAME, MEMBER_TYPE, COURSE, DEPARTMENT) VALUES (?,?,?,?,?)";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, Member.getId());
		ps.setString(2, Member.getName());
		
		if(Member instanceof Student)
		{
			Student student = (Student) Member;
			
			ps.setString(3, "STUDENT");
			ps.setString(4, student.getCourse());
			ps.setString(5, null);
		}
		else if( Member instanceof Faculty)
		{
			Faculty faculty = (Faculty) Member;
			
			ps.setString(3, "FACULTY");
			ps.setString(4, null);
			ps.setString(5, faculty.getDepartment());
		}
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public static Member getMemberById(int id) throws SQLException
	{
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			int memberId = rs.getInt("ID");
			String name = rs.getString("NAME");
			String memberType = rs.getString("MEMBER_TYPE");
			
			if(memberType.equalsIgnoreCase("STUDENT"))
			{
				String course = rs.getString("COURSE");
				Student student = new Student(memberId, name, course);
				
				rs.close();
				ps.close();
				con.close();
				
				return student;
				
			}
			else if(memberType.equalsIgnoreCase("FACULTY"))
			{
				String department = rs.getString("DEPARTMENT");
				
				Faculty faculty = new Faculty(memberId , name , department);
				
				rs.close();
				ps.close();
				con.close();
				
				return faculty;
			}
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
