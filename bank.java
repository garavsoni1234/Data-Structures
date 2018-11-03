import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author Garav Soni <gsoni1@student.gsu.edu>
 * 
 * This "bank" uses the data structure Queue to keep track of customers as they wait for tellers to assist them. It also uses Arrays to keep track of the tellers
 * This bank runs for 120 seconds with 5 tellers assisting customers. Each teller is assigned a customer and assists he or she for 2-5 seconds. A customer arrives every
 * 2-6 seconds. If the all the tellers are busy then the customer is placed into the Queue, and it is a first come first serve basis.
 * 
 * The primary data structure used in this program is a Queue. I also use an Array to store the boolean values and to store the tellers. I also used an ArrayList in the getTeller method to store the lowest value index
 * The expected input/output for  the simulation is after you wait 2 minutes, it will give you the amount of customer each teller assisted and ask if you want to run the program again! If "yes", then the simulation will start all over again. 
 * If "no", the program will terminate!
 */

public class bank implements Runnable{
	private int m=0; //keeps track of the time and makes sure the program ends in two minutes
	private int left=0;//Initialed the amount of elements left on the Queue. The amount of customers that did not get the assistance within the two minutes
	private boolean teller1=false; //teller1 set to false because when the program start the each teller is being used by a customer
	private boolean teller2=false; //teller2 set  false because when the program start the each teller is being used by a customer
	private boolean teller3=false; //teller3 set false because when the program start the each teller is being used by a customer
	private boolean teller4=false; //teller4 set false because when the program start the each teller is being used by a customer
	private boolean teller5=false; //teller5 set false because when the program start the each teller is being used by a customer
	private int a=0; //Iterates about of customers helped by teller1
	private int b=0; //Iterates about of customers helped by teller2
	private int c=0; //Iterates about of customers helped by teller3
	private int d=0; //Iterates about of customers helped by teller4
	private int e=0; //Iterates about of customers helped by teller5
	private int smallestindex=0; //Represents the index that has the smallest elements inside
	private Random rand = new Random();//Initialized the the Random class
	private int rand1; // this is the amount of time it will take the each teller to assist each customer
	private int rand2; // this is used to generate the customers coming in every 2-6 seconds that are being placed inside the Queue
	private Scanner scan = new Scanner(System.in); // Defines the scanner class that asks user for the 
	private int[] TellerArray= new int[5]; //We use and initialized the array "TellerArray" and set the length to 5
	private int counter=0; //Is a counter variable that keeps track of program is repeating
	private int lowestValue=0; //Initialized the lowest value in the array "TellerArray"
	private boolean Firstloop = true; //The "Firstloop" is set to true to give us a infinite loop until otherwise reset to false
	private int customerCounter=0; //this is a counter used to give each customer a unique name and iterates accordingly
	private int initialcounter=0; //
	private boolean[] TrackTeller = {teller1,teller2,teller3,teller4,teller5};//
	private PriorityQueue<Integer> customertrack = new PriorityQueue<>(); //PriorityQueue is another data structure we need for this program
	private boolean AlreadyIn=true; // if a customer is already in the Queue and teller becomes available, this boolean is used for this scenario
	/*
	 * The GenerateRandom method connects all the parts to this program. It generates the initial time each teller spend with the original customers and linked all other methods!
	 * Since Teller is occupied when the program first starts
	 * Pre-Condition: The overall setup and Initialization of each variable and each method the program needs to execute
	 * 
	 * Post Condition: The final out of the main logic of the program so it can calculate and simulate a bank
	 * 
	 */
	
	public void OrgCustomers() {
		for(int i=0;i<5;i++) {//Randomly iterates 5 elements to store in the array that used to time each interaction between teller and customer
			rand1 = rand.nextInt(4)+2;//Uses Random class to generate the values from 2-5 seconds
			TellerArray[i]=rand1;//updates the index for the array until index 5 is reached
			System.out.println("The total number of customers inside the Queue are " +customertrack.size());
			System.out.println("There total amount of time that has elasped is "+m+ " seconds");
		}

	}
	/**
	 * GenerateRandom method is used to move the items to the queue as the customers are coming to the bank
	 * 
	 * Pre-Condition: The both the time it will take the customer to walk in every 2-6 seconds is set and the time it takes for the teller to assist the customer is set every 2-5 seconds
	 * Post Condition: It will check to see if the there is a customer that is walking in before any teller is free and place them into the Queue or call the PlaceIntoQueue method otherwise
	 * 
	 * 
	 */
	public void GenerateRandom() {
				rand2 = rand.nextInt(5)+2; //Generates Random wait time for customer coming in
				int turelowestValue=0;
				getMin();
				if((TellerArray[smallestindex]>rand2)) {   //Condition if the generated value is that the customer is coming into the bank is less than the time the bank spends with a teller
					customertrack.add(customerCounter);
					AlreadyIn=false;
				}
				try {
				TimeUnit.SECONDS.sleep(turelowestValue);
				Helped();
				if(m==120) {
					FinalOutput();
					Work();
				}else if(m>=115) {
					int secleft=120-m;
					Helped();
					TimeUnit.SECONDS.sleep(secleft);
					FinalOutput();
					Work();
				}
				System.out.println("The total number of customers inside the Queue are " +customertrack.size());
				System.out.println("There total amount of time that has elasped is "+ m+" seconds");//Makes sure that the program runs for 120 seconds.
				m=m+turelowestValue;
				PlaceIntoQueue();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	
	/**
	 * PlaceIntoQueue is the main method that checks off conditions to verify which condition the program satisfies
	 * Pre-Condition: has all the methods that this method uses to access information and the conditions are set 
	 * 
	 * Post Condition:The method will execute each condition and keep up with the bank simulation and increment each number of customers that teller assisted 
	 * 
	 */
	public void PlaceIntoQueue() {
		try {
			if(lowestValue<rand2) { // if the wait time is greater than the lowest value that a teller assisted a customer
				int waittime=rand2-TellerArray[0];
				if(AlreadyIn==false) {
					customertrack.remove();
					int reverse = rand.nextInt();
					TellerArray[smallestindex]=reverse;
					AlreadyIn=true;
				}else {
					TimeUnit.SECONDS.sleep(waittime);
					if(m==120) {
						FinalOutput();
						Work();
					}else if(m>=115) {
						int secleft=120-m;
						Helped();
						TimeUnit.SECONDS.sleep(secleft);  //Makes sure that the program runs for only 120 seconds
						FinalOutput();
						Work();
					}
					System.out.println("The total number of customers inside the Queue are " +customertrack.size());
					System.out.println("There total amount of time that has elasped is "+ m+" seconds");
					m=waittime+m;
				}
				customerCounter++;
				customertrack.add(customerCounter);
				customertrack.remove(customerCounter);
				TellerArray[smallestindex]=rand.nextInt(4)+2;
				for(int i =0;i<TrackTeller.length;i++) {
					//For loop to get all the smallest values inside the array if the smallest element is more than one. Than it will go assign the teller a new customer
					if(TrackTeller[i]==false&&(i!=smallestindex)) {
						smallestindex=i;
						Helped();
						TellerArray[i]=rand.nextInt(4)+2;
						TrackTeller[i]=true;
					
						
					}
				}
			
				for(int i=0;i<TellerArray.length;i++) {
					TellerArray[i]=TellerArray[i]-lowestValue;	//Subtract the time that has elapsed for the elements in the array that are less than the smallest element
				}
				
				if(getMin()>rand2-lowestValue) {//If the smallest value is less than the wait time minus smallest value than 
					customerCounter++;
					customertrack.add(customerCounter);
					counter++;
					AlreadyIn=false;
					TimeUnit.SECONDS.sleep(rand2-lowestValue);
					Helped();
					if(m==120) { 
						FinalOutput();
						Work();
					}
					else if(m>=115) { //Makes sure that the program runs for only 120 seconds, so that all customers are served and the program ends in exactly 120 seconds 
						int secleft=120-m;
						Helped();
						TimeUnit.SECONDS.sleep(secleft); 
						FinalOutput();
						Work();
					}
					System.out.println("The total number of customers inside the Queue are " +customertrack.size());
					System.out.println("There total amount of time that has elasped is "+ m+" seconds");
					m=m+(rand2-lowestValue);
				
					
				}else if(getMin()<rand2-lowestValue) {//if the minimum value is less than the lowestValue subtract by the time the next customer is waiting.
					TimeUnit.SECONDS.sleep(rand2-lowestValue);//Delay is added to signal that 
					if(m==120) {
						FinalOutput();
						Work();
					}else if(m>=115) {
						int secleft=120-m;
						Helped();
						TimeUnit.SECONDS.sleep(secleft);
						FinalOutput();
						Work();
					}
					System.out.println("The total number of customers inside the Queue are " +customertrack.size());
					System.out.println("There total amount of time that has elasped is "+m+ " seconds");
					m=m+(rand2-lowestValue);
					TellerArray[smallestindex]=rand.nextInt(4)+2;
				}
				
				initialcounter++;
			}else if(lowestValue==rand2) {
				
				customerCounter++;
				customertrack.add(customerCounter);
				customertrack.remove(customerCounter);
				Helped();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Time here 2-6 seconds 
		//place into Queue
		
		}
	/**
	 * getTeller's purpose is to give the lowest interval that a teller helped a customer and links that teller with the next customer on the Queue
	 * Pre-condition: Is the declaration and initialization of all the variables used 
	 * Post Condition: The final output of the smallest time interval
	 * 
	 * 
	 * 
	 */
	public void getTeller() {
		smallestindex=0;
		ArrayList<Integer> keeptrack = new  ArrayList<>(); //ArrayList to keep track of the same lowest possible time for each teller to have helped customer and is another data structure used
		int min=TellerArray[0];
			 for (int i = 0; i < TellerArray.length; i++) {
		            if (TellerArray[i] < min) {
		                min = TellerArray[i];
		                smallestindex=i;
		            }
			 }
			 TrackTeller[smallestindex]=false;
			 lowestValue=TellerArray[smallestindex];
			 int tempsmallestindex=smallestindex;
			 while(tempsmallestindex<=4) {
				 if(tempsmallestindex>4)
				 tempsmallestindex++;
				 if(TellerArray[tempsmallestindex]==TellerArray[smallestindex]) {
					 keeptrack.add(tempsmallestindex);
				 }
				 tempsmallestindex++;
			 }
			 for(int i=0;i<keeptrack.size();i++) {
			 if(keeptrack.get(i)==0) {
				 a++;
				 TrackTeller[0]=false;
			 }else if(keeptrack.get(i)==1) {
				 b++;
				 TrackTeller[1]=false;
			 }else if(keeptrack.get(i)==2) {
				 c++;
				 TrackTeller[2]=false;
			 }else if(keeptrack.get(i)==3) {
				 d++;
				 TrackTeller[3]=false;
			 }else if(keeptrack.get(i)==4) {
				 e++;
				 TrackTeller[4]=false;
			 }
			 }
			 
	}
	/**
	 * Helped method keeps track of how many customers each teller has helped! a=teller1,b=teller2,...etc. This is a short version of getTeller method that PlaceIntoQueue can access to increment the customers per teller
	 * Pre-Condition:The method being called because teller has helped a customer
	 * Post Condition: The final value being calculated by the program to being printed out later 
	 */
	public void Helped() {
				
			 if(0==smallestindex) {
				 a++;
				 TrackTeller[0]=false;//Each boolean array is set to false once that teller assists another customer
			 }else if(1==smallestindex) {
				 b++;
				 TrackTeller[1]=false;
			 }else if(2==smallestindex) {
				 c++;
				 TrackTeller[2]=false;
			 }else if(3==smallestindex) {
				 d++;
				 TrackTeller[3]=false;
			 }else if(4==smallestindex) {
				 e++;
				 TrackTeller[4]=false;
			 }
			 
	}
	/**
	 * getMin method returns the smallest value in the array
	 * Pre-Condition: Is the array being defined to elements
	 * Post Condition: It generates the smallest integer in the list of elements
	 * 
	 * 
	 * @return the min value for the method PlaceIntoQueue which is the lowest value inside the TellerArray which is the array that stores each teller
	 */
	public int getMin() {
		int min=TellerArray[0];
		 for (int i = 0; i < TellerArray.length; i++) {
	            if (TellerArray[i] < min) {
	                min = TellerArray[i];
	                smallestindex=i;
	            }
		 }
		return min;
	}
	/**
	 * run is the primary method that connects to the main method to run the program 
	 * Pre-Condition is everything that is defined in the program
	 * Post Condition is the final output on the console
	 */
	public void run() {
		boolean go=true;
		while(go==true) {
		Time();
		if(m>=120) { //Makes sure the program ends when the teller has served its last customer around 2 minutes
			FinalOutput();
			Work();
			go=false;
			System.exit(0);
		}
		
	}
	}
	/**
	 * Time This method organizes all the method call, so that the program can run successfully 
	 * Pre-condition: All the method being defined 
	 * Post condition: The call to make each method run
	 */
	public void Time() {
			OrgCustomers();
			getTeller();
			GenerateRandom();
	}
	/**
	 * Work This method asks the user if thay want to run the program again
	 * Pre-Condition:The printout that asks the user user what they want to do 
	 * Post-condition: the program will either terminate or continue 
	 */
	public void Work() {
		System.out.println("Do you want to run the program again? Enter Yes/yes or No/no! ");
		String enter = scan.next();
		if(enter.equals("Yes")||enter.equals("yes")) {
			Clean();
			run();
		}else if(enter.equals("No")||enter.equals("no")) {
			FinalOutput();
			System.exit(0);
		}
		}
	/**
	 * The Clean method resets all the global variables to their default values
	 * Pre-Condition: The method will take in all the global variables as they stand previously 
	 * Post Condition: The method will reset the values to 0.
	 */
	
	private void Clean() {
		m=0; //keeps track of the time and makes sure the program ends in two minutes
		left=0;//Initialed the amount of elements left on the Queue. The amount of customers that did not get the assistance within the two minutes
		teller1=true; //teller1
		teller2=true; //teller2
		teller3=true; //teller3
		teller4=true; //teller4
		teller5=true; //teller5
		a=0; //Iterates about of customers helped by teller1
		b=0; //Iterates about of customers helped by teller2
		c=0; //Iterates about of customers helped by teller3
		d=0; //Iterates about of customers helped by teller4
	    e=0; //Iterates about of customers helped by teller5
		smallestindex=0; //Represents the index that has the smallest elements inside
		rand1=0; // this is the amount of time it will take the each teller to assist each customer
		rand2=0; // this is used to generate the customers coming in every 2-6 seconds that are being placed inside the Queue
		counter=0; //Is a counter variable that keeps track of program is repeating
		lowestValue=0; //Initialized the lowest value in the array "TellerArray"
		 Firstloop = true; //The "Firstloop" is set to true to give us a infinite loop until otherwise reset to false
		customerCounter=0; //this is a counter used to give each customer a unique name and iterates accordingly
		initialcounter=0; 
	    AlreadyIn=true; // if a customer is already in the Queue and teller becomes availabe, this boolean is used for this scenario
		
	}
	/**
	 * FinalOutput method gives the program the final output
	 * Pre-Condition: The Pre-Condition is the variables being defined to be calculated and examined
	 * Post Condition: The Post Condition is the examination of the variables and the final output on the console
	 */
	public void FinalOutput() {
		while(!customertrack.isEmpty()) {
			customertrack.remove();
			left++;
			
		}
		System.out.println("The total time the simulation ran was 120 seconds");
		System.out.println("The total amount of customers that visited the bank for that "+(a+b+c+d+e+left));
		System.out.println("The total amount of customers that each teller helped " );
		System.out.println("Teller1 "+a);
		System.out.println("Teller2 "+b);
		System.out.println("Teller3 "+c);
		System.out.println("Teller4 "+d);
		System.out.println("Teller5 "+e);
		System.out.println("The total amount of time that each teller was occupied." +m*4);
		System.out.println("The total amount of customers that did not get to see a teller. "+left);
	}
	/**
	 * The main Method to execute the program
	 * 
	 * @param args -arguments being passed in
	 */
	public static void main(String[] args) {
		bank bank = new bank();
		Thread t = new Thread(bank);
		t.start();
	}

}
