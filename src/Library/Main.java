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
		int mId = scanner.nextInt();
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
			
			Member = new Student( mId ,  mName , sCourse);
		}else if(selType == 2)
		{
			System.out.print("Enter department name : ");
			String dName = scanner.nextLine();
			
			Member = new Faculty(mId, mName , dName);
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
	
	public static  Member loginMember()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter member id : ");
		int mId = scanner.nextInt();
		
		try
		{
			Member Member = DatabaseConnection.getMemberById(mId);
			if(Member != null)
			{
				System.out.println("\nLogin Successfull !!!");
				System.out.println("Welcome, " +Member.getName());
				
				return Member;
			}
			else
			{
				System.out.println("\nMember not found.");
			}
		}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		return null;
			
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
		
		int choice;
		
		Member Member = null;
	do
	{
			
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n================================");
		System.out.println("   LIBRARY MANAGEMENT SYSTEM");
		System.out.println("================================");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");

		System.out.print("\nEnter your choice: ");
		choice = scanner.nextInt();
		
		
		switch(choice)
		{
		case 1 : 
			Member = loginMember();
			break;
		
		case 2 :
			Member = registerMember();
			break;
			
		case 3 : 
			System.out.println("\nThank you for using the Library Management System");
			break;
		} 
		
	}while(choice != 3);
		
		              
	public static void libraryDashboard(Member Member)
	{
		int choice;
		do
		{
			System.out.println();
		}
	}
		

		
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
