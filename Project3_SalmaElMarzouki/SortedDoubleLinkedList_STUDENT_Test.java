import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class SortedDoubleLinkedList_STUDENT_Test {
    // Declare instances of sorted double linked lists with different types

	SortedDoubleLinkedList<String> sLinkedString;
	SortedDoubleLinkedList<Double> sLinkedDouble;
	SortedDoubleLinkedList<Car> sLinkedCar;
    // Declare comparator instances for each type

	StringComparator comparator;
	DoubleComparator comparatorD;
	CarComparator comparatorCar;
    // Car objects to be used in tests

	public Car a=new Car("Toyota", "Camry", 2022);
	public Car b=new Car("Honda", "Civic", 2020);
	public Car c=new Car("Dodge", "Hellcat", 2018);
	public Car d=new Car("BMW", "M5", 2016);
	public Car e=new Car("Toyota", "Supra", 2023);
	public Car f=new Car("Jeep", "TrackHawk", 2005);
    // Setup method that runs before each test to initialize variables and data

	@BeforeEach
	void setUp() throws Exception {
        // Initialize the comparators and sorted double linked lists for each type

		comparator = new StringComparator();
		sLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorCar = new CarComparator();
		sLinkedCar = new SortedDoubleLinkedList<Car>(comparatorCar);
	}
    // Cleanup method that runs after each test to nullify variables

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorCar = null;
		sLinkedString = null;
		sLinkedDouble = null;
		sLinkedCar = null;
	}
    // Test to check if adding an element to the end throws an exception as expected

	@Test
	void testTestAddToEnd() {
		try {
			sLinkedString.addToEnd​("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
    // Test to check if adding an element to the front throws an exception as expected

	@Test
	void testTestAddToFront() {
		try {
			sLinkedString.addToFront​("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
    // Test to verify successful forward iteration over a list of Car objects

	@Test
	void testTestIteratorSuccessfulNext() {
        // Add cars to the sorted list

		sLinkedCar.add​(a);
		sLinkedCar.add​(b);
		sLinkedCar.add​(c);
		sLinkedCar.add​(d);
        // Create an iterator and iterate forward through the list

		ListIterator<Car> iterator = sLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
	}
    // Test to verify successful backward iteration over a list of Strings

	@Test
	void testTestIteratorSuccessfulStringPrevious() {
        // Add strings to the sorted list

		sLinkedString.add​("Hye");
		sLinkedString.add​("Khauk");
		sLinkedString.add​("Lotuo");
		sLinkedString.add​("Wauk");
        // Create an iterator and iterate forward then backward through the list

		ListIterator<String> iterator = sLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Hye", iterator.next());
		assertEquals("Khauk", iterator.next());
		assertEquals("Lotuo", iterator.next());
		assertEquals("Wauk", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Wauk", iterator.previous());
		assertEquals("Lotuo", iterator.previous());
		assertEquals("Khauk", iterator.previous());
	}
    // Test to verify successful backward iteration over a list of Car objects

	@Test
	void testTestIteratorSuccessfulCarPrevious() {
        // Add cars to the sorted list

		sLinkedCar.add​(e);
		sLinkedCar.add​(c);
		sLinkedCar.add​(b);
		sLinkedCar.add​(d);
        // Create an iterator and iterate forward then backward through the list

		ListIterator<Car> iterator = sLinkedCar.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(e, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(c, iterator.previous());
	}
    // Test to verify successful forward iteration over a list of Double objects

	@Test
	void testTestIteratorSuccessfulDoubleNext() {
        // Add doubles to the sorted list

		sLinkedDouble.add​((Double)8.0);
		sLinkedDouble.add​((Double)6.0);
		sLinkedDouble.add​((Double)1.0);
		sLinkedDouble.add​((Double)2.0);
        // Create an iterator and iterate forward through the list

		ListIterator<Double> iterator = sLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double)1.0, iterator.next());
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)6.0, iterator.next());
		assertEquals(true, iterator.hasNext());
	}
    // Test to verify successful backward iteration over a list of Double objects

	@Test
	void testTestIteratorSuccessfulDoublePrevious() {
        // Add doubles to the sorted list

		sLinkedDouble.add​((Double)5.0);
		sLinkedDouble.add​((Double)10.0);
		sLinkedDouble.add​((Double)8.0);
		sLinkedDouble.add​((Double)2.0);
        // Create an iterator and iterate forward then backward through the list

		ListIterator<Double> iterator = sLinkedDouble.iterator();
		assertEquals((Double)2.0, iterator.next());
		assertEquals((Double)5.0, iterator.next());
		assertEquals((Double)8.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double)8.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
    // Test to verify that a NoSuchElementException is thrown correctly by the iterator's next() method

	@Test
	void testTestIteratorNoSuchElementException() {
		sLinkedCar.add​(e);
		sLinkedCar.add​(c);
		sLinkedCar.add​(b);
		sLinkedCar.add​(d);

		ListIterator<Car> iterator = sLinkedCar.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		try{
            // No more elements in the list, so next() should throw NoSuchElementException

			iterator.next();
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
    // Test to verify that an UnsupportedOperationException is thrown correctly by the iterator's remove() method

	@Test
	void testTestIteratorUnsupportedOperationExceptionString() {
		sLinkedCar.add​(e);
		sLinkedCar.add​(c);
		sLinkedCar.add​(b);
		sLinkedCar.add​(d);
		//ArrayList<Car> carList = sortedLinkedCar.toArrayList();
		//alphabetic order: e f a c b d
		ListIterator<Car> iterator = sLinkedCar.iterator();
		
		try{
            // Remove is not supported for the iterator, so it should throw UnsupportedOperationException

			iterator.remove();
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
    // Additional tests for adding and removing Car objects

	@Test
	void testTestAddCar() {
		sLinkedCar.add​(a);
		sLinkedCar.add​(b);
		sLinkedCar.add​(c);
		assertEquals(c, sLinkedCar.getFirst());
		assertEquals(a, sLinkedCar.getLast());
		sLinkedCar.add​(d);
		sLinkedCar.add​(e);
		assertEquals(d, sLinkedCar.getFirst());
		assertEquals(e, sLinkedCar.getLast());
		
		assertEquals(e,sLinkedCar.retrieveLastElement());
		assertEquals(a, sLinkedCar.getLast());
	}

	@Test
	void testTestRemoveFirstCar() {
		sLinkedCar.add​(b);
		sLinkedCar.add​(c);
		assertEquals(c, sLinkedCar.getFirst());
		assertEquals(b, sLinkedCar.getLast());
		sLinkedCar.add​(a);
		assertEquals(c, sLinkedCar.getFirst());
		// remove the first
		sLinkedCar.remove​(a, comparatorCar);
		assertEquals(c, sLinkedCar.getFirst());
	}

	@Test
	void testTestRemoveEndCar() {
		sLinkedCar.add​(b);
		sLinkedCar.add​(f);
		assertEquals(b, sLinkedCar.getFirst());
		assertEquals(f, sLinkedCar.getLast());
		sLinkedCar.add​(d);
		assertEquals(f, sLinkedCar.getLast());
		//remove from the end 
		sLinkedCar.remove​(d, comparatorCar);
		assertEquals(f, sLinkedCar.getLast());
	}

	@Test
	void testTestRemoveMiddleCar() {
		sLinkedCar.add​(a);
		sLinkedCar.add​(b);
		assertEquals(b, sLinkedCar.getFirst());
		assertEquals(a, sLinkedCar.getLast());
		sLinkedCar.add​(f);
		assertEquals(b, sLinkedCar.getFirst());
		assertEquals(a, sLinkedCar.getLast());
		assertEquals(3,sLinkedCar.getSize());
		//remove from middle
		sLinkedCar.remove​(a, comparatorCar);
		assertEquals(b, sLinkedCar.getFirst());
		assertEquals(f, sLinkedCar.getLast());
		assertEquals(2,sLinkedCar.getSize());
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
			return arg0.getMake().compareTo(arg1.getMake());
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


