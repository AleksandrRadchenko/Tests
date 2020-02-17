package p200217_radix_sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSortStrategy implements SortingStrategy<Integer> {
    static int radix = 10;
    private List<List<Integer>> buckets = new ArrayList<>(radix);

    public RadixSortStrategy() {
        for (int i = 0; i < radix; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    @Override
    public Collection<Integer> sort(Collection<Integer> col) {
        Queue<Integer> c = new LinkedList<>(col);
        boolean areNonZeroDigits = true;
        int digitIndex = 0;
        while (areNonZeroDigits) {
            areNonZeroDigits = toBuckets(c, digitIndex);
            digitIndex++;
            fromBuckets(c);
        }
        return c;
    }

    private boolean toBuckets(Queue<Integer> c, int digitIndex) {
        Integer number = c.poll();
        boolean areNonZeroDigits = false;
        while (number != null) {
            int bucket = getDigitByIndex(number, digitIndex);
            buckets.get(bucket).add(number);
            if (bucket > 0) {
                areNonZeroDigits = true;
            }
            number = c.poll();
        }
        return areNonZeroDigits && digitIndex < radix - 1;
    }

    private void fromBuckets(Queue<Integer> c) {
        for (List<Integer> bucket : buckets) {
            Iterator<Integer> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                c.add(iterator.next());
                iterator.remove();
            }
        }
    }

    private static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    private static int powerOfTen(int pow) {
        return POWERS_OF_10[pow];
    }

    public static int getDigitByIndex(Integer digit, int index) {
        if (index > radix - 1) {
            throw new IllegalArgumentException("There can't be more than 10 digits in the integer");
        }
        return (digit / powerOfTen(index)) % 10;
    }

    @Override
    public List<Integer> sort(List<Integer> col) {
        return (List<Integer>) sort((Collection<Integer>) col);
    }
}
