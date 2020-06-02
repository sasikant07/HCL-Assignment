package com.hcl;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	// Insert the elements into the tree
	public void insert(int ele) {
		Node t = new Node();
		t.setLeft(null);
		t.setData(ele);
		t.setRight(null);
		
		if(root == null) {
			root = t;
		} else {
			Node current = root;
			
			while(current != null) {
				if(ele == current.getData()) {
					System.out.println("Duplicate values.");
				}
				
				if(ele < current.getData()) {
					if(current.getLeft() == null) {
						current.setLeft(t);
						return;
					} else {
						current = current.getLeft();
					}
				} else {
					if(current.getRight() == null) {
						current.setRight(t);
						return;
					} else {
						current = current.getRight();
					}
				}
			}
		}
	}
	
	// Print the breadth first order traversal of this tree.
	public void breadthFirstOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();    //Take a Empty Queue.
		if (root == null)
			return;						// If only root then return nothing.
		
		q.add(root);
		
		while (!q.isEmpty()) {           // Extract the node from the Queue and insert all its children into the Queue.
			Node temp = (Node) q.remove();
			System.out.print(" " + temp.getData());     //Get the extracted data.
			
			if (temp.getLeft() != null)
				q.add(temp.getLeft());
			
			if (temp.getRight() != null)
				q.add(temp.getRight());
		}
	}
}
