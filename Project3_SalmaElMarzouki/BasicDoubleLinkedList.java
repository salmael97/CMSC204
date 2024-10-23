import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	//Pointers to the first and last nodes of the linked list
	protected Node head;
	protected Node tail;
	protected int elementCount = 0;
	
	// Keeps track of the number of elements in the list

    // Inner class for defining the nodes of the double linked list
	protected class Node{
		protected T data;// Data stored in each node
		protected Node next;// Reference to the next node in the list
		protected Node prev;// Reference to the previous node in the list
		// Constructor to initialize a node with data
		public Node(T dataNode01) {
			data = dataNode01;
		}
	}
    // Inner class for the list iterator

	protected class DoubleLinkedListIterator implements ListIterator<T>{
		protected Node prevN;
		protected Node nextN;
        // Constructor initializes the iterator at the beginning of the list
		
		public DoubleLinkedListIterator() {
			//numOfEntries = 0;
			prevN =null;
			nextN = head;// Start at the head of the list
		}
		@Override
		public boolean hasNext() {return nextN != null;}// Checks if there is a next node available


		@Override
		public T next() throws NoSuchElementException {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			prevN = nextN;
			nextN = nextN.next;// Move to the next node
			return prevN.data;
		}

		@Override
		public boolean hasPrevious() {return prevN != null;}// Checks if there is a previous node available

		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			nextN=prevN;
			prevN = nextN.prev;
			return nextN.data;
		}
        // Unsupported operations in this iterator implementation

		@Override
		public int nextIndex() throws UnsupportedOperationException{throw new UnsupportedOperationException();}

		@Override
		public int previousIndex() throws UnsupportedOperationException{throw new UnsupportedOperationException();}

		@Override
		public void remove() throws UnsupportedOperationException{throw new UnsupportedOperationException();}

		@Override
		public void set(T e)throws UnsupportedOperationException{throw new UnsupportedOperationException();}

		@Override
		public void add(T e) throws UnsupportedOperationException{throw new UnsupportedOperationException();}
		
	}
	
    // Constructor for creating an empty double-linked list

	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		elementCount = 0;
	}
    // Returns the number of elements in the list

	public int getSize() {
		return elementCount;
	}
    // Adds a new element to the end of the list

	public void addToEnd​(T data01) {
		Node newNode = new Node(data01);
		newNode.next = null;
		newNode.prev = null;
        // If the list is empty, set the new node as head and tail

		if(tail == null&& head == null) {
			head = newNode;
			tail = newNode;
		}else {

			tail.next = newNode;// Link the new node to the last node
			newNode.prev = tail;// Set the previous link for the new node
			tail = newNode;// Update the tail to the new node
		}
		elementCount++;
	}
    // Adds a new element to the front of the list

	public void addToFront​(T data01) {
		Node newNode = new Node(data01);
		newNode.next = null;
		newNode.prev = null;
        // If the list is empty, set the new node as head and tail

		if(head == null && head == null) {
			head = newNode;
			tail = newNode;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		elementCount++;
	}
    // Returns the first element of the list

	public T getFirst() {
		return (T)head.data;
		}
    // Returns the last element of the list

	public T getLast() {
		return (T)tail.data;
		}
    // Returns a list iterator instance

	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
		}
    // Removes an element from the list using a comparator

	public BasicDoubleLinkedList.Node remove​(T targetData, Comparator<T> comparator){
		Node temp = head;
        // Traverse through the list to find the target node

		while(temp.next != null) {
			if(comparator.compare(temp.data, targetData) == 0) {
				if(temp == head) {
					head = head.next;
					temp.next = null;
					head.prev = null;
					elementCount--;
					return temp;
				}else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
					elementCount--;
					return temp;
				}
			}
			temp = temp.next;
		}
		if(tail == temp && comparator.compare(temp.data, targetData) == 0) {
			tail = tail.prev;
			temp.prev =null;
			tail.next = null;
			elementCount--;
			return temp;
		}
		return temp;
	}
	public T retrieveFirstElement() {
		Node temp = head;
		if(head != null) {
			head = head.next; //sets head to the next
			head.prev = null;
		}
		elementCount--;
		return (T)temp.data;
	}
	public T retrieveLastElement() {
		Node temp = tail;
		if(tail != null) {
			tail = tail.prev;
			tail.next = null;
		}
		elementCount--;
		return (T)temp.data;
	}
	public ArrayList<T> toArrayList(){
		ArrayList <T> temp = new ArrayList<>();
		ListIterator<T> it = iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}
}
