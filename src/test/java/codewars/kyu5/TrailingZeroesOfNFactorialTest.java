package codewars.kyu5;

import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("AccessStaticViaInstance")
public class TrailingZeroesOfNFactorialTest {
    private TrailingZeroesOfNFactorial classUnderTest = new TrailingZeroesOfNFactorial();

    @Test
    public void zeroes() {
        assertThat(classUnderTest.zeros(Integer.MAX_VALUE), is(536870902));
        assertThat(classUnderTest.zeros(Integer.MAX_VALUE/2), is(268435446));
        assertThat(classUnderTest.zeros(1000000000), is(249999998));
        assertThat(classUnderTest.zeros(200000), is(49998));
        assertThat(classUnderTest.zeros(12), is(2));
        assertThat(classUnderTest.zeros(6), is(1));
        assertThat(classUnderTest.zeros(1), is(0));
    }

    @Test
    public void countFactorial() {
        assertThat(classUnderTest.countFactorialNaive(1), is(BigInteger.valueOf(1)));
        assertThat(classUnderTest.countFactorialNaive(6), is(BigInteger.valueOf(720)));
        assertThat(classUnderTest.countFactorialNaive(12), is(BigInteger.valueOf(479001600)));

    }
}

