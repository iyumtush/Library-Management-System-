package Library;

public class Main {

	public static void main(String[] args) {
		
			System.out.println("---Library Management System---");
		
		Book b1 = new Book(1 ,"Java Programing" , "Tushar" , true);
		Book b2 = new Book(2 ,"C++ Programing" , "Manish" , false);
		
		b1.setId(4);
		b1.setAvailable(false);
		b2.setTitle("Noob to Pro");
		System.out.println("\n"+b1.toString()+"\n");
		System.out.println(b2.toString()+"\n");
		
		b1.setAvailable(true);
		b1.borrowing();
		
		Book[] books = {b1, b2};
		
		Library l = new Library(books);
		
		l.searchBook(2);
		
		l.searchBook("noob to pro");
		
		Student student = new Student(101,"Vedant","Java");
		Faculty faculty = new Faculty(102 , "Shailesh Sir", "CSE");
		
		
		Member[] type = {student , faculty};
		
		for(Member x : type)
		{
			System.out.println(x.toString()+"\n");
			System.out.println(x.getBorrowLimit()+"\n");
		}
		
		
	}

}
