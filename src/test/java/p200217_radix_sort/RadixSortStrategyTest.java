package p200217_radix_sort;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RadixSortStrategyTest {

    @Test
    public void getDigitByIndex() {
        assertThat(RadixSortStrategy.getDigitByRadix(11254, 2)).isEqualTo(2);
        assertThat(RadixSortStrategy.getDigitByRadix(99521377, 0)).isEqualTo(7);
        assertThat(RadixSortStrategy.getDigitByRadix(99521377, 3)).isEqualTo(1);
        assertThat(RadixSortStrategy.getDigitByRadix(69521377, 7)).isEqualTo(6);
        assertThat(RadixSortStrategy.getDigitByRadix(2069521377, 9)).isEqualTo(2);
    }
}