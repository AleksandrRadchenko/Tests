package a180911;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Benchmark                                     Mode  Cnt   Score   Error  Units
 * RevertString.reverseStringUsingFor            avgt    3   7,567 ± 0,351  ns/op
 * RevertString.reverseStringUsingStringBuilder  avgt    3  33,784 ± 0,703  ns/op
 */
@Warmup(iterations = 3, time = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 3, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class RevertString {
    private static final String EXPR = "abc";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RevertString.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static char[] reverseStringUsingStringBuilder() {
        char[] chars = EXPR.toCharArray();
        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString().toCharArray();
    }

    @Benchmark
    public static char[] reverseStringUsingFor() {
        char[] chars = EXPR.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = tmp;
        }
        return chars;
    }
}
