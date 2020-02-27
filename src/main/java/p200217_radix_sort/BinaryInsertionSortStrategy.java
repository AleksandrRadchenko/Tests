package p200217_radix_sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BinaryInsertionSortStrategy implements SortingStrategy<Integer> {
    @Override
    public List<Integer> sort(List<Integer> col) {
        return (List<Integer>) sort((Collection<Integer>) col);
    }

    @Override
    public Collection<Integer> sort(Collection<Integer> col) {
        if (col.size() < 2) {
            return col;
        }
        Integer[] elements = col.toArray(new Integer[0]);
        for (int i = 1; i < elements.length; i++) {
            int lo = 0;
            int hi = i - 1;
            Integer current = elements[i];
            lo = insert(elements, i, lo, hi, current);
            elements[lo] = current;
        }
        return Arrays.asList(elements);
    }

    private int insert(Integer[] elements, int i, int lo, int hi, Integer current) {
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (current < elements[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.arraycopy(elements, lo, elements, lo + 1, i - lo);
        return lo;
    }

}
