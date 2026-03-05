package com.tyss;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

import main.com.tyss.StudentServ;
public class StudentservTest {

		// TODO Auto-generated method stub
		StudentServ ss = new StudentServ();
		
		@Test
		public void testEquals() {
			assertEquals("Distinction", ss.calculateGrade(80));
			
		}
		@Test
		public void testEquals2() {
			assertEquals("Fail", ss.calculateGrade(45));

		}
		@Test
		public void testEquals3() {
			assertEquals("Second Class",ss.calculateGrade(56));
		}
		@Test
		public void testTrue() {
			assertTrue(ss.isPassed(75));
		}
		@Test
		public void testFalse() {
			assertFalse(ss.isPassed(45));
		}
		@Test
		public void testInvalidInput() {
			assertThrows(IllegalArgumentException.class , 
					()-> {ss.calculateGrade(-10);
					});	
		}
		
		@Test
		public void testInvalidInput2() {
			assertThrows(IllegalArgumentException.class,
					()-> {ss.calculateGrade(120);}
					);
		}
		
		
		


}
