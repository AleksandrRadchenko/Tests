package p200217_radix_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RadixSortProfiling {
    private static final int SIZE = 1000000;
    private static final List<Integer> ORIGINAL =
            new Random().ints(SIZE, 0, Integer.MAX_VALUE)
                        .boxed()
                        .collect(Collectors.toList());
    private static final List<Integer> SORTED = new ArrayList<>(ORIGINAL);
    static {
        Collections.sort(SORTED);
    }

    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<>(new RadixSortStrategy());
        List<Integer> sorted = sorter.sort(ORIGINAL);
        System.out.println(sorted.size());
    }
}
