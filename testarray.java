import java.util.Random;
/*
 * The testarray class is used to test the ArrayList class 
 * It implements the main method to test the java code
 */
public class testarray {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(7.0);
		list.add("Cat");
		list.add("Dog");
		list.add(99);
		list.add(10);
		list.add(10);
		list.add(10);
		list.add("Garav");
		list.add("Okay", 4);
		System.out.println("Size Mehtod "  + list.size());
		System.out.println("Get " + list.get(2));
		System.out.println(" Is it empty?? " +list.isEmpty());
		System.out.println("is in method "+ list.isIn(99));
		System.out.println("Find "+list.find("Cat"));
		//This is generic using mutiple data types
		System.out.println(list.ArrayPrintOut());
	
		
		
		
		Random r = new Random();//Uses the Random class to create an object
		int generateRandom = r.nextInt(25)+1;//Sets the random numbers between 1-25 as indicated on the assignment worksheet
		ArrayList TestNoParm = new ArrayList();//Created a new ArrayList Object that takes in no parm
		System.out.println("Elements initilly set to 10 ");
		for(int i =0;i<=15;i++) {
			int rand1 = r.nextInt(25)+1;
			TestNoParm.add(rand1);
		}//for loop to store all the elements accordingly
		System.out.println("Official Printout of the first constructor with no parm "+TestNoParm.ArrayPrintOut());
		ArrayList TestWithParam = new ArrayList(15);//Users sets the elements of the Array to 15 in the contructor
		System.out.println("Inserting the amount of elements by user ");
		for(int i =0;i<=15;i++) {
			int rand1 = r.nextInt(25)+1;
			TestWithParam.add(rand1);
		}//for loop to store all the elements accordingly
		System.out.println("Official Printout of the second contructor with one parm " +TestWithParam.ArrayPrintOut());
	
		TestNoParm.remove(3);
		
	
		
		
		
		
	}

}
