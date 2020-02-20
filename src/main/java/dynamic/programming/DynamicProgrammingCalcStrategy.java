package dynamic.programming;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static dynamic.programming.Util.isEven;

public class DynamicProgrammingCalcStrategy implements CalcStrategy {
    @Override
    public int calc(int n) {
        Deque<Integer> stack = calcIndexes(n);
        return calcResult(n, stack);
    }

    /**
     * "Straight" pass of dynamic programming method.
     * @param n initial index
     * @return the stack filled with indexes we need in "reverse" pass.
     */
    @SuppressWarnings("squid:S1319")
    public Deque<Integer> calcIndexes(int n) {
        Queue<Integer> toProcess = new LinkedList<>();
        Queue<Integer> toProcessTail = new CircularFifoQueue<>(4);
        toProcess.add(n);
        toProcessTail.add(n);
        Deque<Integer> processed = new LinkedList<>();
        int i;
        //noinspection ConstantConditions
        while ((i = toProcess.poll()) > 1) {
            processed.push(i);
            if (isEven(i)) {
                add(i / 2, toProcess, toProcessTail);
                add(i / 2 - 1, toProcess, toProcessTail);
            } else {
                add((i - 1) / 2, toProcess, toProcessTail);
                add((i - 1) / 2 - 1, toProcess, toProcessTail);
            }
        }
        return processed;
    }

    private void add(int next, Queue<Integer> toProcess, Queue<Integer> toProcessTail) {
        if (!toProcessTail.contains(next)) {
            toProcess.add(next);
            toProcessTail.add(next);
        }
    }

    /**
     * "Reverse" pass
     * @param n initial index
     * @param stack pre-calculated indexes during "Straight" pass
     * @return result
     */
    private int calcResult(int n, Deque<Integer> stack) {
        Map<Integer, Integer> cache = new HashMap<>((int) Math.ceil(Math.log(n)), 1);
        cache.put(0, 1);
        cache.put(1, 1);
        for (int i : stack) {
            if (isEven(i)) {
                cache.put(i, cache.get(i / 2) + cache.get(i / 2 - 1));
            } else {
                cache.put(i, cache.get((i - 1) / 2) - cache.get((i - 1) / 2 - 1));
            }
        }
        return cache.get(n);
    }
}
