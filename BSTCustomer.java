/*
PT Prigoda
4/4/16
Customer BST
*/

import java.util.Scanner;

import java.io.*;

//sets up the class BST
public class BSTCustomer implements java.io.Serializable{
	private CustomerNode root;
	
	//class BST
	public BSTCustomer(){
		root = null;  //set the node to null originally
	}
	
	//checks to see if BST is empty
	public boolean isEmptyTree(){
		return root == null;   //tree is empty if the root node is null
	}
	
	//returns the node being searched for
	public CustomerNode search(int key){
		return search2(root,key);  //uses search2 function on root and the integer key
	}
		
	private CustomerNode search2(CustomerNode p,int key){
		if (p == null){
			return null;  //returns null if the node p is null
		}
		else if (key == p.getKey()){  //if the key is found
			return p;  //then return the node p, where the key was found
		}
		else if (key < p.getKey()){  //if the key of p is greater than the key 
			return search2(p.getLeft(),key);  //then search on the left
		}
		else{
			return search2(p.getRight(),key); //if the key of p is less than the key, then search
			//on the right of the tree
		}
	}
	
	//inserts a node based on the function insert2
	public void insert(CustomerNode p){
		if (root == null){
			root = p; //insert node p into the root if the tree is empty
		}
		else{ //otherwise, use the insert2 function with the nodes root and p
			insert2(root,p);
		}
	}
	
	//checks to see where to insert node
	private void insert2(CustomerNode temp, CustomerNode p){
		if (p.getKey() < temp.getKey()){ //if the temp node is greater than node p
			if (temp.getLeft() == null){
				temp.setLeft(p); //set node p to the left if it is empty/null
			}
			else { //if that is not the case
				insert2(temp.getLeft(),p); //then keep running through the insert function until
				//left is null, then insert node p
			}
		}
		else{ //if temp's right child is empty
			if (temp.getRight() == null){
				temp.setRight(p); //the nset node p to that location
			}
			else{ //if it isn't empty
				insert2(temp.getRight(),p); //then keep running through the insert2 function
				//until the right child is null, then insert node p
			}
		}
	}
	
	//prints the contents of root
	public void traverse2(CustomerNode temp){
		if (temp != null){ //if temp doesn't equal null
			traverse2(temp.getLeft()); //run the traverse on the left child
			System.out.print(temp.getKey()+" ");
			traverse2(temp.getRight()); //then run it on the right child
		}
	}
		
	//prints out contents of root
	public void traverse(){
		if (root != null){ //if node root doesn't equal null
			traverse2(root); //then traverse the root node
		}
		System.out.println(); //print the result
	}

	//prints the BST
	public void printTree() {
	printTree2(root); //prints the tree by using the printTree2 function
	System.out.println();
    }

    //prints the BST
    private void printTree2(CustomerNode tree) {
	if (tree != null) {
	    System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null) //print the left of the tree if it isn't null 
	        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null "); //if it is null, print left is null
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getKey() + " "); //print the right
	    //of the tree if it isn't null
            else
                System.out.println("Right: null "); //print right is null if it is null
	    printTree2(tree.getLeft()); //recall the printTree2 function on the left
	    printTree2(tree.getRight()); //recall the printTree2 function on the right
		}
    }
	
	//finds the parent of a node
	private CustomerNode findParent(CustomerNode d){
		CustomerNode temp = root; //set a temp node equal to node root
		while (temp.getLeft() != d && temp.getRight() != d){ //keep running until the node d is
			//either equal to the left or right child
			if (d.getKey() < temp.getKey()){ //if the temp node's key is greater than node d's key
				temp = temp.getLeft(); //then set temp equal to the left child
			}
			else{ //if it is the opposite of the previous situation
				temp = temp.getRight(); //then set temp equal to the right child
			}
		}
		return temp; //return node temp
	}
	
	//checks to see if the node has a left or right kid
	private boolean isLeft(CustomerNode p, CustomerNode c){
		//checks to see if the child is on the left
		if (p.getKey() > c.getKey()){ 
			return true; //it is left if node p's key is greater than node c's key
		}
		else { 
			return false; //returns false if the node c's key is greater than node p's key
		}
	}
	
	//checks to see what the root is, then deletes and replaces it based on the check
	private void deleteRoot(){
		if (root.getLeft() == null && root.getRight() == null){
			root = null; //root is null if nothing is there to begin with
		}
		else if (root.getLeft() == null || root.getRight() == null){ //if the left or only the right is null
			if (root.getLeft() == null){
				root = root.getRight(); //set root equal to the right side if left is null
			}
			else{
				root = root.getLeft(); //set root to the left if the right side is null
			}
		}
		else{
			CustomerNode successor = findSuccessor(root); //set node successor equal to the root's successor
			successor.setLeft(root.getLeft()); //set successor to the node root's left child
			if (root.getRight() == successor){ //if the root's right child is equal to the successor
				successor.setRight(null);  //then set successor's right child to null
			}
			else{ //but if it isn't equal to the successor node
				successor.setRight(root.getRight()); //set successor's right child to the node root's right child
			}
			root = successor; //make the node root equal to the successor
		}
	}

	//finds the successor of a node
	private CustomerNode findSuccessor(CustomerNode temp){
        CustomerNode s = temp.getRight(); //sets node s as a temp variable
        while (s.getLeft() != null){
        	s = s.getLeft(); //get the left child if it isn't null
        }
        CustomerNode parent = findParent(s); //set node parent to the parent of node s
        if (parent != temp){ //and if that doesn't equal our node temp
        	parent.setLeft(s.getRight()); //then set parent's left child to the node s's right child value
        }
        return s; //return node s

	}

	//case in which there are no kids to delete
	public void deleteNoKids(CustomerNode a){
		CustomerNode parent = findParent(a); 
		if (isLeft(parent,a) == true){ //we aren't deleting any kids
			parent.setLeft(null); //set left side to null
		}
		else{
			parent.setRight(null); //and the right child to null
		}
	}

	//case in which there is only one kid to delete
	public void deleteOneKid(CustomerNode a){
		CustomerNode parent = findParent(a);
		if (isLeft(parent,a) == true){
			if (a.getLeft() != null){ //there is a kid on the left
				parent.setLeft(a.getLeft()); //set parent's left to node a's left child
			}
			else{ //if the kid is on the right
				parent.setLeft(a.getRight()); //then set the left pointer to node a's right child value
			}
		}
		if (isLeft(parent,a) == false){ //there is a kid on the right
			if (a.getRight() != null){
				parent.setRight(a.getRight()); //set the right equal to node a's right child
			}
			else{ //or
				parent.setRight(a.getLeft()); //set the right equal to node a's left child
			}
		}
	}

	//case in which there are two kids to delete
	public void deleteTwoKid(CustomerNode a){
		CustomerNode parent = findParent(a); //find parent of a
		CustomerNode successor = findSuccessor(a); //and successor of a
		if (isLeft(parent,a) == true){ //both node parent and a have a left child
			parent.setLeft(successor); //set node parent's left child to the successor node
		}
		else{ //and in the other case
			parent.setRight(successor); //set the successor node to the right child
		}
		successor.setLeft(a.getLeft());
		if (a.getRight() != successor){ //and if a's right child doesn't equal the successor
			successor.setRight(a.getRight()); //then set the successor to node a's right value
		}
	}

	//the delete method
	public void delete(CustomerNode a) {
    	if(a.getKey() == root.getKey()) { //if key or a and root equal eachother
        	deleteRoot(); //then delete the root
    	}
        else if(a.getLeft() == null && a.getRight() == null) { //if both children are equal to null of a
        	deleteNoKids(a); //then use the delete no kids method
        }
        else if(a.getLeft() == null || a.getRight() == null) { //if there is a child on the left OR right
        	deleteOneKid(a); //then use the delete one kid method
        }
        else { //finall if there is a left and right child
        	deleteTwoKid(a); //use the delete two kids method
        }
	}
}	