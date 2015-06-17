package me.ngrid.math;

/**
 * A Calculator is something that can evaluate mathematical expressions and provide the result.
 */
public interface Calculator {
    /**
     *
     * @param expr a mathematical expression.
     *             valid inputs include operators (+, -, *, %, /, ^) and follow operator precedence
     * @return
     */
    double evaluate(String expr);
}
