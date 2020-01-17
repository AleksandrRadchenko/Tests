package codewars.kyu7;

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
 * Benchmark                                      Mode  Cnt     Score     Error   Units
 * TwoToOneBenchmark.longestArrayMemOptimized    thrpt    5  6034,022 ± 267,738  ops/ms
 * TwoToOneBenchmark.longestArraySpeedOptimized  thrpt    5  5156,856 ±  50,413  ops/ms
 * TwoToOneBenchmark.longestMap                  thrpt    5   804,444 ±   6,132  ops/ms
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class TwoToOneBenchmark {
    private static final String EXPR1 = "loopingisfunbutdangerous";
    private static final String EXPR2 = "lessdangerousthancoding";

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TwoToOne.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static void longestMap(Blackhole bh) {
        bh.consume(TwoToOne.longestMap(EXPR1, EXPR2));
    }

    @Benchmark
    public static void longestArraySpeedOptimized(Blackhole bh) {
        bh.consume(TwoToOne.longestArraySpeedOptimized(EXPR1, EXPR2));
    }

    @Benchmark
    public static void longestArrayMemOptimized(Blackhole bh) {
        bh.consume(TwoToOne.longestArrayMemOptimized(EXPR1, EXPR2));
    }
}
