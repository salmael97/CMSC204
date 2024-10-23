import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BasicDoubleLinkedList_STUDENT_Test {
    // Creating different types of BasicDoubleLinkedList objects for testing

	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Car> linkedCar;
    // Comparators to help with sorting and removing elements

	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
    // Creating sample car objects for testing

	public Car a=new Car("Toyota", "Camry", 2022);
	public Car b=new Car("Honda", "Civic", 2020);
	public Car c=new Car("Dodge", "Hellcat", 2018);
	public Car d=new Car("BMW", "M5", 2016);
	public Car e=new Car("Toyota", "Supra", 2023);
	public Car f=new Car("Jeep", "TrackHawk", 2005);


	public ArrayList<Car> fill = new ArrayList<Car>();
    // This method runs before each test to set up necessary objects and add data

	@BeforeEach
	void setUp() throws Exception {
        // Set up a linked list for Strings and add elements

		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd​("Yanb");
		linkedString.addToEnd​("La");
		linkedString.addToEnd​("Kacc");
		comparator = new StringComparator();
        // Set up a linked list for Doubles and add elements

		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd​(77.0);
		linkedDouble.addToEnd​(11.0);
		linkedDouble.addToEnd​(22.2);
		comparatorD = new DoubleComparator();
        // Set up a linked list for Car objects and add elements

		linkedCar = new BasicDoubleLinkedList<Car>();
		linkedCar.addToEnd​(b);
		linkedCar.addToEnd​(c);
		comparatorCar = new CarComparator();
	}
    // This method runs after each test to clean up resources

	@AfterEach
	void tearDown() throws Exception {
		linkedString  = null;
		linkedDouble = null;
		linkedCar = null;
		comparator = null;
		comparatorD = null;
	}
    // Test method to check if the size of each list is correct

	@Test
	void testGetSize() {
		assertEquals(3,linkedString.getSize());
		assertEquals(3,linkedDouble.getSize());
		assertEquals(2,linkedCar.getSize());
	}
    // Test method to check adding elements to the end of the list

	@Test
	void testAddToEnd​() {
		assertEquals("Kacc", linkedString.getLast());
		linkedString.addToEnd​("Ay");
		assertEquals("Ay", linkedString.getLast());
		linkedString.addToEnd​("Ga7uk");
		assertEquals("Ga7uk", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d,linkedCar.getLast());
	}
    // Test method to check adding elements to the front of the list

	@Test
	void testAddToFront​() {
		assertEquals("Yanb", linkedString.getFirst());
		linkedString.addToFront​("Hey");
		assertEquals("Hey", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront​(a);
		assertEquals(a,linkedCar.getFirst());
	}
    // Test method to get the first element in each list

	@Test
	void testGetFirst() {
		assertEquals("Yanb", linkedString.getFirst());
		linkedString.addToFront​("Wowzers");
		assertEquals("Wowzers", linkedString.getFirst());
		
		assertEquals(b,linkedCar.getFirst());
		linkedCar.addToFront​(a);
		assertEquals(a,linkedCar.getFirst());
	}
    // Test method to get the last element in each list

	@Test
	void testGetLast() {
		assertEquals("Kacc", linkedString.getLast());
		linkedString.addToEnd​("yeee");
		assertEquals("yeee", linkedString.getLast());
		
		assertEquals(c,linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d,linkedCar.getLast());
	}
    // Test method to verify the functionality of the list iterator

	@Test
	void testIterator() {
		ArrayList<Car> list;
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(e);
		list = linkedCar.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(b,list.get(1));
		assertEquals(c,list.get(2));
		assertEquals(e,list.get(3));
	}
    // Test the iterator's ability to iterate successfully in the forward direction

	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront​("Start");
		linkedString.addToEnd​("Finish");
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Start", iterator.next());
		assertEquals("Yanb", iterator.next());
		assertEquals("La", iterator.next());
		assertEquals("Kacc", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Finish", iterator.next());
		
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
    // Test the iterator's ability to iterate successfully in the reverse direction

	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
    // Test to check that a NoSuchElementException is thrown correctly by the iterator's next() method

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
            // No more elements in the list, so next() should throw NoSuchElementException

			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
    // Test to check that a NoSuchElementException is thrown correctly by the iterator's previous() method

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
		
		try{
            // No more elements in the list, so previous() should throw NoSuchElementException
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedCar.addToFront​(a);
		linkedCar.addToEnd​(d);
		ListIterator<Car> iteratorCar = linkedCar.iterator();		
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
		
		try{
            // No more elements in the list, so previous() should throw NoSuchElementException
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
    // Test to check that the UnsupportedOperationException is thrown correctly by the iterator's remove() method

	@Test
	void testRemove​() {
		assertEquals(b, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToFront​(a);
		assertEquals(a, linkedCar.getFirst());
		linkedCar.remove​(a, comparatorCar);
		assertEquals(b, linkedCar.getFirst());
		
		linkedCar.addToEnd​(d);
		assertEquals(d, linkedCar.getLast());
		linkedCar.remove​(d, comparatorCar);
		assertEquals(c, linkedCar.getLast());
	
		linkedCar.addToFront​(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
		linkedCar.remove​(b, comparatorCar);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(c, linkedCar.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals(b, linkedCar.getFirst());
		linkedCar.addToFront​(a);
		assertEquals(a, linkedCar.getFirst());
		assertEquals(a, linkedCar.retrieveFirstElement());
		assertEquals(b,linkedCar.getFirst());
		assertEquals(b, linkedCar.retrieveFirstElement());
		assertEquals(c,linkedCar.getFirst());
		
		assertEquals("Yanb", linkedString.getFirst());
		linkedString.addToFront​("Wey");
		assertEquals("Wey", linkedString.getFirst());
		assertEquals("Wey", linkedString.retrieveFirstElement());
		assertEquals("Yanb",linkedString.getFirst());
		assertEquals("Yanb", linkedString.retrieveFirstElement());
		assertEquals("La",linkedString.getFirst());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals(c, linkedCar.getLast());
		linkedCar.addToEnd​(d);
		assertEquals(d, linkedCar.getLast());
		assertEquals(d, linkedCar.retrieveLastElement());
		assertEquals(c,linkedCar.getLast());
		
		assertEquals("Kacc", linkedString.getLast());
		linkedString.addToEnd​("arzzz");
		assertEquals("arzzz", linkedString.getLast());
		assertEquals("arzzz", linkedString.retrieveLastElement());
		assertEquals("Kacc",linkedString.getLast());
	}


	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class CarComparator implements Comparator<Car>
	{

		@Override
		public int compare(Car arg0, Car arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Car{
		String make;
		String model;
		int year;
		
		public Car(String make, String model, int year){
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		public String getMake(){
			return make;
		}
		public String getModel(){
			return model;
		}
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getMake()+" "+getModel()+" "+getYear());
		}
	}
}
