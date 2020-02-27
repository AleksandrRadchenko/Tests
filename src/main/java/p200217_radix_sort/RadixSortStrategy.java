package p200217_radix_sort;

import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.Collection;
import java.util.List;

public class RadixSortStrategy implements SortingStrategy<Integer> {
    private static final int RADIX = 10;

    @Override
    public List<Integer> sort(List<Integer> col) {
        return (List<Integer>) sort((Collection<Integer>) col);
    }

    @Override
    public Collection<Integer> sort(Collection<Integer> col) {
        int power = col.size();
        IntArrayList elements = new IntArrayList(col);
        IntArrayList[] buckets = createBuckets(power);
        boolean onlyFirstBucketUsed = false;
        int radix = 1;
        while (!onlyFirstBucketUsed && radix <= RADIX) {
            onlyFirstBucketUsed = to(buckets, elements, radix);
            elements = from(buckets, power);
            radix++;
        }
        return elements;
    }

    private IntArrayList[] createBuckets(int size) {
        IntArrayList[] buckets = new IntArrayList[RADIX];
        for (int i = 0; i < RADIX; i++) {
            buckets[i] = new IntArrayList(size);
        }
        return buckets;
    }

    private boolean to(IntArrayList[] buckets, IntArrayList elements, int radix) {
        boolean onlyFirstBucketUsed = true;
        for (int i = 0; i < elements.size(); i++) {
            int number = elements.getInt(i);
            int bucket = getDigitByRadix(number, radix);
            buckets[bucket].add(number);
            if (bucket > 0) {
                onlyFirstBucketUsed = false;
            }
        }
        elements.clear();
        return onlyFirstBucketUsed;
    }

    private IntArrayList from(IntArrayList[] buckets, int power) {
        int index = 0;
        int[] elementsArray = new int[power];
        for (IntArrayList bucket : buckets) {
            System.arraycopy(bucket.toIntArray(), 0, elementsArray, index, bucket.size());
            index += bucket.size();
            bucket.clear();
        }
        return new IntArrayList(elementsArray);
    }

    private static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static int getDigitByRadix(int digit, int radix) {
        if (radix > RADIX) {
            throw new IllegalArgumentException("There can't be more than " + RADIX + " digits in the number");
        }
        return (digit / powerOfTen(radix - 1)) % 10;
    }

    private static int powerOfTen(int pow) {
        if (pow > 10) {
            throw new IllegalArgumentException("power exceeds int capacity");
        }
        return POWERS_OF_10[pow];
    }
}
