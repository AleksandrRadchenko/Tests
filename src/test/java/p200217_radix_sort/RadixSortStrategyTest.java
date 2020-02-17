package p200217_radix_sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RadixSortStrategyTest {

    @Test
    public void getDigitByIndex() {
        assertThat(RadixSortStrategy.getDigitByIndex(11254, 2)).isEqualTo(2);
        assertThat(RadixSortStrategy.getDigitByIndex(99521377, 0)).isEqualTo(7);
        assertThat(RadixSortStrategy.getDigitByIndex(99521377, 3)).isEqualTo(1);
        assertThat(RadixSortStrategy.getDigitByIndex(69521377, 7)).isEqualTo(6);
        assertThat(RadixSortStrategy.getDigitByIndex(2069521377, 9)).isEqualTo(2);
    }
}