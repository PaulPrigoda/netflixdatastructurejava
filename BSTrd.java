//Binary search tree
//Dylan Chase
//Due April 11

import java.io.*;

public class BSTrd implements java.io.Serializable {
	//instace variables
	private MNode root;

	private MNode s;

	private MNode f;

	private MNode p;

	private MNode t;


	
	public BSTrd(){
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
				return search2(p.getLeftb(),key);
				}
		else{
			return search2(p.getRightb(),key);
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
				return search2(root.getLeftb(),key);
				}
		else{
			return search2(root.getRightb(),key);
		}

	}
			
	//insert helper function 
	//does not return anythingMNodeMNodeMNode
	private void insert2(MNode temp,MNode p){
		if (p.getRdate()<temp.getRdate()){
			if (temp.getLeftb()==null){
				temp.setLeftb(p);
			}
			else{
				insert2(temp.getLeftb(),p);
				}
			}		
		else {
			if(temp.getRightb()==null){
				temp.setRightb(p);
			}
			else{
				insert2(temp.getRightb(),p);
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
			traverse2(root.getLeftb());
			System.out.println(root.getRdate());
			traverse2(root.getRightb());
		}
	}
	//traverse helper function 
	public void traverse2(MNode temp){
		if(temp!=null){
			traverse2(temp.getLeftb());
			System.out.println(temp.getRdate());
			traverse2(temp.getRightb());
		}
	}
	
	
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
    	MNode temp = x.getRightb();
    	//creates another temp node
    	MNode temp2 =temp;
    	while (temp2.getLeftb()!= null){
    		temp=temp2;
    		temp2=temp2.getLeftb();}
    	if (temp2!=temp){
    		temp.setLeftb(temp2.getRightb());}
    	return temp2;
    	

    }
    //method to find the parent of a given node
    //returns the parent node
    public MNode getParent(MNode t){
    	//creating node
    	MNode parent=root;
    	while(parent.getRightb()!=t && parent.getLeftb() != t){
    		if (t.getRdate()>parent.getRdate()){
    			parent=parent.getRightb();
    		}
    		else{
    			parent=parent.getLeftb();
    		
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
    			if (root.getRightb()==null && root.getLeftb()==null){
    				root=null;
    			}
    			//if right child is not null
    			//creates new root
    			else if (y.getRightb()!= null && y.getLeftb()==null){
    				root=y.getRightb();
    			}
    			//if left child is not null
    			//creates new root
    			else if (y.getRightb()== null && y.getLeftb()!=null){
    				root=y.getLeftb();
    			}
    			else{
    			//calls replacement method on node taken in
    			s=replacement(y);
    			s.setRightb(root.getRightb());
    			s.setLeftb(root.getLeftb());
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
    				if (y.getLeftb()==null && y.getRightb()==null){
    					p.setLeftb(null);}
    					//if left of parent node has a value
    				else if(y.getLeftb()!=null && y.getRightb()==null){
    					MNode f=y.getLeftb();
    					p.setLeftb(f);
    					y.setLeftb(null);
    				}//if right of parent node has a value
    				else if(y.getRightb()!=null && y.getLeftb()==null){
    					MNode f=y.getRightb();
    					//setting p left of f
    					p.setLeftb(f);
    					y.setRightb(null);}

    				else{
    					//otherwise calls replacement on y
    					MNode t=replacement(y);

    					//gets the parent of y
    					p=getParent(y);
    					if(y.getRightb()!=t){
    						t.setRightb(y.getRightb());
    					}
    					if (y.getLeftb()!=t){
    						t.setLeftb(y.getLeftb());
    					}
    					p.setLeftb(t);
    					//setting right node to null
    					y.setRightb(null);
    					//setting left node to null
    					y.setLeftb(null);
    				}
    				
    			}
    			//if both nodes are null
    			else {   
				    	if (y.getLeftb()==null && y.getRightb()==null){p.setRightb(null);}
				    	//if node on left has value
				    	else if(y.getLeftb()!=null && y.getRightb()==null){
				    		MNode f=y.getLeftb();
				    		//sets p to right of f
				    		p.setRightb(f);
				    		//sets y to null
				    		y.setLeftb(null);}
				    		//if node on right has value
				    	else if(y.getRightb()!=null && y.getLeftb()==null){
				    		//sets f to right node of y
				    		MNode f=y.getRightb();
				    		//sets p to right node of f
				    		p.setRightb(f);
				    		//moves y to null
				    		y.setRightb(null);}
				    	else{
				    		//calls replacement on y
				    		MNode t=replacement(y);
				    		//gets the parent of y
				    		p=getParent(y);

				    		if(y.getRightb()!=t){t.setRightb(y.getRightb());}
				    		if (y.getLeftb()!=t){t.setLeftb(y.getLeftb());}
				    		//sets p to right of t node
				    		p.setRightb(t);
				    		//sets to null
				    		y.setRightb(null);
				    		y.setLeftb(null);
						}
						
					}
				    		}
				    	}
				  
}
   //print tree helper function given to us
    private void printTree2(MNode tree) {
	if (tree != null) {
	    System.out.print(tree.getRdate() + " ");
            if (tree.getLeftb() != null) 
	        	System.out.print("Left: " + tree.getLeftb().getRdate() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRightb() != null)
	        System.out.println("Right: " + tree.getRightb().getRdate() + " ");
            else
                System.out.println("Right: null ");
	    	printTree2(tree.getLeftb());
	    	printTree2(tree.getRightb());}
	}

	public static void main(String[] args){
	BSTrd a = new BSTrd();
	System.out.println("isEmptyTree = " + a.isEmptyTree());
	MNode xNode = new MNode("Jane", 18800202, 1,1);
	MNode yNode = new MNode("Joe", 30001010, 2,2);
	MNode zNode = new MNode("Jack", 20120812, 3,3);
	MNode kNode = new MNode("Jill", 17001225, 4,4);
	MNode aNode = new MNode("Abe", 20150514, 5,5);
	MNode bNode = new MNode("Beth", 20041201, 6,6);
	MNode cNode = new MNode("Chuck", 20030719, 7,7);
	MNode dNode = new MNode("Dot", 20010814, 8,8);
	MNode mNode = new MNode("Mike", 20160203, 9,9);
	MNode nNode = new MNode("Nick", 19981127, 10,10);
	MNode oNode = new MNode("Otis", 19801225, 11,11);
	a.insert(xNode);
	a.insert(yNode);
	a.insert(zNode);
	a.insert(kNode);
	a.traverse();
	a.printTree();
	a.insert(mNode);
	a.insert(nNode);
	System.out.println("search");
	System.out.println(a.search(18800202).getTitle());
	System.out.println(a.search(30001010).getTitle());
	System.out.println(a.search(20120812).getTitle());
	System.out.println(a.search(17001225).getTitle());
	a.traverse();
	a.printTree();
	System.out.println("searchFor 19991129");
	System.out.println(a.search(30001010).getTitle());
	System.out.println("delete6789");
	a.delete(xNode);
	a.traverse();
	a.printTree();
	System.out.println("delete2237");
	a.delete(mNode);
	a.traverse();
	a.printTree();
	System.out.println("delete7857");
	a.delete(nNode);
	a.traverse();
	a.printTree();
	System.out.println("insert6788");
	a.insert(aNode);
	a.traverse();
	a.printTree();
	System.out.println("insert2222");
	a.insert(oNode);
	a.traverse();
	a.printTree();
	System.out.println("delete2234");
	a.delete(zNode);
	a.traverse();
	a.printTree();
	System.out.println("isEmptyTree = " + a.isEmptyTree());
    }
}
	