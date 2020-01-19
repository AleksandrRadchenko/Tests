package codewars.kyu6;

import org.junit.Test;

import static codewars.kyu6.StrongestEvenNumber.getStrength;
import static codewars.kyu6.StrongestEvenNumber.strongestEven;
import static codewars.kyu6.StrongestEvenNumber.twoPow;
import static org.junit.Assert.*;

public class StrongestEvenNumberTest {

    @Test
    public void strongestEvenTest() {
        assertEquals(1073741824, strongestEven(1, Integer.MAX_VALUE));
        assertEquals(2, strongestEven(1, 2));
        assertEquals(8, strongestEven(5, 10));
        assertEquals(48, strongestEven(48, 56));
    }

    @Test
    public void twoPowTest() {
        assertEquals(4, twoPow(2));
        assertEquals(256, twoPow(8));
    }

    @Test
    public void getStrengthTest() {
        assertEquals(4, getStrength(16));
        assertEquals(4, getStrength(48));
        assertEquals(1, getStrength(6));
        assertEquals(2, getStrength(12));
    }
}