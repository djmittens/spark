package me.ngrid.math;

/**
 * An internal representation of a binary mathematical operator.
 * A binary operator is one that takes 2 parameters and provides an output.
 * eg 2 + 2 = 4.
 */
interface BinaryOperator {
    /**
     * Operator precedence rules on the order in which it is evaluated.
     * @return 2 - 4 precedence of the operator.
     */
    int getPrecedence();

    /**
     * Apply the operator over 2 operands.
     * @param left left side of the operator
     * @param right right side of the operator
     * @return the result.
     */
    double apply(double left, double right);
}

