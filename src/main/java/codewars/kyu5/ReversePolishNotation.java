package codewars.kyu5;

import java.util.LinkedList;
import java.util.function.DoubleBinaryOperator;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse Polish notation.
 * <p>
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2) * 4) - 3
 * in normal notation) should evaluate to 14.
 * <p>
 * For your convenience, the input is formatted such that
 * a space is provided between every token.
 * <p>
 * Empty expression should evaluate to 0.
 * <p>
 * Valid operations are +, -, *, /.
 * <p>
 * You may assume that there won't be exceptional situations
 * (like stack underflow or division by zero).
 * <p>
 * https://www.codewars.com/kata/reverse-polish-notation-calculator/train/java
 */
public class ReversePolishNotation {

    public double evaluate(String expr) {
        if (expr.isBlank()) {
            return 0d;
        }
        String[] tokens = expr.split(" ");
        LinkedList<Double> operands = new LinkedList<>();
        for (String token : tokens) {
            Operator operator = parseForOperator(token);
            if (Operator.OPERAND.equals(operator)) {
                operands.push(Double.parseDouble(token));
            } else {
                Double right = operands.pop();
                Double left = operands.pop();
                operands.push(operator.apply(left, right));
            }
        }
        return operands.pop();
    }

    private Operator parseForOperator(String s) {
        if (Operator.SUM.literal.equals(s)) {
            return Operator.SUM;
        } else if (Operator.MULT.literal.equals(s)) {
            return Operator.MULT;
        } else if (Operator.SUBTR.literal.equals(s)) {
            return Operator.SUBTR;
        } else if (Operator.DIV.literal.equals(s)) {
            return Operator.DIV;
        } else {
            return Operator.OPERAND;
        }
    }

    public enum Operator {
        SUM("+", Double::sum),
        MULT("*", (double l, double r) -> l * r),
        SUBTR("-", (double l, double r) -> l - r),
        DIV("/", (double l, double r) -> l / r),
        OPERAND("operand", (double l, double r) -> {throw new IllegalArgumentException("this is operand");});

        protected final String literal;
        protected final DoubleBinaryOperator operation;

        Operator(String literal, DoubleBinaryOperator operation) {
            this.literal = literal;
            this.operation = operation;
        }

        public double apply(double left, double right) {
            return this.operation.applyAsDouble(left, right);
        }
    }
}
