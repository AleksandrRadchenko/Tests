package codewars.kyu5;

import org.apache.log4j.Logger;

import java.math.BigInteger;

/**
 * Number of trailing zeros of N!
 * https://www.codewars.com/kata/number-of-trailing-zeros-of-n/train/java
 */
public class TrailingZeroesOfNFactorial {
    public static final Logger LOG = Logger.getLogger(TrailingZeroesOfNFactorial.class);
    private static int zeros(int n) {
        int accumulator = 0;
        for (int i = n; i > 4; i--) {
            accumulator = accumulator + countZerosAddedByLastMultiplier(n);
            n = n - 1;
        }
        return accumulator;
    }

    static int countZerosAddedByLastMultiplier(int n) {
        int zeroes = 0;
        if (n % 10 == 0) {
            zeroes++;
            n = n / 10;
        } else if (n % 5 == 0) {
            zeroes++;
            n = n / 5;
        } else {
            return 0;
        }
        return zeroes + countZerosAddedByLastMultiplier(n);
    }

    public static void main(String[] args) {
        LOG.info(zeros(0));
        LOG.info(zeros(6));
        LOG.info(zeros(Integer.MAX_VALUE));
    }

    public void countFactorial() {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 2; i < 101; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
            LOG.info("multiplier = "
                    + String.format("%1$3d", i)
                    + ", fact = "
                    + String.format("%1$170d", fact));
        }
    }
}
