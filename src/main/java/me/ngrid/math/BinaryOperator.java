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

    /**
     * Return an operator matching the character
     * @param c character for which we need the operator.
     * @return the operator or null if its not one.
     */
    static BinaryOperator getOperator(char c){
        switch(c) {
            case('%'):
                return new Modulo();
            case('*'):
                return new Multiply();
            case('+'):
                return new Plus();
            case('-'):
                return new Minus();
            default:
                return null;
        }
    }

    class Multiply implements BinaryOperator {

        @Override
        public int getPrecedence() {
            return 3;
        }

        @Override
        public double apply(double left, double right) {
            return left * right;
        }
    }

    class Divide implements BinaryOperator {

        @Override
        public int getPrecedence() {
            return 3;
        }

        @Override
        public double apply(double left, double right) {
            return left / right;
        }
    }

    class Modulo implements BinaryOperator {

        @Override
        public int getPrecedence() {
            return 3;
        }

        @Override
        public double apply(double left, double right) {
            return left % right;
        }
    }

    class Minus implements BinaryOperator {

        @Override
        public int getPrecedence() {
            return 2;
        }

        @Override
        public double apply(double left, double right) {
            return left - right;
        }
    }

    class Plus implements BinaryOperator {

        @Override
        public int getPrecedence() {
            return 2;
        }

        @Override
        public double apply(double left, double right) {
            return left + right;
        }
    }
}

