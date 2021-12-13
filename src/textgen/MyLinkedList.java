package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("element can not be null");
			
		}
		LLNode<E> last = tail.prev;
		LLNode<E> curr = new LLNode<E>(element, last);
		//System.out.println("curr data: " + curr.data + "\tcurr prev: " + curr.prev.data + "\tcurr next: " + curr.next.data + "\tprev next: " + curr.prev.next.data);
		size ++;
		if (curr.data != null) {
			return true;
		}
		else {
			return false;
		}
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		LLNode<E> currNode = indexNode(index);
		return currNode.data;
	}
	
	private LLNode<E> indexNode(int index) {
		if (index >= size  ||  index < 0) {
			throw new IndexOutOfBoundsException();
		}
		int curr = 0;
		LLNode<E> currNode = head.next;
		
		while (curr < index) {
			//System.out.println(currNode.data);
			currNode = currNode.next;
			curr ++;
		}
		
		return currNode;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("element can not be null");
		}
		LLNode<E> currNode;
		if (index == size) {
			currNode = tail;
		}
		else {
			currNode = indexNode(index);
		}
		LLNode<E> newNode = new LLNode<E>(element, currNode.prev);
		
		
		size ++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> currNode = indexNode(index);
		currNode.prev.next = currNode.next;
		currNode.next.prev = currNode.prev;
		size --;
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("element can not be null");
		}
		LLNode<E> currNode = indexNode(index);
		currNode.data = element;
		return element;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> prevNode) {
		this(e);
		this.next = prevNode.next;
		prevNode.next.prev = this;
		this.prev = prevNode;
		prevNode.next = this;
	}
	
	public String toString() {
		return String.valueOf(this.data);
	}

}
