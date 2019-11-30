package codewars.kyu5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReversePolishNotationTest {

    private final ReversePolishNotation calc = new ReversePolishNotation();

    @Test
    public void evaluate() {
        assertThat(calc.evaluate("5 1 2 + 4 * + 3 -"), is(14d));
        assertThat(calc.evaluate("5 1 -"), is(4d));
        assertThat(calc.evaluate(""), is(0d));
    }

    @Test
    public void testOperand() {
        assertThat(ReversePolishNotation.Operator.SUM.apply(2, 3), is(5d));
        assertThat(ReversePolishNotation.Operator.MULT.apply(2, 3), is(6d));
        assertThat(ReversePolishNotation.Operator.SUBTR.apply(2, 3), is(-1d));
        assertThat(ReversePolishNotation.Operator.DIV.apply(2, 3), is(2.0/3));
    }
}