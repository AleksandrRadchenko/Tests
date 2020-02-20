package dynamic.programming;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeqElemCalcTest {
    @Test
    public void calcRecursively() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionCalcStrategy());
        assertions(sem);
    }

    @Test
    public void calcRecursivelyWithArrayAsCache() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionWithArrayCacheCalcStrategy());
        assertions(sem);
    }

    @Test
    public void calcRecursivelyWithMapAsCache() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionWithMapCacheCalcStrategy());
        assertions(sem);
    }

    @Test
    public void calcConsecutively() {
        SeqElemCalc sem = new SeqElemCalc(new ConsecutiveCalcStrategy());
        assertions(sem);
    }

    @Test
    public void calcDynamically() {
        SeqElemCalc sem = new SeqElemCalc(new DynamicProgrammingCalcStrategy());
        assertions(sem);
    }

    private void assertions(SeqElemCalc sem) {
        final int[] args = {33554432};
        final int[] expected = {4097};
//        final int[] args = {5, 20, 21, 123456, 33554432};
//        final int[] expected = {1, 7, 1, 143, 4097};

        for (int i = 0; i < args.length; i++) {
            assertThat(sem.calc(args[i]), is(expected[i]));
        }
    }
}