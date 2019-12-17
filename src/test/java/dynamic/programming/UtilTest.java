package dynamic.programming;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static dynamic.programming.Util.isEven;

public class UtilTest {
    @Test
    public void isEvenTest() {
        assertThat(isEven(58), is(true));
        assertThat(isEven(Integer.MAX_VALUE), is(false));
        assertThat(isEven(-13), is(false));
        assertThat(isEven(Integer.MIN_VALUE), is(true));
        assertThat(isEven(0), is(true));
    }
}