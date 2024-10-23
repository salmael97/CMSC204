import java.util.Comparator;
import java.util.ListIterator;

import javafx.scene.Node;
//This class extends the BasicDoubleLinkedList and maintains elements in a sorted order.

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> c;
	// Comparator used to define the sorting order

    // Constructor to initialize the comparator
	public SortedDoubleLinkedList(Comparator<T> compareableObject) {	c = compareableObject;}
    // Method to add an element in a sorted manner

	// Assign the comparator passed in the constructor
	public void add​(T data) {
        // Create a new node with the given data

		Node newN = new Node(data);
		Node temp = head;// Start from the head of the list
        // If the list is empty, set the new node as both the head and the tail

		if(head == null && tail == null) {
			head = tail = newN;
		}else {
            // Traverse the list to find the appropriate position for the new node

			while(temp != null) {
                // Compare the new data with the current node's data

				if(c.compare(data, temp.data)<0) {
                    // Case 1: The new data is less than the current head

					if(temp == head) {//when data is less than first element(head)
                        // Add to the front using the superclass method to maintain consistency

						super.addToFront​(data);
						elementCount++;
						break;
	                    // Case 2: Insert in the middle of the list

					}else if( temp != head) {//when data is in the middle less than temp
						temp.prev.next=newN;
						newN.prev = temp.prev;
						temp.prev = newN;
						newN.next = temp;
						elementCount++;
						break;
					}
				}
                // Move to the next node in the list

				temp = temp.next;
			}            // Case 3: If the new data is greater than all existing nodes (insert at the end)

			if(temp == null) { // Call the superclass method to add to the end
				super.addToEnd​(data);
			}
		}
		
	}
    // Method to remove an element using a comparator, delegates the task to the superclass method

	public BasicDoubleLinkedList.Node remove​(T data, Comparator<T> comparator){
		return super.remove​(data, comparator);
	}
	public ListIterator<T> iterator(){return super.iterator();}
	public void addToEnd​(T data) throws UnsupportedOperationException{throw new UnsupportedOperationException();}
	public void addToFront​(T data) throws UnsupportedOperationException{throw new UnsupportedOperationException();}
}
