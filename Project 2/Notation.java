package Package;

public class Notation {
	/** 
     * Determines the precedence of the given operator.
     *
     * @param x The operator as a string.
     * @return An integer representing the precedence of the operator.
     */
	
	public static int operations(String x) { //This is the precedence method.
		
		switch(x) {
		
		case ("+"):
			return 1 ;
		case("-"):
			return 2; 
		case("/"):
			return 3;
		case("*"):
			return 4;
		}
		return -1;
	}
	/**
     * Converts an infix expression to a postfix expression.
     *
     * @param infix1 The infix expression as a string.
     * @return The postfix expression as a string.
     * @throws InvalidNotationFormatException if the infix expression is invalid.
     */
	public static String convertInfixToPostfix(String infix1) throws InvalidNotationFormatException { 
	//	String result = ""; 
		
		MyStack1<String> mystack1 = new MyStack1<String>(); //Declare the stack
		MyQueue1<String> myqueue1 = new MyQueue1<String>(); // Declare the queue
		
		for(int i =0;i<infix1.length();i++) { //read the string
			
		if(Character.isDigit(infix1.charAt(i))) { //Check if the current character in the infix is a digit 
			
		myqueue1.enqueue(Character.toString(infix1.charAt(i)));	//copy it to the postfix solution queue
		
		}
		
		else if(infix1.charAt(i) == '(') { //Check if the current character in the infix is a left parenthesis
			mystack1.push(Character.toString(infix1.charAt(i))); //push it onto the stack 
		}
		else if((infix1.charAt(i)) == '+' || infix1.charAt(i) == '-'
				|| infix1.charAt(i) == '/' || infix1.charAt(i) == '*') { // Check the current character is an operator
			while(!mystack1.isEmpty()&&operations(mystack1.top())
					>= operations(Character.toString(infix1.charAt(i)))){ //Check the top of the stack while they have equal or higher precedence than the current operator
				mystack1.push(mystack1.pop()); //pop the operator and insert the popped one in postfix queue
			}
			
			mystack1.push(Character.toString(infix1.charAt(i))); //Push the current character in the infix onto the stack 
		}
		else if(infix1.charAt(i) == ')') { //check if the current character in the infix is a right parenthesis 
			if(mystack1.isEmpty()) { //if the stack is empty throw exception
				throw new InvalidNotationFormatException();
			}
			while(mystack1.top().charAt(0) != '(') { //while the character in the top not left parenthesis.
				if(mystack1.size() == 1 && mystack1.top().charAt(0) != '(') { //throw excpetion if the size is 1 and the character isn't left parenthesis.
					throw new InvalidNotationFormatException();
				}
				myqueue1.enqueue(mystack1.pop());//Pop operators from the top of the stack and insert them in postfix solution queue 
			}
			
			mystack1.pop(); //Since everyhting is already popped from the stack, left parenthesis will be left, so pop it.
		}
		
	}
		
		//After the expression has been ready and not empty,
		//Pop any remaining operators and insert them in postfix solution queue.
		while(!mystack1.isEmpty()) {
			myqueue1.enqueue(mystack1.pop());
		}
		return myqueue1.toString();
		
}
	/**
     * Evaluates a postfix expression.
     *
     * @param post1 The postfix expression as a string.
     * @return The result of the evaluation as a double.
     * @throws InvalidNotationFormatException if the postfix expression is invalid.
     */
	public static Double evaluatePostfixExpression (String post1) throws InvalidNotationFormatException {
		MyStack1<String> mystack1 = new MyStack1<String>(); //Declare my stack
		
		for(int i = 0; i<post1.length();i++) { //read the expression
			
			if(Character.isDigit(post1.charAt(i))) { //If the current character is an operand
				//push on the stack
				mystack1.push(Character.toString(post1.charAt(i)));
			}
			
			//Check if the current character is an operator.
			else if((post1.charAt(i)) == '+' || post1.charAt(i) == '-'
					|| post1.charAt(i) == '/' || post1.charAt(i) == '*') 
			{ 
				if(mystack1.size()<2) { //Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); //throw InvalidNotationFormatException excpetion.
				}
				else {
					
					String v01 = mystack1.pop(); //pop the first value
					String v02 = mystack1.pop(); //pop the second value
					double result1 = 0.0;//store the result of the operations
					
					/*
					Perform the arithmetic calculation of the operator-
					with the first popped value as the right operand and the second popped value as the left operand
					*/
					if(post1.charAt(i)== '+') {
						Double x = Double.parseDouble(v01);
						Double x2 = Double.parseDouble(v02);
						result1 =+ x2+x;			
					}
					
					else if(post1.charAt(i) == '-') {
						Double x = Double.parseDouble(v01);
						Double x2 = Double.parseDouble(v02);
						result1 =+ x2-x;			
					}
					else if(post1.charAt(i) == '/') {
						
						Double x = Double.parseDouble(v01);
						Double x2 = Double.parseDouble(v02);
						result1 =+ x2/x;			
					}
					else if(post1.charAt(i)=='*') {
						
						Double x = Double.parseDouble(v01);
						Double x2 = Double.parseDouble(v02);
						result1 =+ x2*x;			
					}
					
					mystack1.push(String.valueOf(result1));//Push the resulting value onto the stack
				}
		}
			
	
	}
		
		if(mystack1.size() == 1) {
			return Double.parseDouble(mystack1.pop());
		}
		else {
			throw new InvalidNotationFormatException(); //if more than one value remains, throw an error.
		}
}
	/**
     * Converts a postfix expression back to infix notation.
     *
     * @param posttoinfix1 The postfix expression as a string.
     * @return The infix expression as a string.
     * @throws InvalidNotationFormatException if the postfix expression is invalid.
     */

	public static String convertPostfixToInfix (String posttoinfix1) {
		
		MyStack1 <String> mystack1 = new MyStack1<String>(); //Declare a stack.
		
		//read the expression characters
		for(int i = 0; i< posttoinfix1.length();i++) {
			if(Character.isDigit(posttoinfix1.charAt(i))) { //If the current character is an operand,
				//push on the stack
				mystack1.push(Character.toString(posttoinfix1.charAt(i)));
			}
			//Check if the current character is an operator.
			else if((posttoinfix1.charAt(i)) == '+' || posttoinfix1.charAt(i) == '-'
					|| posttoinfix1.charAt(i) == '/' || posttoinfix1.charAt(i) == '*') 
			{
				if(mystack1.size()<2) { ////Check if the size of the stack is less than two.
					throw new InvalidNotationFormatException(); //throw InvalidNotationFormatException
				}
				else {
				String v01 = mystack1.pop();//pop the first value
				String v02 = mystack1.pop();//pop the second value
				String infix1  = "(" + v02 +posttoinfix1.charAt(i)  + v01 + ")"; //Encapsulate the resulting string within parenthesis.
				mystack1.push(infix1); //push it to the stack.
				}
			}
		}
        // Final check for a valid infix expression

		if(mystack1.size() != 1) //if more than one value remains in the stack, throw exception.
		{
			throw new InvalidNotationFormatException();

		} else { 
		String result1 = mystack1.pop();
		return result1;
	}
}
}
