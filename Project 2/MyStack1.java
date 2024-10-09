package Package;

import java.util.ArrayList;

/** 
 * Implementation of a generic stack data structure.
 *
 * @param <T> The type of elements stored in the stack.
 */

public class MyStack1 <T> implements StackInterface<T> {
	
	private T[] stack1;
	private int size1;
	private int topindex1 = -1;
	private final static int DEFAULT_CAPACITY = 110;
	
	
	/** 
     * Constructor that initializes the stack with a specific size.
     *
     * @param size1 the maximum capacity of the stack
     */
	public MyStack1(int size1) {
		this.size1 = size1;
		stack1 = (T[]) new Object[size1];
	}
	public MyStack1() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
	
	public boolean isEmpty() {
		// If topIndex is -1, the stack is empty

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack cannot accept more elements, false otherwise.
     */
		return topindex1 == -1;
}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	
	public boolean isFull() {
		 
		return topindex1 == stack1.length-1;
	}
	
	/**
     * Removes and returns the element at the top of the stack.
     *
     * @return the top element of the stack
     * @throws StackUnderflowException if the stack is empty
     */
	
	public T pop() throws StackUnderflowException{
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		} 
		else {
//		topindex = stack.length-1;	// decrease the top by 1 so next time when we try to pop the next element.
		T element =  stack1[topindex1]; //storing the pop element. 
		stack1[topindex1] = null;//deleting the elemnt by assigning null to it.
		topindex1--;
		return element; //return the pop element.
		
		}
		
	}
	
	/**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return the top element of the stack
     * @throws StackUnderflowException if the stack is empty
     */
	
	public T top() throws StackUnderflowException{
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T element1 = stack1[topindex1];
			return element1;	
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	
	public int size() {
		
		return topindex1+1;
	}
	
	/**
     * Adds an element to the top of the stack.
     *
     * @param e the element to be added
     * @return true if the push operation was successful
     * @throws StackOverflowException if the stack is full
     */
	
	public boolean push(T e) throws StackOverflowException{
	
		if(isFull()){
			throw new StackOverflowException();
		} else {
			stack1[topindex1+1] = e;
			topindex1++;
			return true;
		}
		
//		if(stack[topindex].equals(e))
//			return true;
//		else
//			return false;
	}
	
	/**
     * Provides a string representation of the stack elements from bottom to top.
     *
     * @return a string that represents the elements in the stack from bottom to top
     */
	
	public String toString() {
		String str1 = "";
//		for(int i = size()-1; i >= 0 ;i--) {
//			str+= stack[i] + " ";
//		}
		for(int i = 0; i<= topindex1; i++) {
			str1+= stack1[i];
		}
		

		return str1;
	}
	
	/**
     * Returns a string representation of the stack elements, separated by a delimiter.
     *
     * @param delimiter the string to be placed between elements
     * @return a string of stack elements from bottom to top with the delimiter
     */
	
	public String toString(String delimiter) {
		
		//String str = "";
		StringBuilder string1  = new StringBuilder();
		
		for(int i = 0; i<=topindex1; i++) {
			string1.append(stack1[i]).append(delimiter);
		}
		
		//string1.deleteCharAt(string1.length()-1);
		
		for(int i = string1.length()-1; i<string1.length()+1; i++) {
			string1.deleteCharAt(i);
		}
		
		String str1 = string1.toString();

		return str1;
	}
	
	 /**
     * Fills the stack with elements from an ArrayList.
     * The first element in the ArrayList becomes the bottom element of the stack.
     * 
     * @param list1 the ArrayList containing elements to add to the stack
     * @throws StackOverflowException if the stack is full
     */
	
	public void fill(ArrayList<T> list1) throws StackOverflowException {
		
		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
		for(int i = 0; i< list1.size();i++) {
			T element1=(list1.get(i));
			push(element1);
		}
	}
 
	}
}