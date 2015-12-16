package assign7;

/**
 * 
 * @author Jordan Hensley, Romney Doria jHensley doria 10/6/2015 Assignment 6
 *         CS_2420 - Fall 2015
 * 
 *         This generic class provides the building blocks to the linked list
 *         which is comprised of nodes that hold the stored item and references
 *         to the next and previous node. This class is protected in the assign6
 *         package and is only accessed through the MyLinkedList class.
 *
 */
class Node<T> {

	private Node<T> next;
	private Node<T> prev;
	private T item;

	/**
	 * Constructs a new node and assigns the item, the next node, and the
	 * previous node.
	 * 
	 * @param thisItem
	 * @param n
	 * @param p
	 */
	public Node(T thisItem, Node<T> n, Node<T> p) {
		this.item = thisItem;
		this.next = n;
		this.prev = p;
	}

	/**
	 * Creates a new node that contains no references to other nodes.
	 * 
	 * @param thisItem
	 */
	public Node(T thisItem) {
		this(thisItem, null, null);
	}

	/**
	 * @return the object stored in the accessed node
	 */
	public T getItem() {
		return this.item;
	}

	/**
	 * Sets the item in the node to the passed in object
	 * 
	 * @param thisItem
	 */
	public void setItem(T thisItem) {
		this.item = thisItem;
	}

	/**
	 * @return the node following the current node
	 */
	public Node<T> getNext() {
		return this.next;
	}

	/**
	 * Sets the next node of the current node to the node passed in
	 * 
	 * @param nextNode
	 */
	public void setNext(Node<T> nextNode) {
		this.next = nextNode;
	}

	/**
	 * @return the node previous to the current node
	 */
	public Node<T> getPrevious() {
		return this.prev;
	}

	/**
	 * Sets the previous node of the current node to the node passed in
	 */
	public void setPrevious(Node<T> previous) {
		this.prev = previous;
	}
}