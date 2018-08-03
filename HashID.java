import java.io.*;

public class HashID implements java.io.Serializable{
	private int n;
	private MNode []h;
	private int TableSize;

	public HashID(){
		h = new MNode [257];
		n=0;
		TableSize=257;
			}
	public int hash1(int code){ //this method  will try to find a spot in the array with mod 7
		return code%7;
	}
	public int hash2(int code){ //this method will try to find a spot in the array with mod 5
		return code%5;
	}
	public String lookUp(int code){ // this method returns a MovieNode in the hash table with a given key
		int pos1 = hash1(code);
		int pos2 = hash2(code);
		//System.out.println(h[pos1]);
	
		if (h[pos1]!=null && h[pos1].getCode() == code){
			return h[pos1].getTitle();
		}
		else if(h[pos2] != null && h[pos2].getCode() == code){
			return h[pos2].getTitle();
		}
		else{

			while (h[pos2] != null && (h[pos2].getCode() != code && n < 7)){
			pos2 = (pos2 + 1) % 7;
			n = n +1;
		}
			if (h[pos2] != null && h[pos2].getCode() == code){
				return h[pos2].getTitle();
			}
			else{
				return null;
			}
		}	
	}
	public void insert (MNode x){ //this method finds a spot in the array and inserts a MovieNode 
		int pos1 = hash1(x.getCode());
		int pos2 = hash2(x.getCode());
		if (n==7){
			System.out.println("Hash Full");
		}
		else{
			if (h[pos1] == null){
				h[pos1] = x;
			}
			else if (h[pos2] == null){
				h[pos2] = x;
			}
			else{
				while (h[pos2] != null){
					pos2 = (pos2 + 1) % 7;
				}
				
				h[pos2]=x;	
			}
			n++;
		}
	}
	public void delete(int code){ //this method deletes a specific MovieNode in the Hash Table
			int pos1 = hash1(code);
			int pos2 = hash2(code);
			if (lookUp(code) != null){
				if (h[pos1].getCode() == code){
					h[pos1] = null;
					n--;
				}
				else if(h[pos2].getCode() == code){
					h[pos2] = null;
					n--;
				}
				else{
					while (h[pos2].getCode() != code && n < 7){
					pos2 = (pos2 + 1) % 7;
					n = n +1;
					}
					if (h[pos2].getCode() == code){
			
						h[pos2] = null;
						n--;
					}
				}	
		}
	}
	public Boolean isEmptySet(){ //returns true or false depending on whether or not the Hash Table is empty 
		return h == null;
	}


	public static void main(String[] args){
	HashID a = new HashID();
	System.out.println("isEmptySet = " + a.isEmptySet());

	MNode xNode = new MNode("Jane", 20091011, 12345,48);
	MNode yNode = new MNode("Joe", 2, 12346123,2);
	MNode zNode = new MNode("Jack", 3, 12341,3);
	MNode kNode = new MNode("Jill", 4, 12342,4);
	MNode aNode = new MNode("Abe", 5, 12367,5);
	MNode bNode = new MNode("Beth", 6, 13452,6);
	MNode cNode = new MNode("Chuck", 7, 12398,7);
	MNode dNode = new MNode("Dot", 8, 23456,8);
	MNode mNode = new MNode("Mike", 9, 00123,9);
	MNode nNode = new MNode("Nick", 20, 15263,10);
	MNode oNode = new MNode("Otis", 11, 64573,11);
	a.insert(xNode);
	a.insert(yNode);
	a.insert(zNode);
	a.insert(aNode);
	a.insert(bNode);
	a.insert(cNode);

	System.out.println(a.lookUp(12345));
	System.out.println(a.lookUp(1));

	
	}
	/*

	System.out.println("lookUp");
	System.out.println(a.search(6789).getTitle());
	System.out.println(a.search(7890).getTitle());
	System.out.println(a.search(2234).getTitle());
	System.out.println(a.search(7856).getTitle());
	System.out.println(a.search(6788).getTitle());
	System.out.println(a.search(7898).getTitle());
	System.out.println("search 7890");
	System.out.println(a.search(7890).getTitle());
	System.out.println("delete6789");
	a.delete(aNode.getCode());
	System.out.println("delete7856");
	a.delete(dNode.getCode());
	System.out.println("insert2238");
	a.insert(gNode);
	System.out.println(a.search(2238).getTitle());


	System.out.println("isEmptySet = " + a.isEmpty());
   

}*/

}