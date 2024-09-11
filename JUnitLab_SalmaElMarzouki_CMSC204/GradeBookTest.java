import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook gb01;
	GradeBook gb02;
	GradeBook gb03;
	GradeBook gb04;
	@BeforeEach
	void setUp() throws Exception {
		gb01 = new GradeBook(5);
		gb02 = new GradeBook(5);
		gb03 = new GradeBook(5);
		gb04 = new GradeBook(5);
		gb01.addScore(85.7);
		gb01.addScore(47.3);
		gb01.addScore(39.7);
		gb01.addScore(89.99);
		
		gb02.addScore(76.3);
		gb02.addScore(20.0);	
		
		//gb03 with a single element to display the result of that one item
		gb03.addScore(55.3);
		
		//gb04 with no elements to demonstrate that the finalScore method returns 0
	}

	@AfterEach
	void tearDown() throws Exception {
		gb01 = gb02 = gb03 = gb04 = null;
	}

	@Test
	void testAddScore() {
		//Verifies if converting each created object to a string matches the numbers in the scores array
		assertTrue(gb01.toString().equals("85.7 47.3 39.7 89.99 "));
		assertTrue(gb02.toString().equals("76.3 20.0 "));
		assertTrue(gb03.toString().equals("55.3 "));
		assertTrue(gb04.toString().equals(""));
	}

	@Test
	void testSum() {
		assertEquals(262.69, gb01.sum(),.0001);
		assertEquals(96.3, gb02.sum(),.0001);
		assertEquals(55.3, gb03.sum(),.0001);
		assertEquals(0.0, gb04.sum(),.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(39.7,gb01.minimum(),.001);
		assertEquals(20.0,gb02.minimum(),.001);
		assertEquals(55.3,gb03.minimum(),.001);
		assertEquals(0.0,gb04.minimum(),.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(222.99,gb01.finalScore());
		assertEquals(76.3,gb02.finalScore());
		assertEquals(55.3,gb03.finalScore());
		assertEquals(0,gb04.finalScore());
	}

}
