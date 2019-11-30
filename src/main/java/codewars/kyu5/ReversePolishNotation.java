package codewars.kyu5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
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
        List<String> tokens = new LinkedList<>(Arrays.asList(expr.split(" ")));
        ListIterator<String> iterator = tokens.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            Operator parsed = parseForOperator(next);
            if (!Operator.NOT_OPERATOR.equals(parsed)) {
                iterator.remove();
                double right = Double.parseDouble(iterator.previous());
                iterator.remove();
                double left = Double.parseDouble(iterator.previous());
                iterator.remove();
                double result = parsed.apply(left, right);
                iterator.add(String.valueOf(result));
            }
        }
        return Double.parseDouble(iterator.previous());
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
