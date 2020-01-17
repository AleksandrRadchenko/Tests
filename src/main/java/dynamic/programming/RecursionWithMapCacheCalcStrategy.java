package dynamic.programming;

import java.util.HashMap;
import java.util.Map;

import static dynamic.programming.Util.isEven;

public class RecursionWithMapCacheCalcStrategy implements CalcStrategy {
    @Override
    public int calc(int n) {
        Map<Integer, Integer> cache = new HashMap<>((int) Math.ceil(Math.log(n)), 1);
        return calcRecursively(n, cache);
    }

    private int calcRecursively(int n, Map<Integer, Integer> cache) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!cache.containsKey(n)) {
            if (isEven(n)) {
                cache.put(n, calcRecursively(n / 2, cache) + calcRecursively(n / 2 - 1, cache));
            } else {
                cache.put(n, calcRecursively((n - 1) / 2, cache) - calcRecursively((n - 1) / 2 - 1, cache));
            }
        }
        return cache.get(n);
    }
}
