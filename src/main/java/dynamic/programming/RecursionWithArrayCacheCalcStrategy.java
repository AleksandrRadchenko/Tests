package dynamic.programming;

import java.util.Arrays;

import static dynamic.programming.Util.isEven;

public class RecursionWithArrayCacheCalcStrategy implements CalcStrategy {
    private static final int NIL = Integer.MIN_VALUE;

    @Override
    public int calc(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, NIL);
        return calcRecursively(n, cache);
    }

    private int calcRecursively(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] == NIL) {
            if (isEven(n)) {
                cache[n] = calcRecursively(n / 2, cache) + calcRecursively(n / 2 - 1, cache);
            } else {
                cache[n] = calcRecursively((n - 1) / 2, cache) - calcRecursively((n - 1) / 2 - 1, cache);
            }
        }
        return cache[n];
    }
}
