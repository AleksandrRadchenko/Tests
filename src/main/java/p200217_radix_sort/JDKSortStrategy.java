package p200217_radix_sort;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JDKSortStrategy implements SortingStrategy<Integer> {
    @Override
    public Collection<Integer> sort(Collection<Integer> col) {
        throw new UnsupportedOperationException("JDK doesn't support Collection sorting");
    }

    @Override
    public List<Integer> sort(List<Integer> col) {
        Collections.sort(col);
        return col;
    }
}
