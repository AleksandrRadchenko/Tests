package codewars.kyu5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxSubarraySumTest {
    @Test
    public void sequence() {
        int[] arr = {};
        assertThat(MaxSubarraySum.usingVariable(arr), is(0));
        assertThat(MaxSubarraySum.usingVariable(new int[]{-2, -3, -1, -5}), is(0)); // all negative
        assertThat(MaxSubarraySum.usingVariable(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6)); // should be 6: {4, -1, 2, 1}
        assertThat(MaxSubarraySum.usingVariable(new int[]{-3, 4, -1, 2, 1, -5, 4}), is(6));
        assertThat(MaxSubarraySum.usingVariable(new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 2, 5}), is(7));
    }

    @Test
    public void sameSign() {
        assertThat(MaxSubarraySum.sameSign(Integer.MAX_VALUE, Integer.MAX_VALUE), is(true));
        assertThat(MaxSubarraySum.sameSign(Integer.MIN_VALUE, Integer.MIN_VALUE), is(true));
        assertThat(MaxSubarraySum.sameSign(-6, -5), is(true));
        assertThat(MaxSubarraySum.sameSign(4, 2), is(true));
        assertThat(MaxSubarraySum.sameSign(-4, 2), is(false));
        assertThat(MaxSubarraySum.sameSign(-4, 0), is(false));
        assertThat(MaxSubarraySum.sameSign(4, 0), is(true));
    }
}