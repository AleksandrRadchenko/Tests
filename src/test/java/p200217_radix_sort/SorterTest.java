package p200217_radix_sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SorterTest {

    private List<Integer> original1 = Arrays.asList(5, 2, 3, 1, 5, 0, 9);
    private List<Integer> sorted1 = Arrays.asList(0, 1, 2, 3, 5, 5, 9);
    private List<Integer> original2 = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 4);
    private List<Integer> sorted2 = Arrays.asList(Integer.MAX_VALUE - 4, Integer.MAX_VALUE - 3, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    private static final int SIZE = 100000;
    private static final List<Integer> ORIGINAL =
            new Random().ints(SIZE, 0, Integer.MAX_VALUE)
                        .boxed()
                        .collect(Collectors.toList());
    private static final List<Integer> SORTED = new ArrayList<>(ORIGINAL);
    static {
        Collections.sort(SORTED);
    }

    @Test
    public void sortRadixTest() {
        Sorter<Integer> sorter = new Sorter<>(new RadixSortStrategy());
        assertThat(sorter.sort(original1)).isEqualTo(sorted1);
        assertThat(sorter.sort(original2)).isEqualTo(sorted2);
        assertThat(sorter.sort(ORIGINAL)).isEqualTo(SORTED);
    }

    @Test
    public void sortJDKTest() {
        Sorter<Integer> sorter = new Sorter<>(new JDKSortStrategy());
        assertThat(sorter.sort(original1)).isEqualTo(sorted1);
        assertThat(sorter.sort(original2)).isEqualTo(sorted2);
        assertThat(sorter.sort(ORIGINAL)).isEqualTo(SORTED);
    }

    @Test
    public void binaryInsertionSortTest() {
        Sorter<Integer> sorter = new Sorter<>(new BinaryInsertionSortStrategy());
        assertThat(sorter.sort(original1)).isEqualTo(sorted1);
        assertThat(sorter.sort(original2)).isEqualTo(sorted2);
        assertThat(sorter.sort(ORIGINAL)).isEqualTo(SORTED);
    }
}