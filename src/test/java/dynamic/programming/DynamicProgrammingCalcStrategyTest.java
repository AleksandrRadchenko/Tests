package dynamic.programming;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DynamicProgrammingCalcStrategyTest {
    private DynamicProgrammingCalcStrategy strategy = new DynamicProgrammingCalcStrategy();

    @Test
    public void calcIndexes() {
        assertThat(strategy.calcIndexes(5), is(List.of(2, 5)));
        assertThat(strategy.calcIndexes(20), is(List.of(2, 3, 4, 5, 9, 10, 20)));
        assertThat(strategy.calcIndexes(21), is(List.of(2, 3, 4, 5, 9, 10, 21)));
    }
}