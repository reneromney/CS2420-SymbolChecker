package assign7;

import java.util.NoSuchElementException;

/**
 * Represents a generic stack (last in, first out).
 * 
 * @author Erin Parker, Jordan Hensley, and Romney Doria
 * jHensley, doria
 * assignment 7
 * 10/20/2015
 * CS_2420-Fall 2015
 * 
 * @param <E>
 *            -- the type of elements contained in the stack
 */
public class MyStack<E> {

	//Stack will be represented using the MyLinkedList
	private MyLinkedList<E> stack;

	public MyStack() {
		stack = new MyLinkedList<E>();
	}

	/**
	 * Removes all of the elements from the stack.
	 */
	public void clear() {
		stack.clear();
	}

	/**
	 * Returns true if the stack contains no elements.
	 */
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	/**
	 * Returns the item at the top of the stack without removing it from the
	 * stack. Throws NoSuchElementException if the stack is empty.
	 */
	public E peek() throws NoSuchElementException {
		return stack.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack. Throws
	 * NoSuchElementException if the stack is empty.
	 */
	public E pop() throws NoSuchElementException {
		return stack.removeFirst();
	}

	/**
	 * Pushes the input item onto the top of the stack.
	 */
	public void push(E item) {
		stack.addFirst(item);
	}

	/**
	 * Returns the number of items in the stack.
	 */
	public int size() {
		return stack.size();
	}
}
