package me.ngrid.math;

import me.ngrid.math.Calculator;
import me.ngrid.math.PostfixCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class PostfixCalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = PostfixCalculator.getInstance();
    }
    @Test
    public void test2plus2 () throws Exception  {
        assertEquals("Algorithm cant add 2+2 lame...",
                4d, calculator.evaluate("2+2"), 0.000_001d);
        assertEquals("Algorithm cant add 2+2, with spaces lame...",
                4d, calculator.evaluate("2 + 2 "), 0.000_001d);
    }

    @Test
    public void testOperatorPrecedence () throws Exception {
        assertEquals(8d, calculator.evaluate("2 + 2 * 2"), 0.000_001d);
        assertEquals(9d, calculator.evaluate("3 % 4 + 2 + 2 * 2"), 0.000_001d);
    }
}