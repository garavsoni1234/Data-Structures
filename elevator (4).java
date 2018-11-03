import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
/**
 *The class is used to define one working elevator in a building that has 12 floors	
 *@ Garav Soni  <gsoni1@student.gsu.edu>
 */
public class elevator {
	final int topride = 8;
	final int downride = 5;
	Random r = new Random();
	Scanner scan = new Scanner(System.in);
	//Global Variables used by the class
	//"topride" is set to the integer value 8 and it is also uses the final variable and makes sure the value can not be changed
	//"downride"  is set to the integer value 5 and it is also uses the final variable and it makes sure the value can not be changed
	// The Random object is created to be used in the class
	// The Scanner object is created to be used in the class
		/**
		 * Generates 8 different random numbers of elevation to go to. The Method also calls Goingdown method after it reaches 12 floor 12 and then calls either itself to restart the elevator or the program exits based on user input
		 * The precondition is topride and downride.
		 * The postcondition is the elevator going up and elevator going down
		 */
		public void Goingup() {
			ArrayList<Integer> elevatorup = new ArrayList<>();
			//elevatorup is a ArrayList that is used which is also a data structure
			int count=0;
				for(int i = 0; i<topride;i++) {
					int generateR = r.nextInt(11)+2;
					elevatorup.add(i, generateR);
				}
				//Adds 8 elements to the ArrayList dynamically
				Collections.sort(elevatorup);
				for(int i =0;i<elevatorup.size()-1;i++) {
					while(elevatorup.get(i).equals(elevatorup.get(i+1))) {
						int number = r.nextInt(11)+2;
						elevatorup.remove(i);
						elevatorup.add(i, number);
						Collections.sort(elevatorup);
						i=0;
					}
					//The while loop inside of the for loop ensures that the numbers are different so that the elevator can have 8 unique floors to stop at 
				}		
				Collections.sort(elevatorup);
				//Sorts that ArrayList in ascending order
				count=0;
				int counter=1;
				int getcounter=1;
				//count is used to display the number of seconds that have passed
				//counter is used to keep up the floors not generated in the ArrayList of five elements
				//getcounter is used to track the number of different numbers being randomly gernerated 
				for(int i =0;i<elevatorup.size()-1;) {
					if(counter==1) {
						counter++;
						System.out.println("Starting at floor 1");
					}else if(counter!=1) {
						System.out.println("Starting at floor "+elevatorup.get(i));
						i++;
					}
					while((counter!=elevatorup.get(i) )) {
						System.out.println("  Going up: now at floor "+counter);
						counter++;
					}
					if((counter==elevatorup.get(i))){
						System.out.println("  Going up: now at floor "+ elevatorup.get(i));
					}
					//the counter is used to verify that the elevator keeps up with all 12 floors, even the ones not pressed
					try {
						count++;
						System.out.print("Stopping at floor " +elevatorup.get(i)+ " for 3 seconds -> "+ +count+ ", ");
						Thread.sleep(1000);
						count++;
						System.out.print(count + ", ");
						Thread.sleep(1000);
						count++;
						Thread.sleep(1000);
						System.out.println(count);
						count=0;
						//Thread.sleep uses the value 1000 as that is the value that represents 1 second. count is reset after the third second so that it can start from 1 next time as well
						if(elevatorup.get(i)!=12&&getcounter==8) {
						while(counter!=12) {
							counter++;
							System.out.println("  Going up: now at floor "+counter);
							
						}
						}
						//the while loop inside of the if statement generates up to 12 floors if the last element in the ArrayList is not 12
						if(elevatorup.get(i)==12||counter==12) {
							Goingdown();
							int count1=1;
							String str = " ";
							//Uses a str dummy variable
							if(count1>1) {
							}
							boolean RunAgain=false;
							System.out.println("Do you want to go on the elevator again");
							str = scan.next();
							if(str.equals("N")||str.equals("n")){
								System.exit(0);
								}
							while(RunAgain==false) {
							if(str.equals("Y")||str.equals("y")) {
								Goingup();
								RunAgain=false;
							}
							}
							count1++;
							//The Program receives either a Y,y or a N,n from the user indicating whether the user wants to go up and down another time.
							//The program uses the if statement to validate whether the user put N or n first and the ends the program.
							//If the user typed in Y or y, then the program restarts by calling the Goingup method recursively 
							
						}
						//The if statement ensures that the last element is 12 for the elevators going up and then automatically call the Goingdown Method
						getcounter++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		/**
		 * Generates 5 random numbers of elevation to go down to from 12 to 2. Floor 1 is the destination of the elevator going down
		 * The Pre-condition is the variables elevatorup and elevatordown
		 * The Post condition the number of different numbers being generated
		 */
		public void Goingdown() {
			
				ArrayList<Integer> elevatordown = new ArrayList<>();
				//elevatordown is a ArrayList that is used which is also a data structure
				int count=0;
					for(int i = 0; i<downride;i++) {
						int generateR = r.nextInt(10)+2;
						elevatordown.add(i, generateR);
					}
					//ArrayList for elevator down that dynamically adds five elements to the List
					Collections.sort(elevatordown);
					for(int i =0;i<elevatordown.size()-1;i++) {
						while(elevatordown.get(i).equals(elevatordown.get(i+1))) {
							int number = r.nextInt(10)+2;
							elevatordown.remove(i);
							elevatordown.add(i, number);
							Collections.sort(elevatordown);
							i=0;
						}
					}		
					//The while loop inside of the for loop makes sure that random class generates five different elements as its condition
					Collections.sort(elevatordown);
					//sorts the ArrayList in ascending order
			
				count=0;
				int counter=12;
				//count is used to display the number of seconds that have passed
				//counter is used to keep up the floors not generated in the ArrayList of five elements
				for(int i=elevatordown.size()-1;i>0;) {
					if(counter==12) {
						counter--;
						System.out.println("Starting at floor 12");
						
					//Always starts the elevation down from floor level 12
					}else if(counter!=0) {
						System.out.println("Starting at floor "+elevatordown.get(i));
						i--;
					}
					//Represents each value from 11-1 on the elevation 
					while((counter!=elevatordown.get(i))) {
						System.out.println("  Going down: now at floor "+counter);
						counter--;
					}
					if((counter==elevatordown.get(i))){
						System.out.println("  Going down: now at floor "+ elevatordown.get(i));
						counter--;
						counter--;
					}
					//Going through the ArrayList of elements and compares those elements to the counter so the elevator can have access to each level of elevation in descending order
		
					try {
						count++;
						System.out.print("Stopping at floor " +elevatordown.get(i)+ " for 3 seconds -> "+ +count+ ", ");
						Thread.sleep(1000);
						count++;
						System.out.print(count + ", ");
						Thread.sleep(1000);
						count++;
						Thread.sleep(1000);
						System.out.println(count);
						count=0;
						counter++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
				//Thread.sleep is set to 1000 as that represent 1 second. 
				while(counter>0) {
					System.out.println("  Going down: now at floor "+counter);
					counter--;
				}
				//The while makes sure that the the elevator goes down to the 1 floor
				
		}
		/**
	 	 * This method is used to access the entire program and the method "runs" gives the program good naming convention for readability
	 	 * The Pre-Condition is everything in the Goingup method 
	 	 * The Post Condition is the output
		 */	
		public void run() {
			Goingup();
		}
		/*
		 * Main method that runs the elevator program by creating an object and then referencing it 
		 */
		public static void main(String[] args) {
			elevator mn = new elevator();
			mn.run(); 

		}
}
