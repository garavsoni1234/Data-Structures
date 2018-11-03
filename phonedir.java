import java.util.LinkedList;
import java.util.Scanner;
public class phonedir {
	Scanner scan = new Scanner(System.in);
	LinkedList<String> FirstName = new LinkedList<>();
	LinkedList<String> LastName = new LinkedList<>();
	LinkedList<String> PhoneNumber = new LinkedList<>();
	int counter=0;
	boolean running =false;
	String FN = "";
	String LN = " ";
	String phoneNumber= " ";
	int countersize=0;
	public void showrecords() {
		if(counter!=0) {
		System.out.println();
		}
		System.out.println("a     Show all records");
		System.out.println("d     Delete the current record");
		System.out.println("f     Change the first name in the current record");
		System.out.println("l     Change the last name in the current record");
		System.out.println("n     Add a new record");
		System.out.println("p     Change the phone number in the current record");
		System.out.println("q     Quit");
		System.out.println("s     Select a record from the record list to become the current record");
		if(counter==0) {
		ExcuteConditions();
		}
		
	}
	
	public void ExcuteConditions() {
		counter++;
		while(running==false) {
		showrecords();
		String answer = scan.next();
		if(answer.equals("a")) {
			ShowAllRecords();
		}else if(answer.equals("d")) {
			DeleteTheCurrentRecord();
		}else if(answer.equals("f")) {
			ChangingTheFirstName();
		}else if(answer.equals("l")) {
			ChangingTheLastName();
		}else if(answer.equals("n")){
			AddANewRecord();
		}else if(answer.equals("p")) {
			ChangingPhoneNumber();
		}else if(answer.equals("q")) {
			Quit();
		}else if(answer.equals("s")) {
			SelectExistingRecord();
		}
		
		}
	}
	public void ShowAllRecords() {
		System.out.println("First Name   " +"LastName     "+"         Phone Number");
		System.out.println("---------   " +"-------    "+"         ---------------");
		System.out.println(FirstName.size());
		int firstounter=0;
		while(lengthisAccurate()==true) {
			System.out.println("here");
			while(firstounter<=FirstName.size()-1) {
				if(firstounter>=1) {
					System.out.println();
				}
			System.out.print(FirstName.get(firstounter));
			System.out.print("              " +LastName.get(firstounter));
			System.out.print("              " +PhoneNumber.get(firstounter));
			
			firstounter++;
			}
			firstounter=0;
		}
		/*
		for(String x:FirstName) {
			System.out.print(x+ "        ");
		}
		for(String x:LastName) {
			System.out.print(x + "           ");
		}
		for(String x:PhoneNumber) {
			System.out.print(x + "          ");
		}
		*/
	}
	public boolean lengthisAccurate() {
		countersize++;
		if((FirstName.size()>=0)&&(countersize<=FirstName.size())) {
			return true;
			
		}
		return false;
	}
	public void DeleteTheCurrentRecord() {
		FirstName.remove(FN);
		LastName.remove(LN);
		PhoneNumber.remove(phoneNumber);
		
		
	}
	public void ChangingTheFirstName() {
		FirstName.remove(FN);
		FN=scan.next();
		FirstName.add(FN);
	}
	public void ChangingTheLastName() {
		LastName.remove(LN);
		LN=scan.next();
		LastName.remove(LN);
		
	}
	public void AddANewRecord() {
		System.out.println("Enter first name ");
		FN= scan.next();
		System.out.println("Enter last name ");
		LN= scan.next();
		System.out.println("Enter phone number ");
		phoneNumber = scan.next();
		FirstName.add(FN);
		LastName.add(LN);
		PhoneNumber.add(phoneNumber);
		System.out.println("Current record is " + FN+ " "+ LN+" " +phoneNumber);
	}
	public void ChangingPhoneNumber() {
		PhoneNumber.remove(phoneNumber);
		String phoneNumber =scan.next();
		PhoneNumber.add(phoneNumber);		
	}
	public void Quit() {
		System.exit(0);
	}
	public void SelectExistingRecord() {
		
	}
	public void SearchInList() {
		
	}
	public void run() {
		ExcuteConditions();
	}
	public static void main(String[] args) {
		phonedir pd = new phonedir();
		pd.run();	
	}

}
