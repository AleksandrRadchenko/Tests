package p200217_radix_sort;

import java.util.Collection;
import java.util.List;

public interface SortingStrategy<T> {
    Collection<T> sort(Collection<T> col);
    List<T> sort(List<T> col);
}
