/*
PT Prigoda
5/1/16
Final Project
*/
import java.io.*;

public class Wishlist implements java.io.Serializable{
	private MNode[] wishlist;
	private int n;

	public Wishlist(){
		wishlist = new MNode[20];
		n = 0;
	}

	public Boolean isEmpty(){
		return n==0;
	}

//user inputs wrong nmber check at menu
	public void delete(int index){
		n--;
		for(int i = index; i < n; i++){
			wishlist[i] = wishlist[i + 1];
		}
	}

	public void insert(MNode newNode, int index){
		n++;
		if (index > n) {
			index = n;
		}
		for (int i = n; i >= index; i--){
				wishlist[i] = wishlist[i-1];
		}
		wishlist[index-1] = newNode;
	}

	public void watchMovie(){
		if (wishlist[0].checkStock()){
			System.out.println("You are now watching"+" "+wishlist[0].getTitle());
		}
		else{
			System.out.println("Movie no longer avalible.");
		}
		delete(0);
    }

    public void printMovies(){
    	for(int i = 0; i < n; i++){
    		if (wishlist[i] == null){
    			System.out.println("You have no movie in this position:"+i);

    		}
    		else{
    		System.out.println(i+ ": "+wishlist[i].getTitle() + " ID:" + wishlist[i].getCode());
    		
    		}
    	}
    }
    /*
    public static void main(String[] args){
    	CustomerNode a = new CustomerNode("ray", 1234, "ray@conncoll");
    	MNode x = new MNode("jack", 20011011, 12345, 1);
		MNode y = new MNode("jill", 20030303, 12346, 2);
		MNode z = new MNode("bob", 20100304, 12347,2);
		a.getWishlist().insert(x,7);
		a.getWishlist().insert(y,1);
		a.getWishlist().printMovies();
		System.out.println();
		a.getWishlist().insert(z,2);
		a.getWishlist().printMovies();
    }
    */
}