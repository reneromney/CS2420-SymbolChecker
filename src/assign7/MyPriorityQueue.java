package assign7;

import java.util.NoSuchElementException;

/**
 * A priority queue that supports access of the minimum element only. ALL
 * METHODS ARE O(1).
 * 
 * @author Erin Parker, Jordan Hensley, and Romney Doria jHensley, doria
 *         assignment 7 10/20/2015 CS_2420-Fall 2015
 * 
 * @param <E>
 *            -- the type of elements contained in this priority queue
 */
public class MyPriorityQueue<E extends Comparable<? super E>> {

	// One stack to hold all the items and another to hold the minimums as they
	// come in.
	private MyStack<E> allItems;
	private MyStack<E> minimums;

	public MyPriorityQueue() {
		allItems = new MyStack<E>();
		minimums = new MyStack<E>();
	}

	/**
	 * Returns, but does not remove, the minimum element in this priority queue.
	 * Throws NoSuchElementException if the priority queue is empty.
	 */
	public E findMin() throws NoSuchElementException {
		return minimums.peek();
	}

	/**
	 * Inserts the specified item into this priority queue.
	 */
	public void insert(E item) {
		allItems.push(item);
		//If a new minimum is inserted push it on the minimums stack
		if (size() == 0 || item.compareTo(minimums.peek()) < 0)
			minimums.push(item);
		else
			minimums.push(minimums.peek());
	}

	/**
	 * Returns the number of items in this priority queue.
	 */
	public int size() {
		return minimums.size();
	}

	/**
	 * Returns true if this priority queue contains no items.
	 */
	public boolean isEmpty() {
		return allItems.size() == 0;
	}

	/**
	 * Removes all of the items from this priority queue.
	 */
	public void clear() {
		allItems.clear();
		minimums.clear();
	}
}
