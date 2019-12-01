package codewars.kyu7;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SummOfOddNumbersTest {

    @Test
    public void rowSumOddNumbers() {
        assertThat(SummOfOddNumbers.rowSumOddNumbers(1), is(1));
        assertThat(SummOfOddNumbers.rowSumOddNumbers(2), is(8));
        assertThat(SummOfOddNumbers.rowSumOddNumbers(5), is(125));
    }

}