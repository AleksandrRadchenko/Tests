package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntListTest {
    @Test
    public void outOfBoundsTest() {
        final IntList l = new IntList();
        assertThatThrownBy(() -> l.get(2)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThat(l.size()).isEqualTo(0);
    }

    @Test
    public void addAndGetTest() {
        IntList l = new IntList();
        l.add(42);
        assertThat(l.size()).isEqualTo(1);
        assertThat(l.get(0)).isEqualTo(42);
    }

    @Test
    public void sequentialAddTest() {
        IntList l = new IntList();
        l.add(42);
        l.add(43);
        assertThat(l.size()).isEqualTo(2);
        assertThat(l.get(1)).isEqualTo(43);
    }

    @Test
    public void clearTest() {
        IntList l = new IntList();
        l.add(42);
        l.add(43);
        l.clear();
        assertThat(l.size()).isEqualTo(0);
        assertThatThrownBy(() -> l.get(0)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}