//class Menu

import java.util.Scanner;

import java.io.*;

public class Menu1 implements java.io.Serializable{
	private int n;

	public Menu1(){
		int n=0;

	}	

	public static void main (String[] args){

		//initiate all of the data structures
		BSTmovie idBST= new BSTmovie(); 
		BSTCustomer customerBST = new BSTCustomer();
		BSTrd rdBST= new BSTrd();
		MovieHeap heap = new MovieHeap();
		//Wishlist wishes = new Wishlist();

		//BSTmovie idBST;
		try {
	        FileInputStream fileIn = new FileInputStream("BSTMovie.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        idBST = (BSTmovie) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	//return;
    	}
     	catch(ClassNotFoundException c) {
	        System.out.println("BSTmovie class not found");
	        c.printStackTrace();
	        return;
      	}

		//BSTCustomer d = null;
		try {
	        FileInputStream fileIn = new FileInputStream("BSTCustomer.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        customerBST = (BSTCustomer) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	//return;
    	}	
     	catch(ClassNotFoundException c) {
	        System.out.println("BSTCustomer class not found");
	        c.printStackTrace();
	        return;
      	}

		//BSTrd e = null;
		try {
	        FileInputStream fileIn = new FileInputStream("BSTrd.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        rdBST = (BSTrd) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	//return;
    	}	
     	catch(ClassNotFoundException c) {
	        System.out.println("BSTrd class not found");
	        c.printStackTrace();
	        return;
      	}

		//MovieHeap f = null;
		try {
	        FileInputStream fileIn = new FileInputStream("MovieHeap.ser");
	       	ObjectInputStream in = new ObjectInputStream(fileIn);
	        heap = (MovieHeap) in.readObject();
	        in.close();
	        fileIn.close();
      	}	
      	catch(IOException i) {
        	i.printStackTrace();
        	//return;
    	}	
     	catch(ClassNotFoundException c) {
	        System.out.println("MovieHeap class not found");
	        c.printStackTrace();
	        return;
      	}

		Scanner s=new Scanner(System.in);
		String pagestatus = "initialPage";

		while (!pagestatus.equals("quit")){
			int n = -1;
			if(pagestatus.equals("initialPage"))
			{
				System.out.println("Enter 1 for Admin or 2 for Customer");		
				while(n != 1 && n != 2){
		   			n=s.nextInt();
		   			if (n != 1 && n != 2){
		   				System.out.println("You did not enter 1 or 2");
		   			}
				}
				if(n==1)
					pagestatus="admin";
				else
					pagestatus="user";
			}
		if(pagestatus.equals("admin")){
			System.out.println("This is the Admin page");
			System.out.println("1. Add Movie");
			System.out.println("2. Find movie with the worst Rotten Tomatoes rating");
			System.out.println("3. Add Customer");
			System.out.println("4. Delete Customer");
			System.out.println("5. Edit Customer");
			System.out.println("6. Search for Customer");
			System.out.println("7. Return to Main Menu");
			System.out.println("8. Quit");
			while (n>=8 ||  n<=1){
					n=s.nextInt();
					s.nextLine();
					if (n>8 ||  n<1){
						System.out.println("Incorrect Key. Please choose valid option.");
					}
					else{
						break;
					}
			}
			if (n==1)
				pagestatus = "Addmovie";
			else if(n==2)
				pagestatus = "Findworst";
			else if(n==3)
				pagestatus = "Addcust";
			else if(n==4)
				pagestatus = "Deletecust";
			else if(n==5)
				pagestatus = "Editcust";
			else if(n==6)
				pagestatus = "Searchcust";
			else if(n==7)
				pagestatus = "initialPage";
			else
				pagestatus = "quit";
		}
		else if (pagestatus.equals("user")){
			int c=0;
			System.out.println("This is the Customer page");
			System.out.println("1. Edit Account");
			System.out.println("2. Access Wishlist");
			System.out.println("3. Search Movies By Date");
			System.out.println("4. Search Movies By ID");
			System.out.println("5. Print Movies By Release Date");
			System.out.println("6. Delete Account");
			System.out.println("7. Return to Main Menu");
			n=s.nextInt();

			while (n>=7 &&  n<1){
					
					n=s.nextInt();
					
					if (n>7 &&  n<1){
						System.out.println("Incorrect Key. Please choose valid option.");
					}
					else{
						break;
					}
			}
			if (n==1)
				pagestatus = "Ea";
			else if(n==2)
				pagestatus = "Ew";
			else if(n==3)
				pagestatus = "Searchmd";
			else if(n==4)
				pagestatus = "Searchid";
			else if(n==5)
				pagestatus = "Printm";
			else if(n==6)
				pagestatus = "DA";
			else 
				pagestatus = "initialPage";


		}
		


			if (pagestatus.equals("Ea")){
				System.out.println("Enter the credit card number your account is registered under");
				int ccinput = s.nextInt();
				if(customerBST.search(ccinput)==null){
					System.out.println("You are not in our database. Press 1 to try again or any other number to go back to the customer menu");
					int ea=s.nextInt();
					if(ea==1){
						pagestatus="Ea";
					}
					else{
						pagestatus="user";
					}

				}

				else{
					System.out.println("Hello"+" "+ customerBST.search(ccinput).getName());
					System.out.println("What about yourself would you like to edit?");
					System.out.println("1. Name");
					System.out.println("2. Credit Card");
					System.out.println("3. Email address");
					System.out.println("4. Go back to user menu");
					int editInput = s.nextInt();

					if (editInput ==1){
						System.out.println("Your current account name is:"+" "+ customerBST.search(ccinput).getName());
						System.out.println("What do you want to change your name to?");
						s.nextLine();
						String newName = s.nextLine();
						customerBST.search(ccinput).setName(newName);
						System.out.println("Your name has been changed to"+" "+newName);
						System.out.println("Press 1 to edit more information or any other number return to the customer page");
						int ei1=s.nextInt();
						if(ei1==1){
							pagestatus="Ea";
						}
						else{
							pagestatus="user";
						}
					}


			}
		}

			
			else if (pagestatus.equals("Ew")){
				System.out.println("2. Acess Wishlist");
				System.out.println("Enter the credit card number your account is registered under");
				int ccinput = s.nextInt();
				System.out.println("Welcome"+" "+ customerBST.search(ccinput).getName());
				System.out.println("Here is your wishlist:");
				customerBST.search(ccinput).getWishlist().printMovies();

				System.out.println("What would you like to edit?");
				System.out.println("1. Add a movie to your wishlist");
				System.out.println("2. Watch your favorite movie");
				System.out.println("3. Delete movie");
				System.out.println("4. Go back to user menu");

				/*int WLinput=s.nextInt();
				if (WLinput==1){
					new MNode
				}*/

			}

			else if (pagestatus.equals("Searchmd")){
				System.out.println("3. Search Movies By Date");
				System.out.println("Enter the release date of the movie you want to search.");
				System.out.println("If the release date is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025");
				int dateinput = s.nextInt();
				if (rdBST.search(dateinput) == null){
					System.out.println("There is no movie in our database with that id");
					System.out.println("Enter 1 to return the customer main menu or 2 to try again");
					dateinput = s.nextInt();
					if (dateinput == 1){
						pagestatus = "user";
					}
					else{
						pagestatus="Searchmd";
					}	
				
				}

				else{
					System.out.println("That movie in our database is:" + rdBST.search(dateinput).getTitle());
					System.out.println("Its ID is:"+rdBST.search(dateinput).getCode()+ " " +"and the Rotten Tomatoes score is:"+rdBST.search(dateinput).getRTscore());
					System.out.println("Press 1 to return to the customer main menu or 2 to search again");
					int dateinput1=s.nextInt();
					if(dateinput1==1){
						pagestatus="user";
					}
					else{
						pagestatus="Searchmd";
					}

				}
			}


			else if (pagestatus.equals("Searchid")){
				System.out.println("Enter movie ID");
				int movie_ID=s.nextInt();
				if(idBST.search(movie_ID)!=null){
				System.out.println("You searched for:"+idBST.search(movie_ID).getTitle());
				System.out.println("Its release date is:"+idBST.search(movie_ID).getRdate()+" "+"and its Rotten Tomatoes score is:"+idBST.search(movie_ID).getRTscore());
			}
				else{
				System.out.println("Movie Not Found,try again");
			}
			pagestatus = "user";
			}
			else if (pagestatus.equals("Printm")){
				System.out.println("5. Printing Movies By Release Date");
				rdBST.traverse();
				pagestatus = "user";
			}
			else if (pagestatus.equals("DA")){
				System.out.println("6. Delete Account");
				System.out.println("Enter the credit card number of the account you want to delete:");
				int ccinput1 = s.nextInt();
				System.out.println("This account is registered to" + customerBST.search(ccinput1).getName());
				System.out.println("To delete their account enter 1, to enter 2 to return to the user menu");
				int deleteinput = s.nextInt();
				if (deleteinput == 1){
					customerBST.delete(customerBST.search(ccinput1));
					System.out.println("This customer is no longer registered in our database");
					pagestatus = "user";
				}
				else {
					pagestatus = "user";
				}

			}
			else if (pagestatus.equals("initialPage")){
				System.out.println("7. Returning to Main Menu");
				pagestatus = "initialPage";
			}
		
		
	
			//ADMIN SECTION


			//movies leaving database when running the program again
			if (pagestatus.equals("Addmovie")){
				System.out.println("1. Add Movie");
				System.out.println("Enter the title of the movie");
				String newtitle = s.nextLine();
				System.out.println("Enter the release date. If the release is October 25th, 2005 enter the date as:");
				System.out.println("Year, month, day: 20051025");
				int newdate = s.nextInt();
				System.out.println("Enter the rotten tomatoes score for this movie");
				int newscore = s.nextInt();
				System.out.println("Enter the 5 digit ID code");
				int newcode = s.nextInt();
				while (idBST.search(newcode) != null){
					System.out.println("there is already a movie with that code, please enter a new code");
					newcode = s.nextInt();
				}
				MNode newmovie = new MNode(newtitle, newdate, newcode, newscore);
				idBST.insert(newmovie);
				rdBST.insert(newmovie);
				heap.insert(newmovie);
				System.out.println("Your movie was successfully added to the database");
				n = 0;
				pagestatus = "admin";
				
			}
			else if (pagestatus.equals("Findworst")){
				if (heap.isEmpty() != true){
					//System.out.println("The worst movie in your data base is:"+heap.findMin().getTitle());
					//Not sure why I dont need line above this but it works without it. With it, it prints twice
					int t=heap.findMin().getRTscore();
					System.out.println("Its rotten tomatoes score is:" + t);
					System.out.println("Enter 1 to delete this movie, otherwise you will be redirected to the Admin menu");
					int decision = s.nextInt();
				    if (decision == 1){
				    	//MNode temp = heap.findMin();
						//check to make sure the data structures arent empty first
						idBST.delete(heap.findMin());
						rdBST.delete(heap.findMin());
						heap.deleteMin();
						System.out.println("The movie has been deleted");
			     		pagestatus = "admin";
					}
					else{
						pagestatus = "admin";
					}
				}


				else{
					System.out.println("There are no movies in the database");
					System.out.println("Press any number to return to the admin page");
					int no_movie=s.nextInt();
					if(no_movie >= 0){
						pagestatus="admin";
					}
			}
		}

			//Customers are gone when running program again
			//IF CC NUMBER IS TOO LONG, IT DOESNT WORK!!!
			else if (pagestatus.equals("Addcust")){
				System.out.println("3. Add Customer");
				System.out.println("Enter the name of the customer");
				String cname = s.nextLine();
				System.out.println("Enter the customer's last 4 digits of CC number");
				int ccc = s.nextInt();
				System.out.println("Enter the customer's email address");
				s.nextLine();
				String cemail = s.nextLine();
				CustomerNode cnode = new CustomerNode(cname, ccc, cemail);
				customerBST.insert(cnode);
				//Do we need to do anything with the customer's wishlist here????????????????????????
				System.out.println("                          ");
				System.out.println("Customer added to database");

				System.out.println("Enter 1 to insert another customer, enter any other number to be redirected back to the admin page");
				int decision2 = s.nextInt();
				if (decision2 ==1){
					pagestatus = "Addcust";
					s.nextLine();
				}
				else{
					pagestatus = "admin";
				}
			}
			
			else if (pagestatus.equals("Deletecust")){
				System.out.println("4. Delete Customer");
				System.out.println("Enter the credit card of the customer you would like to delete");
				int deletecc = s.nextInt();
				if (customerBST.search(deletecc) == null){
					System.out.println("there is no customer with this credit card number in our database");
					pagestatus = "admin";
				}
				else if (customerBST.isEmptyTree() == true){
					System.out.println("There are no customers in the database yet");
					System.out.println("You are being redirected to the admin main menu");
					pagestatus = "admin";
				}
				else{
					System.out.println("You deleted" + " " + customerBST.search(deletecc).getName()+" " + "from the database");
					customerBST.delete(customerBST.search(deletecc));
					System.out.println("If you want to delete another customer, press 1");
					System.out.println("If you want to return to the admin menu, press any other number");
					int z=s.nextInt();
					if(z==1){
						pagestatus="Deletecust";
					}
					else{
						pagestatus="admin";
					}
				}
				
			}
			
			else if (pagestatus.equals("Editcust")){
				System.out.println("5. Edit Customer");
				System.out.println("Enter the customer's credit card number");
				int editcc = s.nextInt();
				if (customerBST.search(editcc) == null){
					System.out.println("There is no customer under this credit card number");
					System.out.println("If you want to go back to the admin menu enter 1");
					System.out.println("If you want to search for another customer,press a different number");
					int decision5 = s.nextInt();
					if (decision5 == 1){
						pagestatus = "admin";
					}
					else{
						pagestatus.equals("Editcust");
					}
				}

				else if (customerBST.search(editcc)!= null){
					System.out.println("You are editing"+" "+ customerBST.search(editcc).getName());
					System.out.println("1. Edit their name");
					System.out.println("2. Edit their credit card number");
					System.out.println("3. Edit their email address");
					System.out.println("4. Edit another customer");
					System.out.println("5. Return to Admin menu");
					int decision4 = s.nextInt();

				    if (decision4 < 1 || decision4 > 5){
						System.out.println("Incorrect command, please enter the number corresponding to the function you wish to complete");
						System.out.println("1. Edit their name");
						System.out.println("2. Edit their credit card number");
						System.out.println("3. Edit their email address");
						System.out.println("4. Edit another customer");
						System.out.println("5. Return to Admin menu");
						decision4 = s.nextInt();
					}

					else if (decision4 == 1){
						System.out.println("Enter the new name for this customer");
						s.nextLine();
						String newname1 = s.nextLine();
						customerBST.search(editcc).setName(newname1);
						System.out.println("Name changed to" + " " + newname1);
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp=s.nextInt();
						if(temp==1){
							pagestatus="Editcust";
						}
						else{
							pagestatus="admin";
						}
					}

					else if (decision4 ==2){
						System.out.print("Enter the new credit card number for this customer");
						int newcc1 = s.nextInt();
						customerBST.search(editcc).setCredit(newcc1);
						System.out.println("Credit card changed to" + " " + newcc1);
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp1=s.nextInt();
						if(temp1==1){
							pagestatus="Editcust";
						}
						else{
							pagestatus="admin";
						}
						
					}
					else if (decision4 ==3){
						System.out.println("Enter the new email address for this customer");
						s.nextLine();
						String newemail = s.nextLine();
						customerBST.search(editcc).setMail(newemail);
						System.out.println("New email changed to"+" "+ newemail);
						System.out.println("                                   ");
						System.out.println("Press 1 to edit another customer's infromation");
						System.out.println("Press any other number to return to the admin page");
						int temp2=s.nextInt();
						if(temp2==1){
							pagestatus="Editcust";
						}
						else{
							pagestatus="admin";
						}
						
					}

					else if(decision4==4){
						pagestatus = "Editcust";
					}
					else if (decision4==5){
						pagestatus="admin";
					}
			}
		}



			//if cc is too long, doesnt work!
			else if (pagestatus.equals("Searchcust")){
				System.out.println("6. Search for Customer");
				System.out.println("Enter the last four digits of the customers credit card number:");
				int searchcc = s.nextInt();
				if (customerBST.search(searchcc) != null){
					System.out.println("The customer registered under this cc number is:"+" " +customerBST.search(searchcc).getName());
					System.out.println("Their email address is" +" "+ customerBST.search(searchcc).getMail());
					System.out.println("If you want to edit this customer's account enter 1");
					System.out.println("If you want to delete this customer enter 2");
					System.out.println("If you want to go back to the Admin page, press 3");
					int ed = s.nextInt();
					if (ed == 1){
						pagestatus = "Editcust";
					}
					else if (ed ==2){
						pagestatus = "Deletecust";
					}

					else if (ed==3){
						pagestatus = "admin";
					}
				}
				else{
					System.out.println("There is no customer in the database registered to this cc");
					System.out.println("Enter 1 to search again, otherwise  you will be redirected to the main menu");
					int decision3 = s.nextInt();
					if (decision3 == 1){
						pagestatus = "Searchcust";
					}
					else{
						pagestatus = "admin";
					}
				}
			}
		}

		try{
			FileOutputStream fileOut = 
			new FileOutputStream("BSTMovie.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(idBST);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in BSTMovie.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("BSTCustomer.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(customerBST);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in BSTCustomer.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("BSTrd.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(rdBST);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in BSTrd.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}

      	try{
			FileOutputStream fileOut = 
			new FileOutputStream("MovieHeap.ser");
			ObjectOutputStream out = 
			new ObjectOutputStream(fileOut);
			out.writeObject(heap);
			out.close();
			fileOut.close();
			System.out.println("serialized object succesfully in MovieHeap.ser");
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
}