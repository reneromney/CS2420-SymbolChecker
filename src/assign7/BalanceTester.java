package assign7;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * This class provides tests that ensure the quality and functionality of the
 * BalancedSymbolChecker class. Classes 1-13 were written by Professor Erin
 * Parker.
 * 
 * @author Jordan Hensley, and Romney Doria jHensley, doria assignment 7
 *         10/20/2015 CS_2420-Fall 2015
 *
 */
public class BalanceTester {

	@Test
	public void test() throws FileNotFoundException {
		// The purpose of each test is stated in each of these classes in the
		// "SymbolCheckerTests" file submitted with the assignment.

		// Class1
		assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class1.java"));

		// Class2
		assertEquals("ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class2.java"));

		// Class3
		assertEquals("No errors found. All symbols match.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class3.java"));

		// Class4
		assertEquals("ERROR: File ended before closing comment.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class4.java"));

		// Class5
		assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class5.java"));

		// Class6
		assertEquals("No errors found. All symbols match.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class6.java"));

		// Class7
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class7.java"));

		// Class8
		assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class8.java"));

		// Class9
		assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class9.java"));

		// Class10
		assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class10.java"));

		// Class11
		assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class11.java"));

		// Class12
		assertEquals("No errors found. All symbols match.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class12.java"));

		// Class13
		assertEquals("No errors found. All symbols match.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class13.java"));
		
		//Class14
		assertEquals("ERROR: Unmatched symbol at line 6 and column 1. Expected  , but read } instead.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class14.java"));
		
		//Class15
		assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.",
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class15.java"));
		
		//Class16
		assertEquals("ERROR: Unmatched symbol at line 1 and column 1. Expected  , but read ] instead.", 
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class16.java"));
		
		//Class17
		assertEquals("No errors found. All symbols match.", 
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class17.java"));
		
		//Class18
		assertEquals("ERROR: File ended before closing comment.", 
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class18.java"));
		
		//Class19
		assertEquals("ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.", 
				BalancedSymbolChecker.checkFile("SymbolCheckerTests/Class19.java"));
	}
}
