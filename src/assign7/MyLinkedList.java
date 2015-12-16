package assign7;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 
 * @author Jordan Hensley, Romney Doria jHensley doria 10/6/2015 Assignment 6
 *         CS_2420 - Fall 2015
 * 
 *         This class implements the List interface and provides functionality
 *         and methods related to a doubly linked list.
 *
 */
public class MyLinkedList<T> implements List<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * Constructs a new MyLinkedList, creates empty header and tail nodes, and
	 * sets heads next to tail and tails previous to head.
	 */
	public MyLinkedList() {
		head = new Node<T>(null);
		tail = new Node<T>(null);
		head.setNext(tail);
		tail.setPrevious(head);
		size = 0;
	}

	/**
	 * Inserts the specified element at the beginning of the list.
	 */
	@Override
	public void addFirst(T element) {
		Node<T> firstItem = new Node<T>(element, head.getNext(), head);
		// Insert a reference to the new node at the previous and next nodes.
		head.getNext().setPrevious(firstItem);
		head.setNext(firstItem);
		size++;
	}

	/**
	 * Inserts the specified element at the end of the list
	 */
	@Override
	public void addLast(T o) {
		Node<T> newNode = new Node<T>(o, tail, tail.getPrevious());
		tail.getPrevious().setNext(newNode);
		tail.setPrevious(newNode);
		size++;
	}

	/**
	 * Inserts the specified element at the specified index and will throw an
	 * index out of bounds exception if the given index is not a valid index.
	 */
	@Override
	public void add(int index, T element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (index == 0) {
			addFirst(element);
			return;
		}
		// Much faster to addLast
		if (index == size) {
			addLast(element);
			return;
		}
		Node<T> current = head;
		// Find the specified index
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		// Create new node and indexes to that node
		Node<T> newNode = new Node<T>(element, current.getNext(), current);
		current.getNext().setPrevious(newNode);
		current.setNext(newNode);
		size++;
	}

	/**
	 * Returns the first item in the list and will throw an exception if the
	 * list is empty.
	 */
	@Override
	public T getFirst() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		return head.getNext().getItem();
	}

	/**
	 * Returns the last item in the list and will throw an exception if the list
	 * is empty.
	 */
	@Override
	public T getLast() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		return tail.getPrevious().getItem();
	}

	/**
	 * Returns the item at the specified index and will throw an index out of
	 * bounds exception if the index is invalid.
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
		if (index == size - 1)
			return getLast();
		Node<T> temp = head.getNext();
		// Search for the index
		for (int i = 0; i < index; i++)
			temp = temp.getNext();
		return temp.getItem();
	}

	/**
	 * Returns a random item in the list and will throw a no such element
	 * exception if the list is empty.
	 */
	@Override
	public T getRandom() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		Random rng = new Random();
		return get(rng.nextInt(size));
	}

	/**
	 * Removes and returns the first item in the list and will throw a no such
	 * element exception if the list is empty.
	 */
	@Override
	public T removeFirst() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		T temp = head.getNext().getItem();
		// Remove references to the first node.
		head.getNext().getNext().setPrevious(head);
		head.setNext(head.getNext().getNext());
		size--;
		return temp;
	}

	/**
	 * Removes and returns the last item in the list and will throw a no such
	 * element exception if the list is empty.
	 */
	@Override
	public T removeLast() throws NoSuchElementException {
		if (size == 0)
			throw new NoSuchElementException();
		T temp = tail.getPrevious().getItem();
		// Remove references to the last node
		tail.getPrevious().getPrevious().setNext(tail);
		tail.setPrevious(tail.getPrevious().getPrevious());
		size--;
		return temp;
	}

	/**
	 * Removes and returns the element at the specified index. Will also throw
	 * an index out of bounds exception if the index is not valid.
	 */
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		if (index == size - 1)
			return removeLast();

		Node<T> tempNode = head.getNext();
		// Search for the node at index
		for (int i = 0; i < index; i++) {
			tempNode = tempNode.getNext();
		}
		T tempItem = tempNode.getItem();
		// Delete references to that node
		tempNode.getPrevious().setNext(tempNode.getNext());
		tempNode.getNext().setPrevious(tempNode.getPrevious());
		size--;
		return tempItem;
	}

	/**
	 * Returns the first index that contains the given element. If the element
	 * is not found, returns -1
	 */
	@Override
	public int indexOf(T element) {
		Node<T> tempNode = head.getNext();
		// Need to loop through the list
		for (int i = 0; i < size; i++) {
			if (tempNode.getItem().equals(element))
				return i;
			tempNode = tempNode.getNext();
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element.
	 */
	@Override
	public int lastIndexOf(T element) {
		Node<T> tempNode = tail.getPrevious();
		// Loop starting from tail
		for (int i = size - 1; i >= 0; i--) {
			if (tempNode.getItem().equals(element))
				return i;
			tempNode = tempNode.getPrevious();
		}
		return -1;
	}

	/**
	 * Returns the size of this linked lsit.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if the linked list is empty and false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Clears the linked list and sets its size to zero.
	 */
	@Override
	public void clear() {
		size = 0;
		// Must delete all references to middle nodes by setting heads next to
		// tail.
		head.setNext(tail);
		tail.setPrevious(head);
	}

	/**
	 * Returns an array of all of the objects contained in the linked list.
	 */
	@Override
	public Object[] toArray() {
		Node<T> temp = head.getNext();
		Object[] arr = new Object[size];
		for (int i = 0; i < size; i++) {
			arr[i] = temp.getItem();
			temp = temp.getNext();
		}
		return arr;
	}

}
