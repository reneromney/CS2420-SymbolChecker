package assign7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Erin Parker, Jordan Hensley, and Romney Doria jHensley, doria
 *         assignment 7 10/20/2015 CS_2420-Fall 2015
 */
public class BalancedSymbolChecker {

	// Holds opening bracket characters
	private static MyStack<Character> stack = new MyStack<Character>();
	// Is true if the file is currently in a block comment
	private static boolean inComment;
	// Is true if the file is currently in a line comment '//'
	private static boolean inLineComment;
	// Is true if the file is currently reading a string.
	private static boolean inString;
	// Is true if the file is currently reading a char.
	private static boolean inChar;
	// To hold all characters in a line.
	private static char[] charArray;
	// To hold the expected closing bracket
	private static char expected;
	// Holds the current line number
	private static int lineCounter;
	// holds the current column number
	private static int columnCounter;
	// holds the current index of charArray
	private static int i;

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */
	public static String checkFile(String filename) throws FileNotFoundException {
		// Must reset all of the instance variables
		initializeVariables();
		File myFile = new File(filename);
		Scanner scan = new Scanner(myFile);
		// Reads in a character at a time
		scan.useDelimiter("");

		while (scan.hasNextLine()) {
			charArray = scan.nextLine().toCharArray();
			lineCounter++;
			// an in line comment ends after each line
			inLineComment = false;
			for (i = 0; i < charArray.length; i++) {
				columnCounter = i + 1;
				// methods to check if a bracket character should be read or
				// not.
				checkInChar();
				checkInString();
				checkInLineComments();
				checkForCommentTokens();
				checkForClosingComment();

				if (!inChar && !inString && !inComment && !inLineComment
						&& (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '('))
					stack.push(charArray[i]);
				if (!inChar && !inString && !inComment && !inLineComment
						&& (charArray[i] == '}' || charArray[i] == ')' || charArray[i] == ']')) {
					// sets expected to the expected opening bracket
					getExpectedChar();
					if (charArray[i] != expected) {
						return unmatchedSymbol(lineCounter, columnCounter, charArray[i], expected);
					}
				}
			}
		}
		// An error should be thrown if a comment is left open
		if (inComment == true)
			return unfinishedComment();
		// The stack is not empty when the file is done being read
		else if (!stack.isEmpty())
			return unmatchedSymbolAtEOF(getEndingExpected());
		else
			return allSymbolsMatch();
	}

	/**
	 * This method is called to initialize all variables, so they are refreshed
	 * every time the checkfile method is called.
	 */
	private static void initializeVariables() {
		stack = new MyStack<Character>();
		inComment = false;
		inLineComment = false;
		inString = false;
		inChar = false;
		charArray = null;
		expected = ' ';
		lineCounter = 0;
		columnCounter = 0;
	}

	/**
	 * This method will make the instring instance variable true if a string is
	 * started or false if one is ended. The method will be skipped if the file
	 * is currently in any type of comment.
	 */
	private static void checkInString() {
		if (!inChar && !inComment && !inLineComment && charArray[i] == '"') {
			if (inString)
				inString = false;
			else
				inString = true;
		}
	}

	/**
	 * This method makes the inchar variable true if a file is reading in a
	 * character and false if it is being closed. This method will be overlooked
	 * if in a string or comment.
	 */
	private static void checkInChar() {
		if (!inComment && !inString && !inLineComment && charArray[i] == '\'') {
			if (inChar)
				inChar = false;
			else
				inChar = true;
		}
	}

	/**
	 * This method will set the inComment variable to true if the opening
	 * characters of a block comment(/*) are found. This will be overlooked if
	 * the file is already in a comment or if in a string.
	 */
	private static void checkForCommentTokens() {
		if (!inString && !inComment && !inLineComment && charArray[i] == '/' && i < charArray.length - 1
				&& charArray[i + 1] == '*') {
			inComment = true;
			// Advance the index past these characters.
			if (i < charArray.length - 2 && charArray[i + 2] != '"')
				i = i + 2;
			else
				i = i + 1;
		}
	}

	/**
	 * This method will make the inLineComment variable true if the characters
	 * for beginning a line comment(//) are found if the file is not currently
	 * in another comment or in a string.
	 */
	private static void checkInLineComments() {
		if (!inString && !inComment && charArray[i] == '/' && i < charArray.length - 1 && charArray[i + 1] == '/') {
			inLineComment = true;
			// advance the index past these comment characters.
			if (i < charArray.length - 2 && charArray[i + 2] != '"')
				i = i + 2;
			else
				i = i + 1;
		}
	}

	/**
	 * This method will make the inComment variable false if the closing comment
	 * characters are found while the file is reading in a comment.
	 */
	private static void checkForClosingComment() {
		if (inComment && i < charArray.length - 1 && charArray[i] == '*' && charArray[i + 1] == '/') {
			inComment = false;
			i = i + 1;
		}
	}

	/**
	 * This method sets the expected variable to hold the correct closing
	 * bracket corresponding to the opening bracket that the stack holds.
	 */
	private static void getExpectedChar() {
		//Shouldn't expect anything if the stack is empty.
		if (stack.isEmpty())
			expected = ' ';
		else {
			char popTemp = stack.pop();
			if (popTemp == '{')
				expected = '}';
			else if (popTemp == '[')
				expected = ']';
			else
				expected = ')';
		}
	}

	/**
	 * @return the expected closing character from what is read from the stack.
	 */
	private static char getEndingExpected() {
		char c = stack.peek();
		if (c == '(')
			return ')';
		else if (c == '[')
			return ']';
		else
			return '}';
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private static String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected "
				+ symbolExpected + ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private static String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private static String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private static String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}
