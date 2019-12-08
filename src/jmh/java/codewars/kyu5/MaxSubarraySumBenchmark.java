package codewars.kyu5;

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
 * Benchmark                                              Mode  Cnt    Score     Error  Units
 * MaxSubarraySumBenchmark.stackBench                     avgt    3  373,698 ± 207,649  ns/op
 * MaxSubarraySumBenchmark.variableBench                  avgt    3   47,677 ±   1,761  ns/op
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 3, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class MaxSubarraySumBenchmark {
    private static final int[] EXPR = new int[]{-2, 1, -3, 4, -1, 2, 1, -8, 2, 5};

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MaxSubarraySumBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void stackBench(Blackhole bh) {
        bh.consume(MaxSubarraySum.usingStack(EXPR));
    }

    @Benchmark
    public void variableBench(Blackhole bh) {
        bh.consume(MaxSubarraySum.usingVariable(EXPR));
    }
}
