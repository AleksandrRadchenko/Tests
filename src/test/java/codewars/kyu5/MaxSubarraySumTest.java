package codewars.kyu5;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxSubarraySumTest {
    @Test
    public void usingPartialSums() {
        int[] arr = {};
        assertThat(MaxSubarraySum.usingPartialSums(arr), is(0));
        assertThat(MaxSubarraySum.usingPartialSums(new int[]{-2, -3, -1, -5}), is(-1)); // all negative
        assertThat(MaxSubarraySum.usingPartialSums(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6)); // should be 6: {4, -1, 2, 1}
        assertThat(MaxSubarraySum.usingPartialSums(new int[]{-3, 4, -1, 2, 1, -5, 4}), is(6));
        assertThat(MaxSubarraySum.usingPartialSums(new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 2, 5}), is(7));
    }

    @Test
    public void naiveUsingVariable() {
        int[] arr = {};
        assertThat(MaxSubarraySum.naiveUsingVariable(arr), is(0));
        assertThat(MaxSubarraySum.naiveUsingVariable(new int[]{-2, -3, -1, -5}), is(-1)); // all negative
        assertThat(MaxSubarraySum.naiveUsingVariable(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6)); // should be 6: {4, -1, 2, 1}
        assertThat(MaxSubarraySum.naiveUsingVariable(new int[]{-3, 4, -1, 2, 1, -5, 4}), is(6));
        assertThat(MaxSubarraySum.naiveUsingVariable(new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 2, 5}), is(7));
    }

    @Test
    public void naiveUsingStack() {
        int[] arr = {};
        assertThat(MaxSubarraySum.naiveUsingStack(arr), is(0));
        assertThat(MaxSubarraySum.naiveUsingStack(new int[]{-2, -3, -1, -5}), is(-1)); // all negative
        assertThat(MaxSubarraySum.naiveUsingStack(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), is(6)); // should be 6: {4, -1, 2, 1}
        assertThat(MaxSubarraySum.naiveUsingStack(new int[]{-3, 4, -1, 2, 1, -5, 4}), is(6));
        assertThat(MaxSubarraySum.naiveUsingStack(new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 2, 5}), is(7));
    }
}