package Library;

public class Main {

	public static void main(String[] args) {

		Book b1 = new Book(1 ,"Java Programing" , "Tushar" , true);
		Book b2 = new Book(2 ,"C++ Programing" , "Manish" , false);
		
		b1.setId(4);
		b1.setAvailable(false);
		b2.setTitle("Python Programming");
		
		System.out.println("---Library Management System---");
		System.out.println();
		System.out.println(b1.toString());
		System.out.println();
		System.out.println(b2.toString());
	}

}
