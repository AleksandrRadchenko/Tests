package dynamic.programming;

import static dynamic.programming.Util.isEven;

public class RecursionCalcStrategy implements CalcStrategy {
    @Override
    public int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (isEven(n)) {
            return calc(n / 2) + calc(n / 2 - 1);
        } else {
            return calc((n - 1) / 2) - calc((n - 1) / 2 - 1);
        }
    }
}
