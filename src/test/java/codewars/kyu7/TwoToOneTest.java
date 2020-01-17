package codewars.kyu7;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoToOneTest {

    @Test
    public void longestMap() {
        assertEquals("aehrsty", TwoToOne.longestMap("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longestMap("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longestMap("inmanylanguages", "theresapairoffunctions"));
    }
    @Test
    public void longestArraySpeedOptimized() {
        assertEquals("aehrsty", TwoToOne.longestArraySpeedOptimized("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longestArraySpeedOptimized("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longestArraySpeedOptimized("inmanylanguages", "theresapairoffunctions"));
    }
    @Test
    public void longestArrayMemOptimized() {
        assertEquals("aehrsty", TwoToOne.longestArrayMemOptimized("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longestArrayMemOptimized("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longestArrayMemOptimized("inmanylanguages", "theresapairoffunctions"));
    }
}