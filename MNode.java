import java.io.*;

public class MNode implements java.io.Serializable{
	private String title;
	private int release;
	private int code;
	private int rtScore;
	private boolean inStock;
	private MNode right;
	private MNode left;
	private MNode rightb;
	private MNode leftb;

	//instance variables of the node class
	public MNode(String title0, int release0, int code0, int rtScore0){
		title = title0;
		release = release0;
		code = code0;
		rtScore = rtScore0;
		inStock = true;
		right = null;
		left = null;
		rightb = null;
		leftb = null;
	}

	public int getRdate(){
		return release;
	}
	public String getTitle(){
		return title;
	}
	public int getRTscore(){
		return  rtScore;
	}
	public int getCode(){
		return code;
	}
	public MNode getRight(){
		return right;
	}
	public boolean checkStock(){
		return inStock;
	}
	public MNode getLeft(){
		return left;
	}
	public MNode getLeftb(){
		return leftb;
	}
	public MNode getRightb(){
		return rightb;
	}



	//to set the name of a node, make its name = to name0
	public void setTitle(String title0){
		title = title0;
	}
	public void setRdate(int release0){
		release = release0;
	}
	public void setRTscore(int rtScore0){
		rtScore = rtScore0;
	}
	public void setCode(int code0){
		code = code0;
	}
	public void changeStatus(boolean inStock0){
		inStock = inStock0;
	}
	public void setLeft(MNode next){
		left = next;
	}
	public void setRight(MNode next){
		right = next;
	}
	public void setRightb(MNode next){
		rightb = next;
	}
	public void setLeftb(MNode next){
		leftb = left;
	}
	/*
		public static void main(String[] args){
		MNode x = new MNode("jack", 1234, 00000, 1);
		System.out.println(x.getCode());
		System.out.println(x.getRTscore());
		System.out.println(x.getRdate());
		MNode y = new MNode("jill", 1111, 123456, 2);
		x.setRight(y);
		System.out.println(x.getRight().getTitle());
		MNode z = new MNode("bob", 1212, 123123,2);
		System.out.println(z.getTitle());
		x.setRightb(z);
		System.out.println(x.getRightb().getTitle());
	}
	*/
	
}