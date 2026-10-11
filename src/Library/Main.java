package Library;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
			System.out.println("---Library Management System---");
		
		Book b1 = new Book(1 ,"Java Programing" , "Tushar" , true);
		Book b2 = new Book(2 ,"C++ Programing" , "Manish" , false);
		Book b3 = new Book(3 ,"The Mahabharat" , "RishiYogi" , true);
		Book b4 = new Book(4 ,"The Ramayan" , "Acharyabhat" , true);
		Book b5 = new Book(5,"Geeta","RushiMuni",false);
		Book b6 = new Book(6,"India Constitution","Dr.BR.Ambedkar",true);
		
		
		Library l = new Library();
		
		
		l.addBook(b1);
		l.addBook(b2);
		l.addBook(b3);
		l.addBook(b4);
		l.addBook(b5);
		l.addBook(b6);
		
		l.displayBook();
		l.removeBook(2);
	
		
		Student student = new Student(101,"Vedant","Java");
		Faculty faculty = new Faculty(102 , "Shailesh Sir", "CSE");
		
		
		Member[] type = {student , faculty};
		System.out.println("\n Library Memebers :");
		for(Member x : type)
		{
			System.out.println("\n"+x.toString()+"\n");
		}
		
		
	}

}
