package codewars.kyu6;

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
 * Benchmark          Mode    Cnt Score           Error        Units
 * powOfTwoCyclist    thrpt   10  411855950,327 ± 5471464,373  ops/s
 * powOfTwoLibrarian  thrpt   10   43705584,857 ±  136146,781  ops/s
 *
 * Benchmark              Mode   Cnt Score          Error       Units
 * strongestEven          thrpt  10   2756863,827 ±  35706,988  ops/s
 * strongestEvenAlt thrpt  10  62877964,011 ± 147694,419  ops/s
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
@Fork(1)
@Measurement(iterations = 10, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class StrongestEvenNumberBenchmark {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StrongestEvenNumberBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static void strongestEven(Blackhole bh) {
        bh.consume(StrongestEvenNumber.strongestEven(1, Integer.MAX_VALUE));
    }
    @Benchmark
    public static void strongestEvenAlt(Blackhole bh) {
        bh.consume(StrongestEvenNumber.strongestEvenAlt(1, Integer.MAX_VALUE));
    }
}
