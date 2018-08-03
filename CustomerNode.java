/*
PT Prigoda
3/7/16
Assignment Zero
*/

public class CustomerNode implements java.io.Serializable{
	private String name;
	private int credit;
	private String mail;
	private CustomerNode next;
	private CustomerNode left;
	private CustomerNode right;
	private Wishlist wishlist;
	
	public CustomerNode(String name0, int credit0, String mail0){
		name = name0;
		credit = credit0;
		mail = mail0;
		wishlist = new Wishlist();
	}
	
	public int getKey(){
		return credit%10000;
	}
		
	public String getName(){
		return name;
	}
	
	public int getCredit(){
		return credit;
	}
	
	public void setNext(CustomerNode newNext){
		next = newNext;
	}
		
	public void setCredit(int credit0){
		credit = credit0;
	}
	
	public CustomerNode getNext(){
		return next;
	}
	
	public void setName(String newName){
		name = newName;
	}

	public String getMail(){
		return mail;
	}

	public void setMail(String mail0){
		mail = mail0;
	}

	public CustomerNode getRight(){
		return right;
	}
	
	public CustomerNode getLeft(){
		return left;
	}

	public void setRight(CustomerNode newRight){
		right = newRight;
	}
	
	public void setLeft(CustomerNode newLeft){
		left = newLeft;
	}

	public Wishlist getWishlist(){
		return wishlist;
	}
}