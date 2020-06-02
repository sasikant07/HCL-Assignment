package com.hcl;

import java.util.Scanner;

public class TestBinaryTree {

	public static Node root = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinaryTree binaryTree = new BinaryTree();
		
		boolean exit = false;
		
		while(!exit) {
			System.out.println("\n");
			System.out.println("************************ Tree Menu *******************************");
			System.out.println("0.Exit.");
			System.out.println("1. Insert data into the tree.");
			System.out.println("2. print the breadth first order traversal of the tree");
			System.out.println("******************************************************************");
			System.out.println("\n");
			System.out.println("Enter your choice : ");
			
			switch(sc.nextInt()) {
			case 0: System.out.println("You are exited!");
					System.exit(0);
					break;
					
			case 1: System.out.println("Enter the element you want to add : ");
					int ele = sc.nextInt();
					binaryTree.insert(ele);
					System.out.println("Element "+ele+" inserted successfully!");
					break;
					
			case 2: System.out.println("The breadth first order traversal of the tree are as follows: ");
					binaryTree.breadthFirstOrder(binaryTree.root); 
			break;
			
			default : System.out.println("Enter correct choice!");
					  break;
			}
		}
		
		
		
		
		sc.close();
	}


}
