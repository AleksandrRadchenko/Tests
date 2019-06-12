package a180911;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Fork(1)
public class RevertString {
    final private static String s = "abc";

    public static void main(String[] args) {
//        char[] sInChars = reverseStringUsingFor(s.toCharArray());
//        System.out.println("for: " + Arrays.toString(sInChars));
//        sInChars = reverseStringUsingStringBuilder(s.toCharArray());
//        System.out.println("sb: " + Arrays.toString(sInChars));
//        sInChars = reverseStringUsingStream(s.toCharArray());
//        System.out.println("stream: " + Arrays.toString(sInChars));
    }

    @Benchmark
//    private static char[] reverseStringUsingStringBuilder(final char[] chars) {
    private static char[] reverseStringUsingStringBuilder() {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString().toCharArray();
    }

//    private static Collector toReversedArray = Collector.of(Character[]::new, );
    private static char[] reverseStringUsingStream(final char[] chars) {
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = chars[i];
        }
//        Object collect = Stream.of(characters).collect(toReversedArray);
        return null;
    }

    @Benchmark
//    private static char[] reverseStringUsingFor(final char[] sInChars) {
    private static char[] reverseStringUsingFor() {
        char[] sInChars = s.toCharArray();
        for (int i = 0; i < sInChars.length / 2; i++) {
            char tmp = sInChars[sInChars.length - 1 - i];
            sInChars[sInChars.length - 1 - i] = sInChars[i];
            sInChars[i] = tmp;
        }
        return sInChars;
    }
}
