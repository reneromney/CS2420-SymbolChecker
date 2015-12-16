package assign7;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * This class provides tests to ensure the quality and functionality of the
 * MyPriorityQueue class.
 * 
 * @author Jordan Hensley, and Romney Doria jHensley, doria assignment 7
 *         10/20/2015 CS_2420-Fall 2015
 *
 */
public class MyPriorityQueueTester {

	@Test
	public void test() {
		// Ensure correct results of a newly created MyPriorityQueue
		MyPriorityQueue<Integer> test = new MyPriorityQueue<Integer>();
		assertTrue(test.isEmpty());
		assertTrue(test.size() == 0);
	}

	@Test(expected = NoSuchElementException.class)
	public void testGetMinFail() {
		// Ensure the correct exception of finding the minimum item of an empty
		// MyPriorityQueue.
		MyPriorityQueue<Integer> testFail = new MyPriorityQueue<Integer>();
		testFail.findMin();
	}

	@Test
	public void testSizeAndFindMin() {
		MyPriorityQueue<Integer> testMin = new MyPriorityQueue<Integer>();
		testMin.insert(20);
		assertTrue(testMin.findMin() == 20);
		testMin.insert(45);
		assertTrue(testMin.findMin() == 20);
		assertTrue(testMin.size() == 2);
		testMin.insert(15);
		assertTrue(testMin.findMin() == 15);
		assertTrue(testMin.size() == 3);
		testMin.insert(2);
		assertTrue(testMin.size() == 4);
		assertTrue(testMin.findMin() == 2);
	}

	@Test
	public void testClear() {
		MyPriorityQueue<Integer> test = new MyPriorityQueue<Integer>();
		test.insert(23);
		test.insert(04);
		test.insert(10);

		// To ensure the clear method works
		assertTrue(test.size() == 3);
		assertFalse(test.isEmpty());
		test.clear();
		assertTrue(test.size() == 0);
		assertTrue(test.isEmpty());
	}

	// Testing Priority Queue
	@Test
	public void testPQ() {
		MyPriorityQueue<Integer> testQ = new MyPriorityQueue<Integer>();
		testQ.insert(10);
		assertEquals(1, testQ.size());
		assertEquals(10, testQ.findMin(), 0);
		testQ.insert(99);
		assertEquals(2, testQ.size());
		assertEquals(10, testQ.findMin(), 0);
		testQ.insert(1);
		assertEquals(3, testQ.size());
		assertEquals(1, testQ.findMin(), 0);

	}

}
