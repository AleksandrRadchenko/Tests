package p200217_radix_sort;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class Sorter<T> {
    private final SortingStrategy<T> sortingStrategy;

    public Collection<T> sort(Collection<T> col) {
      return sortingStrategy.sort(col);
    }

    public List<T> sort(List<T> col) {
      return sortingStrategy.sort(col);
    }
}
