import java.util.LinkedList;
import java.util.Random;
/*
 * Author: Garav Soni <gsoni1@student.gsu.edu>
 * BSTree is a class that implements the Binary Tree Structure. 
 * The purpose of this class is to develop algorithms to create a linked list based Binary Search Tree
 * 
 * This is the main class that implements the Binary Search Tree
 * The data structure used is LinkedList and this class uses the Random in the main method
 * The program is ran by generating 99 random numbers and then the numbers are placed in the Binary Search Tree in order from the root the largest element 
 *
 */
public class BSTree
{
static BSTNode root;//We use the root of BSTNode to set 
int counter=0;// counter value is set to zero and defined globally to be used to set the root of the list 

/**
 * This the an empty constructor for no parameters 
 */
public BSTree()
{
this.root = root;
}
/**
 * This is another constructor for BSTree that takes in one integer parameter 
 * @param n for an integer input 
 */
public BSTree(int n)
{
this.root = new BSTNode(n);
}
/**
 * The insert method is used to input all the values into the BSTree
 * Pre-condition: This method makes sure that the placement method is defined to be used with the root and the location
 * Post condition: This method inserts the respective element into the Binary Search Tree
 * @param node
 */

public void insert(int i)
{
root = placement(root,i);
}
/**
 * Placement method inserts the element in the correct order and it does this recursively
 * @param node The node at the current position
 * @param data The data that it is processing
 * @return node that is being placed at the given position
 */
public BSTNode placement(BSTNode node, int data)
{
if(node == null)
return new BSTNode(data);
if(node.data <= data) { //if the data is greater than the current data on the position then place at the right node
node.right = placement(node.right, data);
}else if (node.data >= data) {
node.left = placement(node.left, data);
}
return node;
}
/**
 * The Check method sets the root and recursively calls itself 
 * Pre-Condition:  All the variables must be defined and the BSTNode class must exist for this method to execute successfully
 * Post Condition: The list must in order 
 * 
 * @param node That is being placed at the given position
 */
public void Check(BSTNode node)
{
if(counter==0) {
BSTNode node1 =root;
node = node1;
}
if(node==null)
return;
counter++;
Check(node.left);
counter++;
System.out.print(node.data+" -> ");
Check(node.right);
counter++;
}

public static void main(String[] args) {
	Random r= new Random(); //Creating Random object to generate Random numbers
	LinkedList<Integer> list = new LinkedList<>();// Using the LinkedList data structure to test the BinaryTreeSearch
	for(int i=0;i<100;i++) //Generates 100 random numbers from 1-99
	list.add(r.nextInt(99)); //Adding the random numbers from 1-99 to the list 
	System.out.println("Random elements are "); // Printing out the elements in any order
	System.out.print(list+" "); 
	System.out.println();
	BSTree b = new BSTree(list.get(0)); //Creating an object out of the 
	for(int i=1;i<100;i++) {
	b.insert(list.get(i));
	}
	System.out.println("Ordered Tree :");
	BSTNode node1 = root;
	b.Check(node1);//Printing out the numbers in order
}
}
