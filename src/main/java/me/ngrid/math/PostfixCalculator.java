package me.ngrid.math;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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

    @Override
    public double evaluate(String expr) {
        expr = expr.replaceAll(" ", "");
        Queue<Object> postfix = getPostfixNotation(expr.toCharArray());

        // Answer stack.
        Deque<Double> buf = new ArrayDeque<>();
        Object tmp;
        // now that we have postfix notation evaluate !;
        while(!postfix.isEmpty()) {
            tmp = postfix.poll();

            if(tmp instanceof Double) {
                buf.push((Double)tmp);
            }

            else if(tmp instanceof BinaryOperator) {
                Double op2 = buf.pop();
                Double op1 = buf.pop();

                buf.push(((BinaryOperator) tmp).apply(op1, op2));
            }
        }
        // We have to have the answer as last.
        assert(buf.size() == 1);
        return buf.pop();
    }

    /**
     * Builds the postfix notation for the given character array.
     * @param expr character array for the expression
     * @return postfix notation Queue.
     */
    static Queue<Object> getPostfixNotation(char[] expr) {
        // Operator stack.
        Deque<BinaryOperator> opStack = new ArrayDeque<>();

        // Queue -- Reverse Polish Notation
        Queue<Object> rpn = new ArrayDeque<>();

        // Buffer for number parsing.
        StringBuilder numBuf = new StringBuilder();

        // Main builder loop.
        for (char c : expr) {
            //Start off by checking if its an operator
            BinaryOperator op = BinaryOperator.getOperator(c);

            // We got an operator!
            // and we were reading a number so lets queue it up..
            if(op != null && numBuf.length() > 0) {
                rpn.add(Double.valueOf(numBuf.toString()));
                numBuf = new StringBuilder();
            }

            // We got ourselves a number, lets buffer it
            if (op == null) {
                numBuf.append(c);
            }

            // We got ourselves an operator
            else {
                // While the precedence in the stack is large keep adding operators to the output.
                while(!opStack.isEmpty()) {
                    BinaryOperator tmp = opStack.peekFirst();

                    // Pop the operator if it is stronger than the one we are trying to push.
                    if (op.getPrecedence() <= tmp.getPrecedence()) {
                        rpn.add(opStack.pop());
                    }

                    // Clearly we are the weakest now, so we are done here.
                    else {
                        break;
                    }
                }

                // Push it onto the stack.
                opStack.push(op);
            }
        }

        // Clear out remaining number inside of number buffer
        if(numBuf.length() > 0)
            rpn.add(Double.valueOf(numBuf.toString()));

        while(!opStack.isEmpty()) {
            rpn.add(opStack.pop());
        }

        return  rpn;
    }

    public static Calculator getInstance() {
        return new PostfixCalculator();
    }
}
