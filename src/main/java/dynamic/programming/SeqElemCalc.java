package dynamic.programming;

import lombok.RequiredArgsConstructor;

/**
 * Вычислить n-й член последовательности, заданной формулами:
 * a2n = an ­+ an-1,
 * a2n+1 = an – an-1,
 * a0 = a1 = 1.
 */
@RequiredArgsConstructor
public class SeqElemCalc {
    private final CalcStrategy strategy;

    public int calc(int n) {
        return strategy.calc(n);
    }
}
