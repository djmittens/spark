package me.ngrid.math;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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

    /**
     * A Fixture for testing a postfix expression
     */
    private String postfixFixture(String expr){
        return Arrays.toString(
                PostfixCalculator.getPostfixNotation(expr.toCharArray())
                        .toArray());
    }

    @Test
    public void testPostfixNotation() {
        assertEquals("[1.0, 2.0, +, 3.0, +]", postfixFixture("1+2+3"));
        assertEquals("[1.0, 2.0, 3.0, *, +, 4.0, -, 100.2, 10.0, %, 44.3, /, +]",
                postfixFixture("1+2*3-4+100.2%10/44.3"));
        assertEquals("[1.0, 2.0, 3.0, *, 4.0, %, +]", postfixFixture("1+2*3%4"));
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
        assertEquals(6d, calculator.evaluate("2 + 2 * 2"), 0.000_001d);
        assertEquals(9d, calculator.evaluate("3 % 4 + 2 + 2 * 2"), 0.000_001d);
        assertEquals(7.7832775367d, calculator.evaluate("3 % 4 + 8.0129292 / 10.23 + 2 * 2"), 0.000_001d);
    }
}