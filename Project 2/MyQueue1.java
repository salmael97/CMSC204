package Package;
 
import java.util.ArrayList;

/** 
 * Implementation of a generic Queue data structure.
 *
 * @param <T> The type of elements held in this queue.
 */
public class MyQueue1<T> implements QueueInterface<T> {
	
	private T[] MyQueue1;
	private int size1;
	int front1 =0;
	private int lastindex1 = -1;
	private final static int DEFAULT_CAPACITY = 110;

	/** 
     * Constructor that initializes the queue with a specified capacity.
     * 
     * @param size1 the capacity of the queue
     */
	public MyQueue1(int size1){
		this.size1 = size1;
		MyQueue1 = (T[]) new Object[size1]; // Create the array for the queue
	}
	/** 
     * Default constructor that initializes the queue with a default capacity.
     */
	public MyQueue1() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
     * Checks if the queue is empty.
     * 
     * @return true if the queue has no elements, false otherwise.
     */
	public boolean isEmpty() {
		
		return lastindex1 == -1;
	}

	/**
     * Checks if the queue is full.
     * 
     * @return true if the queue cannot accept more elements, false otherwise.
     */
	public boolean isFull() {
		return lastindex1  == MyQueue1.length-1;
	}
	
	/**
     * Removes and returns the element at the front of the queue.
     * 
     * @return the front element of the queue
     * @throws QueueUnderflowException if the queue is empty
     */
	public T dequeue() throws QueueUnderflowException{
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
		T element1 = MyQueue1[front1];
		MyQueue1[front1] = null;
		front1 = (front1 + 1) % MyQueue1.length;
		lastindex1 --;
		return element1;
	}
}

	/**
     * Returns the number of elements currently in the queue.
     * 
     * @return the count of elements in the queue
     */
	public int size1() {
		return lastindex1 +1;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			MyQueue1[++lastindex1 ] = e;
			return true;
		}
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<=lastindex1;i++) {
			str.append(MyQueue1[i]);
		}
		
		return str.toString();
		}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i<=lastindex1;i++) {
			str.append(MyQueue1[i]).append(delimiter);
		}
		
		str.deleteCharAt(str.length()-1);
		
		return str.toString();
		}
		
	
	/**
     * Fills the queue with elements from an ArrayList.
     * The first element in the ArrayList becomes the first element in the queue.
     * It is essential to make a copy of the list elements to avoid external modification.
     * 
     * @param list1 the ArrayList containing elements to add to the queue
     * @throws StackOverflowException if there is an internal stack overflow
     * @throws QueueOverflowException if the queue is full
     */
	public void fill(ArrayList<T> list1) throws StackOverflowException, QueueOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
		for(int i = 0; i< list1.size();i++) {
			T element1=(list1.get(i));
			enqueue(element1);
			}
	}
 

}
	
}
