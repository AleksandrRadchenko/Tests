package codewars.kyu5;

/**
 * Number of trailing zeros of N!
 * https://www.codewars.com/kata/number-of-trailing-zeros-of-n/train/java
 */
public class NumberOfTrailingZeroesOfNFactorial {
    // digits before last non zero digit does not matter
    public static int zeros(int n) {
        if (n <= 0) return 0;
        int zeroes = 0;
        int product = 1;
        for (int i = 2; i <= n; i++) {
            if (Integer.MAX_VALUE / i < product) {
                System.out.println("OVERFLOW! i=" + i + ", product=" + product);
            }
            product *= i;
            int currentProductTrailingZeroesCount = trailingZeroesCount(product);
            zeroes += currentProductTrailingZeroesCount;
            product = getTwoDigitsBeforeZeroes(product, currentProductTrailingZeroesCount);
        }
        return zeroes;
    }

    private static int trailingZeroesCount(int product) {
        if (product % 10 != 0) {
            return 0;
        } else {
            return 1 + trailingZeroesCount(product / 10);
        }
    }

    private static int getTwoDigitsBeforeZeroes(int product, int trailingZeroesCount) {
        return (product % (int) Math.pow(10L, trailingZeroesCount + 2)) / (int) Math.pow(10L, trailingZeroesCount);
    }

    public static void main(String[] args) {
        System.out.println(zeros(100000));
    }
}
