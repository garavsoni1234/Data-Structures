import java.util.Scanner;
import java.util.Stack;

public class calc {
	/* Student ID: 002202712
	 * @author Garav Soni <gsoni1@student.gsu.edu>
	 * The calc program is responsible for converting a Infix expression into a Postfix Expression. This program also checks for errors and calculates the result of user input
	 */
	
	Scanner scan = new Scanner(System.in); // Global Variable for user input
	Stack<Character> stack = new Stack<>(); // Initializing the global variable stack from the Stack class
	Stack<Integer> stack2 = new Stack<>(); // Initializing the global variable stack2 that will take care of the evaluation of the equcation
	 Stack<Character> stack3  = new Stack<Character>();
	String finalpostfix = ""; //Initializing the  global variable String "finalpostfix" that will be used for the final Post fix expression
	public char keeptrack; // declaring the global variable "keeptrack" that of the variables stored inside the parenthesis 
	String input = " "; // initializing the string "input" for the scanner as a global variable
	char Error = ' '; // Initializing variable "Error" as a global variable to examin each character
	char Evaluate = ' '; //
	/*
	 * MainExpression method is the method that is responsive for the entire program. This method converts the Infix expression into Postfix expresssion, 
	 * checks for errors, and calculates the results for the expression. This method also is responsive for taking user input.
	 * Pre-condition: The Main Expression takes in "stack", "finalpostfix", "keeptrack", "input", and "Error" variables 
	 * Post-condition: The method evaluates the entire flow of the program. From converting from Infix to Postfix to calculating based on user input. The method connects the entire methods for evaluation.
	 * 
	 */
    private void MainExpression() {
    	System.out.println("Enter infix expression: ");
        input = scan.next();
        Error();
        ScanforParenthsis();
        
       
        //Main for loop that examins the expression
        for (int i = 0; i < input.length(); i++) {
        	
            char CharEval = input.charAt(i);
           

            if (!isOperator(CharEval))
                finalpostfix = finalpostfix + CharEval;

            else if (CharEval == ')') {
            	EvaluateParathesis();
            }
            else {
                while (!stack.isEmpty() && CharEval != '(' && InOrder(stack.peek()) >= InOrder(CharEval))
                    finalpostfix = finalpostfix + stack.pop();

                stack.push(CharEval);
            }
        }
       
        // pop any remaining operator
        while (!stack.isEmpty()) {
            finalpostfix += stack.pop();
        }
        System.out.println("Converted expression: "+finalpostfix);
        EnterValue();
 
    }
    /**
     * The Error method is responsible for checking for invalid Infix expression. If the user's types in anything that is not an accurate Infix expression, they will be prompted with the error and the program will terminate 
     * Pre-Conidtion - The method takes in input String that was defined in the MainExpression method and evaluates each character of the string
     * Post Condition - If the "input" String has an error, the method will tell the user the error and the entire program will terminate. If the Infix string contains no errors, then the method will not do anything to the original flow of the program. 
     */

    public void Error() {
    	try {
    	for(int i =0;i<input.length();i++) {
    		if(input.charAt(i)=='.'){
    			System.out.println("Error in expression!! Cannot accept floating point numbers.");
    			System.exit(0);
        	}
    		Error=input.charAt(i);
    		if((input.charAt(input.length()-1)=='/'||input.charAt(input.length()-1)=='^'||input.charAt(input.length()-1)=='*'||input.charAt(input.length()-1)=='+'||input.charAt(input.length()-1)=='-')&&(input.charAt(i)=='1'||input.charAt(i)=='2'||input.charAt(i)=='3'||input.charAt(i)=='4'||input.charAt(i)=='5'||input.charAt(i)=='6'||input.charAt(i)=='7'||input.charAt(i)=='8'||input.charAt(i)=='9')&&((input.charAt(i+1)=='1'||input.charAt(i+1)=='2'||input.charAt(i+1)=='3'||input.charAt(i+1)=='4'||input.charAt(i+1)=='5'||input.charAt(i+1)=='6'||input.charAt(i+1)=='7'||input.charAt(i+1)=='8'||input.charAt(i+1)=='9'))) {
        		System.out.println("Error in expression!! No operator between operands. Also last token must be an operand.");
        		System.exit(0);	 
        	}
    		if((input.charAt(input.length()-1)=='/'||input.charAt(input.length()-1)=='^'||input.charAt(input.length()-1)=='*'||input.charAt(input.length()-1)=='+'||input.charAt(input.length()-1)=='-')){
    			System.out.println("Last token must be operand");
    			System.exit(0);
    		}
    		if(((input.charAt(i)=='(')||input.charAt(i)==')')&&((input.charAt(i+1)=='+'||input.charAt(i+1)=='/'||input.charAt(i+1)=='^'||input.charAt(i+1)=='+'||input.charAt(i+1)=='-'))) {
    			System.out.println("Error in expression!! No operator between operand and left parentheses.");
    			System.exit(0);
    		}
    		if((input.charAt(i)=='^')||((input.charAt(i)=='*'||input.charAt(i)=='/'||input.charAt(i)=='+'||input.charAt(i)=='+'||input.charAt(i)=='-') &&(input.charAt(i+1)==')'||input.charAt(i+1)=='('))) {
    			System.out.println("Error in expression!! No operator between operand and right parentheses.");
    			System.exit(0);
    		}
    		if(((input.charAt(i)=='^')||((input.charAt(i)=='*'||input.charAt(i)=='/'||input.charAt(i)=='+'||input.charAt(i)=='+'||input.charAt(i)=='-')))&&((input.charAt(i+1)=='^')||((input.charAt(i+1)=='*'||input.charAt(i+1)=='/'||input.charAt(i+1)=='+'||input.charAt(i+1)=='+'||input.charAt(i+1)=='-'))))	{
    			System.out.println("Error in expression!! The " + input.charAt(i) + " operator cannot be preceded by a " + input.charAt(i+1)+ " operator.");
    			System.exit(0);
    		}
    		}
    	}catch(IndexOutOfBoundsException e) {
    		
    	}
	}
    
    

	private boolean ScanforParenthsis() {
		char c;
	    for(int i=0; i < finalpostfix.length(); i++) {
	        c = finalpostfix.charAt(i);

	        if(c == '(')
	            stack3.push(c);
	        else if(c == '{')
	            stack3.push(c);
	        else if(c == ')')
	            if(stack3.empty())
	                return false;
	            else if(stack3.peek() == '(')
	                stack3.pop();
	            else
	                return false;
	        else if(c == '}')
	            if(stack3.empty())
	                return false;
	            else if(stack3.peek() == '{')
	                stack3.pop();
	            else
	                return false;
	    }
	    return stack3.empty();
	}
	/**
     * The EnterValue method calculated the result of the user input for x based on the Infix condition the user originally typed at the start of the program
     *  Pre-Condition: This method takes in the Postfix expressions and evaluates it. This method requires user input for the variable x
     *  Post Condition: The method then prints the result of the output.
     */

	private void EnterValue() {
		System.out.println("Enter a value for x ");
		String take=" ";
		char it =' ';
		int replaceX = scan.nextInt();
		String value1 =Integer.toString(replaceX);
		StringBuilder s1 = new StringBuilder(finalpostfix);
		for(int i =0;i<finalpostfix.length();i++) {
			 take= finalpostfix.substring(i, i+1);
			if(take.equals("x")) {
				take = value1;
				it = take.charAt(0);
				s1.setCharAt(i, it);
			}
		}
		finalpostfix=s1.toString();
		EvaluateExpression();
		}
	/**
	 * The EvaluateExpression evaluates the expression and calculates the output
	 * Pre-Condition: The condition takes in the "finalpostfix" string and evaluates the number inputed by the user with respected operator
	 * Post Condition: The final answer considering the value of x is given
	 */
	
	public void EvaluateExpression() {
		
	      for(int i=0;i<finalpostfix.length();i++)
	        {
	            char each=finalpostfix.charAt(i);
	            if(Character.isDigit(each))
	            stack2.push(each - '0');
	  
	            else
	            {
	                int n1 = stack2.pop();
	                int n2 = stack2.pop();
	                 
	                switch(each)
	                {
	                    case '+':
	                    stack2.push(n1+n2);
	                    break;
	                     
	                    case '-':
	                    stack2.push(n1-n2);
	                    break;
	                     
	                    case '/':
	                    stack2.push(n1/n2);
	                    break;
	                     
	                    case '*':
	                    stack2.push(n2*n1);
	                    break;
	              }
	            }
	        }
	        System.out.println(stack2.pop());    
	    }
		
	/**
	 * The EvaluateParathesis makes sure that each parenthesis is evaluated with high precedence and therefore a while loop tracks the total flow of the string from the start,(, to the end ,), and evaluates everything within the parenthesis
	 * Pre-Condtion: keeptrack must equal stack.pop and that must not equal the character "("
	 * Post condition: The expression is evaluated and everything that was stored in the string "keeptrack" is now added to finalpostfix
	 */
	public void EvaluateParathesis() {
	 while ((keeptrack = stack.pop()) != '(') {
         finalpostfix = finalpostfix + keeptrack;
     }
    	
    }
	/**
	 * isOperator method is responsible for returning true if the character is an operator and false if the character is not an operator
	 * Prefix: Evaluate the CharofString to verify if it is an operator or not
	 * PostFix: isOperator returns true if it is an operator and false if it is not an operator
	 * @param CharofString 
	 * @return returns true if the character is an operator and returns if the character is not an operator
	 */

	public boolean isOperator(char CharofString) {
    	switch(CharofString) {
    	case '(':
    		return true;
    	case ')':
    		return true;
    	case '^':
    		return true;
    	case '*':
    		return true;
    	case '/':
    		return true;
    	case '+':
    		return true;
    	case '-':
    		return true;
    	case '%':
    		return true;
    	default: 
    		return false;
    	
    	}

    }
	/*InOrder is a method that gives the MainExpression method the priority of the operator 
	 * Pre-condition: This precondition is the to through the Precedence in order from the switch statement. 1 means having a high precedence then 2,3,4. 1>2>3>4 
	 * Post-Condition: The method returns the precedence back to the MainExpression method, when InOrder is called.
	 */
    private int InOrder(char value) {
    	switch(value) {
    	case ('('):
    		return 1;
		case (')'):
    		return 1; 
		case ('^'):
			return 2;
		case ('*'):
			return 3;
		case ('/'):
			return 3;
		case ('%'):
			return 3;
		case ('+'):
			return 4;
		case('-'):
			return 4;
		default :
			return 0;
    	}
    }
    //Main method of the program that creates the object out of the calc class and calls the MainExpression method
    public static void main(String[] args) {
    	calc AE = new calc();
    	//AE.MainExpression();
    	AE.MainExpression();
    }
    
    
}