package com.tyss;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.com.tyss.LoanService;

public class LoanServiceTest {

    LoanService ls = new LoanService();

    @Test
    public void validEligibility() {
        assertTrue(ls.isEligible(22, 26000));
    }

    @Test
    public void invalidAge() {
        assertFalse(ls.isEligible(20, 27000));
    }

    @Test
    public void invalidSalary() {
        assertFalse(ls.isEligible(30, 20000));
    }

    @Test
    public void validemi() {
        double EMI = ls.calculateEMI(120000, 1);
        assertEquals(10000, EMI);
    }

    @Test
    public void invalidLoanAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            ls.calculateEMI(0, 5);
        });
    }

    @Test
    public void invalidTenure() {
        assertThrows(IllegalArgumentException.class, () -> {
            ls.calculateEMI(50000, 0);
        });
    }

    @Test
    public void testpremium() {
        assertEquals("Premium", ls.getLoanCategory(800));
    }

    @Test
    public void testStandardCategory() {
        assertEquals("Standard", ls.getLoanCategory(700));
    }

    @Test
    public void testHighRiskCategory() {
        assertEquals("High Risk", ls.getLoanCategory(500));
    }

    @Test
    public void testNotNull() {
        assertNotNull(ls.getLoanCategory(750));
    }

    @Test
    public void testBoundaryAge() {
        assertAll(
            () -> assertTrue(ls.isEligible(21, 25000)),
            () -> assertTrue(ls.isEligible(60, 25000))
        );
    }
}
