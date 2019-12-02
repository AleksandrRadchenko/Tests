package codewars.kyu5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("squid:S1118")
public class MaxSubarraySum {
    static final Logger LOG = LogManager.getLogger(MaxSubarraySum.class);

    public static int sequenceVariable(int[] arr) {
        int firstPositiveIndex = getFirstPositiveIndex(arr);
        if (firstPositiveIndex == -1) {
            return 0;
        }

        int max = 0;
        for (int i = firstPositiveIndex; i < arr.length; i++) {
            int sum = arr[i];
            max = Math.max(sum, max);
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static int sequenceStack(int[] arr) {
        int firstPositiveIndex = getFirstPositiveIndex(arr);
        if (firstPositiveIndex == -1) {
            return 0;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = firstPositiveIndex; i < arr.length; i++) {
            stack.push(arr[i]);
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                stack.push(sum);
            }
        }
        return Collections.max(stack);
    }

    private static int getFirstPositiveIndex(int[] arr) {
        int firstPositiveIndex = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                firstPositiveIndex = i;
                break;
            }
        }
        return firstPositiveIndex;
    }

    static boolean sameSign(int current, int prev) {
        return prev >> 31 == current >> 31;
    }

    @SuppressWarnings("unused")
    private static void compactNumbers(int[] arr, int firstPositiveIndex, LinkedList<Integer> stack) {
        stack.push(arr[firstPositiveIndex]);
        for (int i = firstPositiveIndex + 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = stack.pop();
            if (sameSign(current, prev)) {
                stack.push(prev + current);
            } else {
                stack.push(current);
            }
        }
        LOG.info(stack::toString);
    }
}
