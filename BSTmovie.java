//Binary search tree
//Dylan Chase
//Due April 11
import java.io.*;

public class BSTmovie implements java.io.Serializable{
	//instace variables
	private MNode root;

	private MNode s;

	private MNode f;

	private MNode p;

	private MNode t;


	
	public BSTmovie(){
		root=null;
	}
	//returns true if tree is empty
	public Boolean isEmptyTree(){
		return root==null;
		
	}
	//search helper function 
	//takes in parameters 

	public MNode search2(MNode p,int key){
		if (p==null){
			return null;
		}
		else if(key==p.getRdate()){
				return p;
				}
		else if (key<p.getRdate()){
				return search2(p.getLeft(),key);
				}
		else{
			return search2(p.getRight(),key);
		}
	}
	//searches for node by key
	//calls search helper functon
	public MNode search(int key){
			if (root==null){
			return null;
		}
		else if( key==root.getRdate()){
				return root;
				}
		else if (key<root.getRdate()){
				return search2(root.getLeft(),key);
				}
		else{
			return search2(root.getRight(),key);
		}

	}
			
	//insert helper function 
	//does not return anything
	private void insert2(MNode temp,MNode p){
		if (p.getRdate()<temp.getRdate()){
			if (temp.getLeft()==null){
				temp.setLeft(p);
			}
			else{
				insert2(temp.getLeft(),p);
				}
			}		
		else {
			if(temp.getRight()==null){
				temp.setRight(p);
			}
			else{
				insert2(temp.getRight(),p);
		}
		}
	}
	//inserts node in proper location
	public void insert(MNode p){
		if(root==null){
			root=p;
		}
		else{
			insert2(root,p);
		}
	}
	//prints the contents of the tree in order
	public void traverse(){
		if (root!=null){
			traverse2(root.getLeft());
			System.out.println("Title:"+root.getTitle()+"Release Date:"+root.getRdate()+" "+" ID:"+root.getCode());
			traverse2(root.getRight());
		}
	}
	//traverse helper function 
	public void traverse2(MNode temp){
		if(temp!=null){
			traverse2(temp.getLeft());
			System.out.println("Title:"+temp.getTitle()+" Release Date:"+temp.getRdate()+" "+" ID:"+root.getCode());
			traverse2(temp.getRight());
		}
	}/*
	public void traverse3(){
		if (root!=null){
			traverse4(root.getLeft());
			System.out.println(root.getCode()+" "+root.getTitle());
			traverse4(root.getRight());
		}
	}
	//traverse helper function 
	public void traverse4(MNode temp){
		if(temp!=null){
			traverse4(temp.getLeft());
			System.out.println(temp.getCode()+" "+temp.getTitle());
			traverse4(temp.getRight());
		}
	}
	*/
	
	
	//print function given to us
    public void printTree() {
	printTree2(root);
	System.out.println();
    }

    //my successor function
    //takes in node
    //will return node
    public MNode replacement(MNode x){
    	//creates temp node, and gets the node to the right of x
    	MNode temp = x.getRight();
    	//creates another temp node
    	MNode temp2 =temp;
    	while (temp2.getLeft()!= null){
    		temp=temp2;
    		temp2=temp2.getLeft();}
    	if (temp2!=temp){
    		temp.setLeft(temp2.getRight());}
    	return temp2;
    	

    }
    //method to find the parent of a given node
    //returns the parent node
    public MNode getParent(MNode t){
    	//creating node
    	MNode parent=root;
    	while(parent.getRight()!=t && parent.getLeft() != t){
    		if (t.getRdate()>parent.getRdate()){
    			parent=parent.getRight();
    		}
    		else{
    			parent=parent.getLeft();
    		
    		}
    	}
    	return parent;
    }

    //removes node from tree
    //re-orders the tree if needed
    public void delete(MNode y){
   		
    	if (root != null){
  			//if node taken in is the root
    		if (y==root){
    			//root is null if both childern are null
    			if (root.getRight()==null && root.getLeft()==null){
    				root=null;
    			}
    			//if right child is not null
    			//creates new root
    			else if (y.getRight()!= null && y.getLeft()==null){
    				root=y.getRight();
    			}
    			//if left child is not null
    			//creates new root
    			else if (y.getRight()== null && y.getLeft()!=null){
    				root=y.getLeft();
    			}
    			else{
    			//calls replacement method on node taken in
    			s=replacement(y);
    			s.setRight(root.getRight());
    			s.setLeft(root.getLeft());
    			//the root is now s
    			root=s;
    			}
    		}

    		else{
    			//calls get parent method
    			MNode p=getParent(y);
    			//if node taken in key is less than parent key
    			if(y.getRdate()<p.getRdate()){
    				//if both nodes are null
    				if (y.getLeft()==null && y.getRight()==null){
    					p.setLeft(null);}
    					//if left of parent node has a value
    				else if(y.getLeft()!=null && y.getRight()==null){
    					MNode f=y.getLeft();
    					p.setLeft(f);
    					y.setLeft(null);
    				}//if right of parent node has a value
    				else if(y.getRight()!=null && y.getLeft()==null){
    					MNode f=y.getRight();
    					//setting p left of f
    					p.setLeft(f);
    					y.setRight(null);}

    				else{
    					//otherwise calls replacement on y
    					MNode t=replacement(y);

    					//gets the parent of y
    					p=getParent(y);
    					if(y.getRight()!=t){
    						t.setRight(y.getRight());
    					}
    					if (y.getLeft()!=t){
    						t.setLeft(y.getLeft());
    					}
    					p.setLeft(t);
    					//setting right node to null
    					y.setRight(null);
    					//setting left node to null
    					y.setLeft(null);
    				}
    				
    			}
    			//if both nodes are null
    			else {   
				    	if (y.getLeft()==null && y.getRight()==null){p.setRight(null);}
				    	//if node on left has value
				    	else if(y.getLeft()!=null && y.getRight()==null){
				    		MNode f=y.getLeft();
				    		//sets p to right of f
				    		p.setRight(f);
				    		//sets y to null
				    		y.setLeft(null);}
				    		//if node on right has value
				    	else if(y.getRight()!=null && y.getLeft()==null){
				    		//sets f to right node of y
				    		MNode f=y.getRight();
				    		//sets p to right node of f
				    		p.setRight(f);
				    		//moves y to null
				    		y.setRight(null);}
				    	else{
				    		//calls replacement on y
				    		MNode t=replacement(y);
				    		//gets the parent of y
				    		p=getParent(y);

				    		if(y.getRight()!=t){t.setRight(y.getRight());}
				    		if (y.getLeft()!=t){t.setLeft(y.getLeft());}
				    		//sets p to right of t node
				    		p.setRight(t);
				    		//sets to null
				    		y.setRight(null);
				    		y.setLeft(null);
						}
						
					}
				    		}
				    	}
				  
}
   //print tree helper function given to us
    private void printTree2(MNode tree) {
	if (tree != null) {
	    System.out.print(tree.getRdate() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getRdate() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getRdate() + " ");
            else
                System.out.println("Right: null ");
	    	printTree2(tree.getLeft());
	    	printTree2(tree.getRight());}
	}
	public static void main(String[] args){
	BSTmovie a = new BSTmovie();
	System.out.println("isEmptyTree = " + a.isEmptyTree());
	MNode xNode = new MNode("Jane", 1, 1,1);
	MNode yNode = new MNode("Joe", 2, 2,2);
	MNode zNode = new MNode("Jack", 3, 3,3);
	MNode kNode = new MNode("Jill", 4, 4,4);
	MNode aNode = new MNode("Abe", 5, 5,5);
	MNode bNode = new MNode("Beth", 6, 6,6);
	MNode cNode = new MNode("Chuck", 7, 7,7);
	MNode dNode = new MNode("Dot", 8, 8,8);
	MNode mNode = new MNode("Mike", 9, 9,9);
	MNode nNode = new MNode("Nick", 20, 10,10);
	MNode oNode = new MNode("Otis", 11, 11,11);
	a.insert(oNode);
	a.insert(yNode);
	a.insert(zNode);
	a.insert(kNode);
	a.insert(dNode);
	a.insert(xNode);
	a.traverse();
	a.printTree();
    }
}