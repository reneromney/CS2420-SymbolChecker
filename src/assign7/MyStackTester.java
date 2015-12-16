package assign7;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * This class provides tests to ensure the quality and functionality of the
 * MyStackClass.
 * 
 * @author Jordan Hensley, Romney Doria jHensley, doria assignment 7 10/20/2015
 *         CS_2420-Fall 2015
 *
 */
public class MyStackTester {

	@Test
	public void testMyStack() {
		// Test expected results of creating a new MyStack object
		MyStack<Integer> testStack = new MyStack<Integer>();
		assertTrue(testStack.size() == 0);
		assertTrue(testStack.isEmpty());
	}

	@Test
	public void testPush() {
		MyStack<Integer> testStack = new MyStack<Integer>();
		testStack.push(23);
		testStack.push(43);
		testStack.push(21);

		// Ensure the correct size after doing a number of pushes
		assertFalse(testStack.isEmpty());
		assertTrue(testStack.size() == 3);
	}

	@Test
	public void testPeek() {
		MyStack<Integer> testStack = new MyStack<Integer>();

		testStack.push(23);
		assertTrue(testStack.peek() == 23);
		// Ensure the next pushed item is on top
		testStack.push(2);
		assertTrue(testStack.peek() == 2);
	}

	@Test(expected = NoSuchElementException.class)
	public void testPeekFail() {
		// Ensure the thrown exception of peeking at an empty stack.
		MyStack<Integer> testStack = new MyStack<Integer>();
		testStack.peek();
	}

	@Test
	public void testPop() {
		MyStack<String> testStack = new MyStack<String>();
		testStack.push("hello");
		testStack.push("dog");
		testStack.push("cat");

		assertEquals("cat", testStack.pop());
		assertTrue(testStack.size() == 2);
		// Ensure the popped object is gone
		assertEquals("dog", testStack.peek());
	}

	@Test(expected = NoSuchElementException.class)
	public void testPopFail() {
		MyStack<Integer> testStack = new MyStack<Integer>();
		testStack.pop();
	}

	@Test
	public void testClear() {
		MyStack<Integer> testStack = new MyStack<Integer>();
		testStack.push(23);
		testStack.push(2039);
		testStack.push(220);

		assertTrue(testStack.size() == 3);
		// Ensure quality of the clear method.
		testStack.clear();
		assertTrue(testStack.size() == 0);
		assertTrue(testStack.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		MyStack<Integer> test = new MyStack<Integer>();
		test.push(2);
		test.push(230);
		test.pop();
		test.pop();
		assertTrue(test.isEmpty());
	}

	// Testing Stack
	@Test
	public void testStack() {
		MyStack<Integer> testStack = new MyStack<Integer>();
		testStack.push(5);
		testStack.push(2);
		testStack.push(3);
		assertEquals(3, testStack.size());
		assertEquals(3, testStack.peek(), 0);
		testStack.pop();
		assertEquals(2, testStack.size());
		assertEquals(2, testStack.peek(), 0);
		testStack.pop();
		assertEquals(1, testStack.size());
		assertEquals(5, testStack.peek(), 0);
		testStack.pop();
		assertEquals(0, testStack.size());
	}
}
