package dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Вычислить n-й член последовательности, заданной формулами:
 * a2n = an ­+ an-1,
 * a2n+1 = an – an-1,
 * a0 = a1 = 1.
 */
public class SeqElemCalc {
    private static final int NIL = Integer.MIN_VALUE;

    static int calcDynamicallyWithArrayAsCache(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, NIL);
        return calcDynWithArrayAsCache(n, cache);
    }

    private static int calcDynWithArrayAsCache(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (cache[n] == NIL) {
            if (isEven(n)) {
                cache[n] = calcDynWithArrayAsCache(n / 2, cache) + calcDynWithArrayAsCache(n / 2 - 1, cache);
            } else {
                cache[n] = calcDynWithArrayAsCache((n - 1) / 2, cache) - calcDynWithArrayAsCache((n - 1) / 2 - 1, cache);
            }
        }
        return cache[n];
    }

    static int calcDynamicallyWithMapAsCache(int n) {
        Map<Integer, Integer> cache = new HashMap<>((int) Math.floor(Math.log(n)), 1);
        return calcDynWithMapAsCache(n, cache);
    }

    private static int calcDynWithMapAsCache(int n, Map<Integer, Integer> cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!cache.containsKey(n)) {
            if (isEven(n)) {
                cache.put(n, calcDynWithMapAsCache(n / 2, cache) + calcDynWithMapAsCache(n / 2 - 1, cache));
            } else {
                cache.put(n, calcDynWithMapAsCache((n - 1) / 2, cache) - calcDynWithMapAsCache((n - 1) / 2 - 1, cache));
            }
        }
        return cache.get(n);
    }

    static int calcReqursively(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (isEven(n)) {
            return calcReqursively(n / 2) + calcReqursively(n / 2 - 1);
        } else {
            return calcReqursively((n - 1) / 2) - calcReqursively((n - 1) / 2 - 1);
        }
    }

    static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
