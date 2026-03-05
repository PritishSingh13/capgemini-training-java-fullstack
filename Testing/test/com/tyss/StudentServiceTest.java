package com.tyss;


import org.junit.Test;
import static org.junit.Assert.*;
import main.com.tyss.StudentService;


public class StudentServiceTest {
	StudentService ss = new StudentService() ;
	@Test
	public void testassertTrue() {
		assertTrue(ss.isEligible(18));
	}
	@Test
	public void testassertFalse() {
		assertFalse(ss.isEligible(17));
	}
	@Test
	public void testassertEquals() {
		assertEquals(ss.isEligible(18),ss.isEligible(19));
	}
	@Test
	public void testassertNotEquals() {
		assertNotEquals(ss.isEligible(17),ss.isEligible(19));
	}
	@Test
	public void testassertNotNull() {
		assertNotNull(ss.isEligible(20));
	}
	@Test
	public void testassertSame() {
		assertSame(ss.isEligible(20),ss.isEligible(20));
	}
	@Test
	public void testassertNotSame() {
		assertNotSame(ss.isEligible(19), ss.isEligible(17));
	}
//	@Test
//	public void testassertAll() {
//		testassertAll();
//	}
	@Test
	public void testThrows() {
		assertThrows(ArithmeticException.class, () -> {
			ss.isEligible(0);
		});
	}
//	@Test
//	public void testFail() {
//		fail();
//	}
}
