package dynamic.programming;

import static dynamic.programming.Util.isEven;

public class ConsecutiveCalcStrategy implements CalcStrategy {
    @Override
    public int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] preCalc = new int[n + 1];
        preCalc[1] = preCalc[0] = 1;
        for (int i = 2; i <= n; i++) {
            if (isEven(i)) {
                preCalc[i] = preCalc[i / 2] + preCalc[i / 2 - 1];
            } else {
                preCalc[i] = preCalc[(i - 1) / 2] - preCalc[(i - 1) / 2 - 1];
            }
        }
        return preCalc[n];
    }
}
