package maths;

import java.util.ArrayList;
import java.util.List;

public class SimpleMultipliers {
    public static void main(String[] args) {
        System.out.println(primeFactorization(6));
    }

    public static List<Integer> primeFactorization(int number) {
        List<Integer> list = new ArrayList<>();
        for (int factor = 2; factor < Math.sqrt(number); ++factor) {
            while (number % factor == 0) {
                list.add(factor);
                number /= factor;
            }
        }
        list.add(number);
        return list;
    }
}
