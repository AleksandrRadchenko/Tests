package codewars.kyu5;

import java.math.BigInteger;

/**
 * Number of trailing zeros of N!
 * https://www.codewars.com/kata/number-of-trailing-zeros-of-n/train/java
 */
public class TrailingZeroesOfNFactorial {
    static int zeros(int n) {
        int zeroes = 0;
        // Use long to evade integer overflow for big n
        for (long i = 5; n > i; i = i * 5) {
            zeroes = zeroes + (n / (int) i);
        }
        return zeroes;
    }

    @SuppressWarnings({"unused", "squid:S106"})
    public BigInteger countFactorialNaive(int n) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            System.out.println("multiplier = "
                    + String.format("%1$3d", i)
                    + ", fact = "
                    + String.format("%1$50d", fact));
        }
        return fact;
    }
}
