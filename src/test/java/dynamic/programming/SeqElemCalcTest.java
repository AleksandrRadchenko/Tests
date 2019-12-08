package dynamic.programming;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SeqElemCalcTest {
    int[] args = {33554432};
    int[] expected = {4097};
//    int[] args = {5, 20, 21, 123456, 33554432};
//    int[] expected = {1, 7, 1, 143, 4097};

    @Test
    public void calcRequrve() {
        for (int i = 0; i < args.length; i++) {
            assertThat(SeqElemCalc.calcReqursively(args[i]), is(expected[i]));
        }
    }

    @Test
    public void calcDynamicallyWithArrayAsCache() {
        for (int i = 0; i < args.length; i++) {
            assertThat(SeqElemCalc.calcDynamicallyWithArrayAsCache(args[i]), is(expected[i]));
        }
    }

    @Test
    public void calcDynamicallyWithMapAsCache() {
        for (int i = 0; i < args.length; i++) {
            assertThat(SeqElemCalc.calcDynamicallyWithMapAsCache(args[i]), is(expected[i]));
        }
    }

    @Test
    public void isEven() {
        assertThat(SeqElemCalc.isEven(58), is(true));
        assertThat(SeqElemCalc.isEven(Integer.MAX_VALUE), is(false));
        assertThat(SeqElemCalc.isEven(-13), is(false));
        assertThat(SeqElemCalc.isEven(Integer.MIN_VALUE), is(true));
        assertThat(SeqElemCalc.isEven(0), is(true));
    }
}