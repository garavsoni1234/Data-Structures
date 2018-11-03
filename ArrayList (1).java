import java.util.Arrays;

/**
 * 
 * @author Garav Soni <gsoni1@student.gsu.edu>
 * 
 * The class ArrayList is used to store any number of elements and any elements given by a client class and expand as necessary
 * <E> The class ArrayList (which a generic class) implements the List Interface (Which is also generic)
 */

public class ArrayList<E> implements List<E>{
	private int intialsize=0; //Used to compare that the array has 0 elements
	private Object[] test; //creating an array of test to store the elements
	private int n; //Is used to set the initial number of elements in the array 
	String printout = null;//Initialized to print the list 
	
	
	/* The first ArrayList constructor is used to initialize the number of elements in the Array
	 * and it is set to 10 
	 * Pre-Condition is the declaration of variable n and Array test
	 * Post Condition is the initialization of the variable and Array test
	 * 
	 */
	public ArrayList() {
		this.n=10;
		test = new Object[n];
	
	}
	/**
	 * The second ArrayList constructor is used to initialize the number of elements in the Array and
	 * it is set by the user in the "testarray" once and object is created of ArrayList
	 * Pre-Condition is the declaration of variable n and Array test
	 * Post Condition is the initialization of the variable and Array test
	 * 
	 * @param n is the number of elements that the array can store
	 */
	public ArrayList(int n) {
		this.n=n;
		test = new Object[n];
	}
	/**
	 * 
	 * The add method is used to add elements to the given array. When the array exceeds its capacity than the Array is double 
	 * and the elements from the old array is copied to the new array.
	 * Pre-Condition is the Element(Object o) that is going to be added by the test class and initialsize being 0
	 * and the elements that is assigned to the Array
	 * Post Condition is the explanation of either the list and/ or the element being added
	 * 
	 * @param o is used to insert any element and is generic object
	 * 
	 */
	public void add(Object o) {
		int counter=0;
		if(test.length>intialsize) {
			counter=0;
			test[intialsize]= o;
			printout = Arrays.toString(test);
			//final array is given with all the elements to be later used by ArrayPrintOut
			intialsize++;
			//if the array has not exceeded it capacity then this if statement is used
		}else {
		test = Arrays.copyOf(test, test.length*2);// expands the list be times 2 if the list is exceeded its capacity
		test[counter]=o;
		counter++;
		//Once the Array can store more elements it is copied and expanded
		//It uses the method copyOf from the Arrays class 
		}
	}
	/*
	 * The purpose of the ArrayPrintOut method is to keep the print out clean and to return the final Array 
	 * after it has stored all the elements
	 * Pre-Condition is that String printout is already assigned a value
	 * Post Condition is the out of the that string as printout
	 * return printout that was declared as a String global variable and then initialized in the add method
	 */
	
	public String ArrayPrintOut() {
		return printout;
	}
	/**
	 * The second add method takes in two parameters and inserts the elements to the index provided
	 * Pre-Condition - is the index that is assigned to input the Object o in 
	 * Post Condition - The actual process that has happened 
	 *  
	 *  @param o is the Object that is being inserted to the list
	 *  @param index is used to insert the element in that position
	 */
	public void add(Object o,int index) {
		test = Arrays.copyOf(test, test.length);
		test[index]=o;
		System.out.println(Arrays.toString(test));	
		
	}
	/**
	 * The class retrieves the given element at a particular index that is declared by the user in the 
	 * testarry class
	 * Pre-condtion is assigning and index by using the testarray class
	 * Post condition is the actual printout of that element in that index
	 * @param index is used to retrieve the element in that index
	 * @return returns the element at the given index 
	 */
	
	public Object get(int index) {
		Object o = test[index];
		return o;
		
	}
	/**
	 * The method size is used to get the complete list of elements
	 * Pre-Condition - Is the test array being defined with a capacity
	 * Post Condition - is the actual printout of the size by using the length method in the array class
	 * @return the size of the elements in list
	 */ 
	public int size() {
		int n = test.length;
		return n;
	}
	/**
	 * The isEmpty method is used to determine if they Array is empty or fully null
	 * Pre-condition-Is the Array being defined with elements or null
	 * Post condition - the actual determination of whether the array is fully null(empty) or not
	 * @return true if all elements are null and the Array is empty or false which indicates an element is stored
	 */
	public boolean isEmpty() {
		Object o =Arrays.asList(test);
		for(Object obj:test) 
			if(!(obj == null))
				return false;
		return true;
	}
	/**
	 * Pre-Condition- all the elements being in the array and test a particular element to see if it is in the array
	 * Post condition- The method will test to see if the element is in the array return a boolean based on that
	 * @param n takes in object n
	 * @return if the object(element) is found then true returns, if not false returns
	 */
	public boolean isIn(Object n) {
		for(int i =0;i<test.length;i++) {
			if(test[i]==n) {
				return true;
			}
		
		}
		return false;
	}
	/**
	 * The Find method returns the first occurrence of the object 
	 * Pre-Condition Defining all the elements in the array and picking an element
	 * Post Condition returns that first occurrence of that element if it is in the array, if not 0 is return indicating 
	 * element in list
	 * 
	 * @parm n is the object that is set to test
	 * @return the index of the first first occurrence  of the object, if the object does not exist, then 0 is returned
	 */
	public int find (Object n) {
		for(int i =0;i<test.length;i++) {
			if(test[i]==n) {
				return i;
			}
		}
		return 0;
	}
	/**
	 * 
	 * This method removes the according to the index that is set
	 * Pre-Condition-The user has to input the element that he/she wants to delete and the array being defined with elements
	 * 
	 * Post Condition- The element being deleted and the element the next index taking the deleted element's spot
	 * 
	 * @parm n is the index the user has declared to remove
	 */
	public void remove (Object n) {
		int length =test.length;
		if(find(n)!=0) {
		for(int i=find(n);i<length-1;i++) {
				test[i]=test[i+1];
				System.out.println(Arrays.toString(test));
			}
			System.out.println("Successfully removed !!!");
			length--;
			
		}else {
				System.out.println("Cannont remove elements !!! ");
		}
		//Method refers back to the find method and 
	}
}
