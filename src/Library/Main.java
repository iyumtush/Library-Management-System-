package Library;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	
	public static Member registerMember()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter Member ID : ");
		int mID = scanner.nextInt();
		scanner.nextLine();
		System.out.println("\nEnter the name :");
		String mName = scanner.nextLine();
		System.out.print("\nWho are you : 1.Student or 2.Faculty , Choose 1 or 2.");
		int selType = scanner.nextInt();
		scanner.nextLine();
		
		Member Member = null;
		
		if(selType == 1)
		{
			System.out.print("Enter course name :");
			String sCourse = scanner.nextLine();
			
			Member = new Student( mID ,  mName , sCourse);
		}else if(selType == 2)
		{
			System.out.print("Enter department name : ");
			String dName = scanner.nextLine();
			
			Member = new Faculty(mID, mName , dName);
		}
		
		try
		{
		    DatabaseConnection.addMemberToDatabase(Member);
		    System.out.println("\nRegistration successful!");
		}
		catch(SQLException e)
		{
		    e.printStackTrace();
		}
		
		return Member;
	}
	
	public static void main(String[] args) {
		
		try
		{
		    Connection con = DatabaseConnection.getConnection();
		    System.out.println("Database connected successfully!");
		    con.close();
		}
		catch(SQLException e)
		{
		    e.printStackTrace();
		}
		
			System.out.println("---Library Management System---");
		
		

		
		/*
		
		Student student = new Student(101,"Vedant","Java");
		Faculty faculty = new Faculty(102 , "Shailesh Sir", "CSE");
		
		
		Member[] type = {student , faculty};
		System.out.println("\n Library Memebers :");
		for(Member x : type)
		{
			System.out.println("\n"+x.toString()+"\n");
		}
		
		
		Library l = new Library();
		
		
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.addBook(b4);
		l.addBook(b5);
		l.addBook(b6);
		
		l.displayBook();
		l.borrowBook(student);
		l.returnBook(student);*/
	}

}
