package codewars.kyu5;

import a180911.RevertString;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
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
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 3, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class RevertStringBenchmark {
    private static final String EXPR = "abc";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RevertStringBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static void reverseStringUsingStringBuilder(Blackhole bh) {
        bh.consume(RevertString.reverseStringUsingStringBuilder(EXPR));
    }

    @Benchmark
    public static void reverseStringUsingFor(Blackhole bh) {
        bh.consume(RevertString.reverseStringUsingFor(EXPR));
    }
}
