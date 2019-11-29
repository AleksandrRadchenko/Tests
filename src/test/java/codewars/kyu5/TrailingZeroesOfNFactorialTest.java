package codewars.kyu5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.core.Is.is;

@SuppressWarnings("AccessStaticViaInstance")
public class TrailingZeroesOfNFactorialTest {
    private TrailingZeroesOfNFactorial classUnderTest = new TrailingZeroesOfNFactorial();

    @Test
    public void countZerosAddedByLastMultiplier() {
        Assert.assertThat(classUnderTest.countZerosAddedByLastMultiplier(24), is(0));
        Assert.assertThat(classUnderTest.countZerosAddedByLastMultiplier(5), is(1));
        Assert.assertThat(classUnderTest.countZerosAddedByLastMultiplier(10), is(1));
    }
}

