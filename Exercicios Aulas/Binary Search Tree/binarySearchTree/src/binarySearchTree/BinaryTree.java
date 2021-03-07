package binarySearchTree;

public class BinaryTree{
		
		Node root;
		
		public void addNode(int key, String name) {
			
			
			// Create a new Node and i
			Node newNode = new Node(key,name);
			
			// If there is no root this node becomes the root
			if(root == null) {
				root = newNode; 	
			} else {
				
				// Set root as the Node we will start
				// with as we traverse the tree
				Node focusNode = root;
				
				// Future parent for our new Node
				Node parent;
				
				while(true) {
					
					// root is the top parent so we start there
					
					parent = focusNode; 
					
					// Check if the new node should go on
					// the left side of the parent node
					if(key < focusNode.Key) {
						
						// Switch focus to the left child						
						focusNode = focusNode.leftChild;  
						
						// If the focus node has no children
						if(focusNode == null) {
							
							// then place a new one on the left of it
							parent.leftChild = newNode;  
							return; //all done
						}
						
					} else { //if we get here put the node on the right
						
						focusNode = focusNode.rightChild;
						
						//if the right child has no children
						
						if(focusNode == null) {
							
							// then place a new one on the right of it
							parent.rightChild = newNode;
							return; //all done
						}
					}
				}
			}
		}
	
	//In Order Travesal
	// -> Aim for the smallest value first
	//  -> Starts at the 1st Left Child
	// -> When null is reached then move up in value
	public void inOrderTraverseTree(Node focusNode) {
		
		if(focusNode != null) { //check if theres something in the node
			
			// Traver the left node
			inOrderTraverseTree(focusNode.leftChild);
			
			// Visit the currently focused on node
			System.out.println(focusNode);
			
			// Traverse the right node
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// Pre Order Travesal
	// -> First see the root
	//   -> Then cicle all the left children
	//    -> Then jump to the right nodes
	public void preorderTraverseTree(Node focusNode) {

			if (focusNode != null) {

			  System.out.println(focusNode);

			  preorderTraverseTree(focusNode.leftChild);

			  preorderTraverseTree(focusNode.rightChild);

			}
	}
	
	public void postOrderTraverseTreeNode(Node focusNode) {
		
		if(focusNode != null) {
			
			postOrderTraverseTreeNode(focusNode.leftChild);
			postOrderTraverseTreeNode(focusNode.rightChild);
			
			System.out.println(focusNode);
			 
		}
	}
	
	public Node findNode(int key) {
		
		// Start at the top of the tree
		Node focusNode = root;
		
		// While we haven found the Node, we keep looking in the tree
		while(focusNode.Key != key) {
			
			// If we should search to the left
			if(key < focusNode.Key) {
				
				// Shift the focus Node to the left child
				focusNode = focusNode.leftChild;
				
			} else {
				
				// Shift the focus Node to the right child
				focusNode = focusNode.rightChild;
			}
			
			// The node wasn't found, return null
			if(focusNode == null) {
				return null;
			}
		}
		
		return focusNode;
	}

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.addNode(50, "Boss");
		tree.addNode(25, "Vice Pres");
		tree.addNode(15, "Office Manager");
		tree.addNode(30, "Secretary");
		tree.addNode(75, "Sales Manager");
		tree.addNode(85, "Salesman 1");
		
		System.out.println("-- IN ORDER TRAVERSE TREE --");
		tree.inOrderTraverseTree(tree.root);
		System.out.println("\n-- PRE ORDER TRAVERSE TREE --");
		tree.preorderTraverseTree(tree.root);
		System.out.println("\n-- POST ORDER TRAVERSE TREE --");
		tree.postOrderTraverseTreeNode(tree.root);
		
		System.out.println("\nSearch for 30");
		
		if(tree.findNode(30) == null) {  // when we dont have that value in the tree
			System.out.println("Not found in the tree");  
		} else {
			System.out.println("Found: " + tree.findNode(30));  //will show the name of the node with the value 30
		}

	}
	
}


// each node of the root attributes
class Node {
	int Key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name){
		this.Key = key;
		this.name = name;
	}
	
	public String toString() {
		return name + " has a key " + Key;
	}
}
