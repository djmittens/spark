package me.ngrid.math;

/**
 * A calculator can evaluate an expression represented as a {@code String}.
 * This particular implementation uses Shunting - Yard algorithm to build postfix notation(Reverse Polish)
 * and then evaluates the expression.
 *
 * Performance of the postfix algorithm is O(n), and evaluation is the same therefore performance overall is
 * O(n).
 *
 * @see <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation#Postfix_algorithm">Reverse Polish Notation</a>
 * @see <a href="https://en.wikipedia.org/wiki/Shunting-yard_algorithm">Shunting-Yard</a>
 */

public class PostfixCalculator implements Calculator {

    private void build() {}

    @Override
    public double evaluate(String expr) {
        return Double.NaN;
    }

    public static Calculator getInstance() {
        return new PostfixCalculator();
    }
}
