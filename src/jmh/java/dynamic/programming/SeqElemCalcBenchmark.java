package dynamic.programming;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
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
 * time = 1000 ms
 * Benchmark                         (arg)  Mode  Cnt       Score       Error  Units
 * SeqElemCalcBenchmark.seqRequrve       5  avgt    3       9,934 ±     2,566  ns/op
 * SeqElemCalcBenchmark.seqRequrve      20  avgt    3      37,682 ±     0,977  ns/op
 * SeqElemCalcBenchmark.seqRequrve      21  avgt    3      38,178 ±     2,530  ns/op
 * SeqElemCalcBenchmark.seqRequrve  123456  avgt    3  253657,801 ± 19862,600  ns/op
 *
 * time = 100 ms, jar
 * SeqElemCalcBenchmark.seqRequrve       5  avgt    3       9,922 ±     0,941  ns/op
 * SeqElemCalcBenchmark.seqRequrve      20  avgt    3      36,908 ±     4,975  ns/op
 * SeqElemCalcBenchmark.seqRequrve      21  avgt    3      37,278 ±     3,615  ns/op
 * SeqElemCalcBenchmark.seqRequrve  123456  avgt    3  254131,370 ± 23128,618  ns/op
 *
 * time = 100 ms
 * Benchmark                         (arg)  Mode  Cnt       Score       Error  Units
 * SeqElemCalcBenchmark.seqRequrve       5  avgt    3      13,630 ±    31,180  ns/op
 * SeqElemCalcBenchmark.seqRequrve      20  avgt    3      38,732 ±     1,010  ns/op
 * SeqElemCalcBenchmark.seqRequrve      21  avgt    3      38,781 ±    12,356  ns/op
 * SeqElemCalcBenchmark.seqRequrve  123456  avgt    3  256709,568 ± 21906,496  ns/op
 *
 * time = 10 ms
 * Benchmark                         (arg)  Mode  Cnt       Score       Error  Units
 * SeqElemCalcBenchmark.seqRequrve       5  avgt    3      14,424 ±    47,676  ns/op
 * SeqElemCalcBenchmark.seqRequrve      20  avgt    3      41,031 ±    62,056  ns/op
 * SeqElemCalcBenchmark.seqRequrve      21  avgt    3      42,980 ±    56,252  ns/op
 * SeqElemCalcBenchmark.seqRequrve  123456  avgt    3  260155,740 ± 69702,632  ns/op
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SeqElemCalcBenchmark {
    @Param({"5", "20", "21", "123456", "33554432"})
    static int arg;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SeqElemCalcBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static void calcReqursively(Blackhole bh) {
        bh.consume(SeqElemCalc.calcReqursively(arg));
    }

    @Benchmark
    public static void calcDynamicallyWithArrayAsCache(Blackhole bh) {
        bh.consume(SeqElemCalc.calcDynamicallyWithArrayAsCache(arg));
    }

    @Benchmark
    public static void calcDynamicallyWithMapAsCache(Blackhole bh) {
        bh.consume(SeqElemCalc.calcDynamicallyWithMapAsCache(arg));
    }
}
