package codewars.kyu5;

import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("squid:S1118")
public class MaxSubarraySum {
    public static int usingPartialSums(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int ans = arr[0];
        int sum = 0;
        int minSum = 0;
        for (int value : arr) {
            sum += value;
            ans = Math.max(ans, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return ans;
    }

    public static int naiveUsingVariable(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            max = Math.max(sum, max);
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static int naiveUsingStack(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                stack.push(sum);
            }
        }
        return Collections.max(stack);
    }
}
