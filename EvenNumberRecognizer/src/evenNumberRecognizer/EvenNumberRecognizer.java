package evenNumberRecognizer;


public class EvenNumberRecognizer {
	/**
	 * <p> Title: FSM-translated EvenNumberRecognizer. </p>
	 * 
	 * <p> Description: A demonstration of the mechanical translation of Finite State Machine 
	 * diagram into an executable Java program using the Even Number Recognizer. The code 
	 * detailed design is based on a while loop with a select list</p>
	 * 
	 * <p> Copyright: Lynn Robert Carter © 2022 </p>
	 * 
	 * @author Lynn Robert Carter
	 * 
	 * @version 1.00		2022-02-07	Initial baseline
	 * @version 1.01		2022-03-16	Removed unneeded break statements in the switch statement
	 * @version 2.0			2022-03-18	Corrected the leading zero counting defect and the zero 
	 * 										after an odd digit defect.
	 */

	/**********************************************************************************************
	 * 
	 * Result attributes to be used for GUI applications where a detailed error message and a 
	 * pointer to the character of the error will enhance the user experience.
	 * 
	 */

	public static String evenRecognizerErrorMessage = "";		// The error message text
	public static String evenRecognizerInput = "";				// The input being processed
	public static int evenRecognizerIndexofError = -1;			// The index where the error was located
	private static int state = 0;						// The current state value
	private static int nextState = 0;					// The next state value
	private static boolean finalState = false;			// Is this state a final state?
	private static String inputLine = "";				// The input line
	private static char currentChar;					// The current character in the line
	private static int currentCharNdx;					// The index of the current character
	private static boolean running;						// The flag that specifies if the FSM is 
														// running
	private static int numericValueSize = 0;			// A numeric value may not exceed 16 characters

	/**********
	 * This private method display the input line and then on a line under it displays an up arrow
	 * at the point where an error should one be detected.  This method is designed to be used to 
	 * display the error message on the console terminal.
	 * 
	 * @param input				The input string
	 * @param currentCharNdx	The location where an error was found
	 * @return					Two lines, the entire input line followed by a line with an up arrow
	 */
	private static String displayInput(String input, int currentCharNdx) {
		// Display the entire input line
		String result = input.substring(0,currentCharNdx) + "?\n";

		return result;
	}

	/****
	 * This method displays the FSM trace to the console the same way the FSM Simulator does
	 */
	private static void displayDebuggingInfo() {
		// Display the current state of the FSM as part of an execution trace
		if (currentCharNdx >= inputLine.length())
			// display the line with the current state numbers aligned
			System.out.println(((state > 99) ? " " : (state > 9) ? "  " : "   ") + state + 
					((finalState) ? "       F   " : "           ") + "None");
		else
			System.out.println(((state > 99) ? " " : (state > 9) ? "  " : "   ") + state + 
					((finalState) ? "       F   " : "           ") + "  " + currentChar + " " + 
					((nextState > 99) ? "" : (nextState > 9) || (nextState == -1) ? "   " : "    ") + 
					nextState + "     " + numericValueSize);
	}

	/***
	 * This method simulation the input process used in the simulator
	 */
	private static void moveToNextCharacter() {
		currentCharNdx++;
		if (currentCharNdx < inputLine.length())
			currentChar = inputLine.charAt(currentCharNdx);
		else {
			currentChar = ' ';
			running = false;
		}
	}

	/**********
	 * This method is a mechanical transformation of a Finite State Machine diagram into a Java
	 * method.
	 * 
	 * @param input		The input string for the Finite State Machine
	 * @return			An output string that is empty if every things is okay or it will be
	 * 						a string with a help description of the error follow by two lines
	 * 						that shows the input line follow by a line with an up arrow at the
	 *						point where the error was found.
	 */
	public static String checkForEvenValue(String input) {
		if(input.length() <= 0) return "";
		// The following are the local variable used to perform the Finite State Machine simulation
		state = 0;							// This is the FSM state number
		inputLine = input;					// Save the reference to the input line as a global
		currentCharNdx = 0;					// The index of the current character
		currentChar = input.charAt(0);		// The current character from the above indexed position

		// The Finite State Machines continues until the end of the input is reached or at some 
		// state the current character does not match any valid transition to a next state

		evenRecognizerInput = input;			// Save a copy of the input
		running = true;						// Start the loop
		nextState = -1;						// There is no next state
		System.out.println("\nCurrent Final Input  Next  Integer Value\nState   State Char  State  Size");

		// The Finite State Machines continues until the end of the input is reached or at some 
		// state the current character does not match any valid transition to a next state
		while (running) {
			// The switch statement takes the execution to the code for the current state, where
			// that code sees whether or not the current character is valid to transition to a
			// next state
			switch (state) {
			case 0: 
				// Reset the Numeric Value size
				numericValueSize = 0;

				// State 0 has 3 valid transition that are addressed by an if statement.
				
				// The current character is must be checked against 10 options. If any are matched
				// the FSM must go to one of three states
				// 1, 3, 5, 7, 9 -> State 1
				if (currentChar == '1' || currentChar == '3' ||			// Check for odd
						currentChar == '5' || currentChar == '7' ||
						currentChar == '9') {
					nextState = 1;
					
					// Count the odd digit
					numericValueSize++;
				}
				// 0 -> State 2
				else if (currentChar == '0' || currentChar == '+' || currentChar == '-') {
					nextState = 2;
					
					// Count a leading zero, plus, or minus
					numericValueSize++;								
				}
				// 2, 4, 6, 8 -> State 3
				else if (currentChar == '2' || currentChar == '4' ||	// Check for even
						currentChar == '6' || currentChar == '8') {
					nextState = 3;
					
					// Count the even digit
					numericValueSize++;				
				}				
				// If it is none of those characters, the FSM halts
				else 
					running = false;
				
				// The execution of this state is finished
				break;
			
			case 1: 
				// State 1 has two valid transitions, an odd digit transitions back to
				// state 1, while an even transitions to state 3 

				// 1, 3, 5, 7, 9 -> State 1
				if (currentChar == '1' || currentChar == '3' ||			// Check for odd
						currentChar == '5' || currentChar == '7' ||
						currentChar == '9') {
					nextState = 1;
					
					// Count the odd digit
					numericValueSize++;
				}
				// 0, 2, 4, 6, 8 -> State 3
				else if (currentChar == '0' || currentChar == '2' ||	// Check for even
						 currentChar == '4' || currentChar == '6' ||
						 currentChar == '8') {
					nextState = 3;
					
					// Count the even digit
					numericValueSize++;

				}				
				// If it is neither even or odd, the FSM halts
				else
					running = false;
				
				// The execution of this state is finished
				break;			
				
			case 2: 
				// State 2 deals with leading zeros and has the same transitions as
				// State 0.
				
				// The current character is must be checked against 10 options. If any are matched
				// the FSM must go to one of three states
				// 1, 3, 5, 7, 9 -> State 1
				if (currentChar == '1' || currentChar == '3' ||			// Check for odd
						currentChar == '5' || currentChar == '7' ||
						currentChar == '9') {
					nextState = 1;
					
					// Count the odd digit
					numericValueSize++;

				}
				// 0 -> State 2
				else if (currentChar == '0') {
					nextState = 2;
					
					// Count leading zeroes
					numericValueSize++;								
				}
				// 2, 4, 6, 8 -> State 3
				else if (currentChar == '2' || currentChar == '4' ||	// Check for even
						currentChar == '6' || currentChar == '8') {
					nextState = 3;
					
					// Count the even digit
					numericValueSize++;
				}				

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;
	
			case 3:
				// State 3 has two valid transition.  Each is addressed by an if statement.
				
				// 1, 3, 5, 7, 9 -> State 1
				if (currentChar == '1' || currentChar == '3' ||			// Check for odd
						currentChar == '5' || currentChar == '7' ||
						currentChar == '9') {
					nextState = 1;
					
					// Count the odd digit
					numericValueSize++;
				}
				// 0, 2, 4, 6, 8 -> State 3
				else if (currentChar == '0' || currentChar == '2' ||	// Check for even
						currentChar == '4' || currentChar == '6' ||
						currentChar == '8') {
					nextState = 3;
					
					// Count the even digit
					numericValueSize++;				
				}				

				// If it is none of those characters, the FSM halts
				else 
					running = false;

				// The execution of this state is finished
				break;

			}
			
			if (running) {
				displayDebuggingInfo();
				// When the processing of a state has finished, the FSM proceeds to the next character
				// in the input and if there is one, it fetches that character and updates the 
				// currentChar.  If there is no next character the currentChar is set to a blank.
				moveToNextCharacter();
				
				// Let's ensure the address is not too long
				if (numericValueSize > 16) {
					evenRecognizerErrorMessage = "A valid numeric value must be no longer than 16 characters.\n";
					return evenRecognizerErrorMessage + displayInput(input, 16);
				}

				// Move to the next state
				state = nextState;
				nextState = -1;
			}
			// Should the FSM get here, the loop starts again

		}
		displayDebuggingInfo();
		
		System.out.println("The loop has ended.");

		evenRecognizerIndexofError = currentCharNdx;		// Copy the index of the current character;
		
		// When the FSM halts, we must determine if the situation is an error or not.  That depends
		// of the current state of the FSM and whether or not the whole string has been consumed.
		// This switch directs the execution to separate code for each of the FSM states and that
		// makes it possible for this code to display a very specific error message to improve the
		// user experience.
		switch (state) {
		case 0:
			// State 0 is not a final state, so we can return a very specific error message
			evenRecognizerIndexofError = currentCharNdx-1;		// Copy the index of the current character;
			evenRecognizerErrorMessage = "The input must start with a numeric digit\n";
			return evenRecognizerErrorMessage;

		case 1:
			// State 1 is not a final state, so we can return a very specific error message
			evenRecognizerIndexofError = currentCharNdx-1;		// Copy the index of the current character;
			evenRecognizerErrorMessage = "The input is odd since the last digit is odd\n";
			return evenRecognizerErrorMessage + displayInput(input, currentCharNdx-1);

		case 2:
			// State 2 is not a final state, so we can return a very specific error message
			evenRecognizerIndexofError = currentCharNdx-1;		// Copy the index of the current character;
			evenRecognizerErrorMessage = "Zero is not considered to be even.\n";
			return evenRecognizerErrorMessage + displayInput(input, currentCharNdx-1);
						
		case 3:
			// State 3 is a Final State, so this is not an error if the input is empty.
			if (currentCharNdx<input.length()) {
				// If not all of the string has been consumed, we point to the current character
				// in the input line and specify what that character must be in order to move
				// forward.
				evenRecognizerIndexofError = currentCharNdx;		// Copy the index of the current character;
				evenRecognizerErrorMessage = "A numeric value may only contain digits\n";
				return evenRecognizerErrorMessage + displayInput(input, currentCharNdx-1);
			}
			else 
			{	
				// The input is empty, so the recognizer has accepted the input
				evenRecognizerIndexofError = -1;
				evenRecognizerErrorMessage = "";
				return evenRecognizerErrorMessage;
			}
			
		default:
			return "";
		}	
	}
}
