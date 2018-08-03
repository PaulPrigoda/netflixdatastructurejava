//heap of movies that are ordered by their 
//rotten tomato score


public class MovieHeap implements java.io.Serializable{
	private int n; //counter
	private MNode[] s; //array of nodes
	
	public MovieHeap() {
		n = 0; //counter is zero, also the first available spot
		s = new MNode[255];//make an array of size 128
	}
	//return true if the first available spot is empty
	public boolean isEmpty() {
		return n == 0;
	}
	//return the node at index 0
	public MNode findMin() {
		//System.out.println("The movie with the worst Rotten Tomatoes score is:" + s[0].getTitle());
		return s[0];
	}
	//helper function that finds the parent of a given node, using its index
	//and the opposite of the equations 1*2+1 and 1*2+2, solving for i
	//bc only integers are returned use -1 to find the parent of both a left and right child
	private int findParent(int index) {
		int parentindex = (index - 1)/2;
		return parentindex;
	}	
	//swap two nodes using a temp to keep track of the first one
	private void swap(int c, int p) {
		MNode temp = s[c];
		s[c] = s[p];
		s[p] = temp;
	}
	//insert the node at the next available spot, and if the array is empty add one to n and youre done
	//if not check through the tree and keep switching the nodes if a child is less than its parent
	public void insert(MNode y) {
		int p = findParent(n);
		int x = n;
		s[n]=y;
		if (x > 0){

			boolean searching = true;
			while (searching && (s[x].getRTscore() < s[p].getRTscore())) {
				swap(x,p);
				x = p;
				if (x==0){
					searching = false; //break out of the while loop
				}
				p = findParent(x);
			}
		}
		n++;
	}
	//helper functions that check if a node has a child within the array(less than n)
	private boolean hasLeft(int q){
		if ((q*2 +2) <= n ){
			return true;
		}
		else{
			return false;
		}
	}
	private boolean hasRight(int q){
		if ((q*2+1) <= n){
			return true;
		}
		else {
			return false;
		}
	}
	//checks if a node has a child that is both less than n and also ordered correctly
	//meaning that its child is less than itself
	private boolean hasSmaller(int q){
		//return ((2*q+1) < n);
		
		if (2*q+1 < n && (hasRight(q) && s[q].getRTscore() > s[q*2 +1].getRTscore()) ){
			return true;
		}
		else if (2*q+2 <n && (hasLeft(q) &&s[q].getRTscore() > s[q*2+2].getRTscore())) {
			return true;
		}
		else{
			return false;
		}
		
	}
	//this method deletes the min of the array by 
	//swapping it with the last ndoe in the array then subtracting  1 from n 
	//so it is no longer within the indices included in the array
	//after switching them, we have to make sure the root is the min again
	//so move down the new root through the tree until it is in 
	//the correct spot and the smallest number is the min
	public MNode deleteMin(){
		
		int i =0;
		s[i].changeStatus(false);
		System.out.println("The movie with the worst Rotten Tomatoes score was deleted");
		System.out.println("The movie deleted was:" + s[i].getTitle());
		System.out.println("It's score was:" + s[i].getRTscore());

		swap(n-1,i);
		n--;
		while (hasSmaller(i)) {

			//if right is less than left
			if ((i*2+1)<n && (s[i*2 +1].getRTscore() < s[i*2 +2].getRTscore() || (2*i+2 ==n))) {
				//swap i with right child
				swap((i*2+1),i);
				//update i?
				i = i*2+1;
			}

			//if left child is less than right chid
			else if ((i*2+2) < n && (s[i*2 +1].getRTscore() > s[i*2 +2].getRTscore())){
				//swap i with left child
				swap((i*2+2),i);
				//upadte i?
				i = i*2+2;
			}
		
		}


		return s[n];
	}
	//print the heap by order of the array, to find the structure
	//the right and left children equations are needed
	public void printHeap(){
		for (int i=0; i < n; i++){
			System.out.println(s[i].getTitle());
			System.out.println(s[i].getRTscore());
		}
	}

	public static void main(String[] args){
	MovieHeap a = new MovieHeap();
	System.out.println("isEmpty = " + a.isEmpty());
	MNode xNode = new MNode("Jane", 123400000, 12345, 1);
	MNode yNode = new MNode("Joe", 934560000, 12346, 2);
	MNode zNode = new MNode("Jack", 223450002, 12347, 3);
	MNode kNode = new MNode("Jill", 934560003, 12348, 4);
	MNode aNode = new MNode("Abe", 123450004, 12349, 5);
	MNode bNode = new MNode("Beth", 934540005, 12350, 6);
	MNode cNode = new MNode("Chuck", 223450006, 12351, 7);
	MNode dNode = new MNode("Dot", 934560007, 12352, 8);
	MNode mode = new MNode("Mike", 723450008, 12353, 9);
	MNode nNode = new MNode("Nick", 734560009, 12354, 10);
	MNode oNode = new MNode("Otis", 734560010, 12356, 11);
	System.out.println(" ");

	a.insert(oNode);
	a.printHeap();
	System.out.println(" ");
	a.insert(nNode);
	a.printHeap();
	System.out.println(" ");

	a.insert(mode);
	a.printHeap();
	System.out.println(" ");

	a.insert(dNode);
	a.printHeap();
	System.out.println(" ");

	a.insert(cNode);
	a.printHeap();
	System.out.println(" ");
	System.out.println("Min is:" + a.findMin().getRTscore()); //check if findmin is correct
	System.out.println(" ");

	a.deleteMin();
	}
}









	