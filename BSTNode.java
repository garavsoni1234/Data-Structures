/**
 * The purpose of this BSTNode is to set up the structure for the Binary Tree Search for the BSTree class to use 
 * @author Garav Soni
 *
 */
public class BSTNode {
	public BSTNode left; //left Node
	public BSTNode right; //Right node
	public int data; //Data that the BinarySearchPoints to 
	/**
	 * The BSTNode constructor constructs all the of the of the nodes at each positions from left,right, and data
	 */
	public BSTNode()
	{
	this.left=left;
	this.right = right;
	this.data = data;
	}
	/**
	 * The second BSTNode constructor constructs all the of the nodes and takes in data as the parameter
	 *  
	 */
	public BSTNode(int data)
	{
	this.left = left;
	this.right = right;
	this.data = data;
	}
	/**
	 * The toString method is used to print the data as a string
	 * Pre-Condition: The toString method get the data variables
	 * Post ConditionL The toString method returns the data variable as a string
	 * 
	 */
	public String toString( ) {
	    return "" + data;
	}
	


}
