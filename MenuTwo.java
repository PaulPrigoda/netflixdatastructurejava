import java.util.Scanner;

public class MenuTwo{
	private int n;

	public MenuTwo(){
		int n=0;
	}	

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		BSTCustomer a = new BSTCustomer();
		System.out.println("isEmptyTree = " + a.isEmptyTree());
		CustomerNode xNode = new CustomerNode("Jane", 123456789, "gbaby@gmail.com");
		System.out.println("Node 1 saved");
		CustomerNode yNode = new CustomerNode("Joe", 934567890, "honeymustard@gmail.com");
		System.out.println("Node 2 saved");
		CustomerNode zNode = new CustomerNode("Jack", 223452234, "chuckdaddy@gmail.com");
		System.out.println("Node 3 saved");
		CustomerNode kNode = new CustomerNode("Jill", 934567856, "skyguy@gmail.com");
		System.out.println("Node 4 saved");
		CustomerNode aNode = new CustomerNode("Abe", 123456788, "jimbotron@gmail.com");
		System.out.println("Node 5 saved");
		CustomerNode bNode = new CustomerNode("Beth", 934567898, "yoloswagatron@gmail.com");
		System.out.println("Node 6 saved");

		a.insert(xNode);
		a.insert(yNode);
		a.insert(zNode);
		a.insert(kNode);
		a.insert(aNode);
		a.insert(bNode);

		BSTmovie b=new BSTmovie();
		MNode movie1 = new MNode("Step Brothers", 20110616,10000, 98);
		MNode movie2 = new MNode("Up", 20090411,10001, 87);
		MNode movie3 = new MNode("Mighty Ducks", 19861008,10002, 92);
		MNode movie4 = new MNode("Doogle", 20070819,10003, 6);
		MNode movie5 = new MNode("Ping Pong Summer", 20120612,10004, 2);
		MNode movie6 = new MNode("Catch Me if You Can", 20030906,10005, 99);
		MNode movie7 = new MNode("Dylan's Feeling 22'", 20150416,10006, 22);
		MNode movie8 = new MNode("This Weekend", 20160422,10007,91);
		MNode movie9 = new MNode("Everybody Loves Ray", 20021114,10008, 63);
		MNode movie10 = new MNode("Sub-par Programmer", 20150902,10009, 43);
		b.insert(movie1);
		b.insert(movie2);
		b.insert(movie3);
		b.insert(movie4);
		b.insert(movie5);
		b.insert(movie6);
		b.insert(movie7);
		b.insert(movie8);
		b.insert(movie9);
		b.insert(movie10);

		/*int choice = 0;
		while(choice!=4){
			System.out.println("1. Edit Credit Card");
			System.out.println("2. Edit Email");
			System.out.println("3. Edit Name");
			System.out.println("4. Return to Main Menu");

			choice = s.nextInt();
			s.nextLine();
			if (choice == 1){
				System.out.println("Add new credit card number");
				int credit = s.nextInt();
				s.nextLine();
				bNode.setCredit(credit);
				System.out.println("You have changed your credit card number");
			}
			else if (choice == 2){
				System.out.println("Add a new email");
				String email = s.nextLine();
				bNode.setMail(email);
				System.out.println("You have changed your email");
			}
			else if (choice == 3){
				System.out.println("Change name");
				String name = s.nextLine();
				bNode.setName(name);
				System.out.println("You have changed your name");
			}
		}*/
		int choice = 0;
		while(choice!=5){
			System.out.println("1. Add Movie");
			System.out.println("2. Delete Movie");
			System.out.println("3. Print Movies");
			System.out.println("4. Watch Movie");
			System.out.println("5. Return to Main Menu");

			choice = s.nextInt();
			s.nextLine();
			if (choice == 1){
				System.out.println("Pick a Movie By Code");
				int code = s.nextInt();
				s.nextLine();
				MNode movie = b.search(code);
				System.out.println(movie.getTitle());
				System.out.println("What rank do you want this movie");
				int rank = s.nextInt();
				s.nextLine();
				Wishlist wishlist = bNode.getWishlist();
				wishlist.insert(movie,rank);
				System.out.println("Movie inserted");
			}
			bNode.getWishlist().printMovies();
		}
	}
}