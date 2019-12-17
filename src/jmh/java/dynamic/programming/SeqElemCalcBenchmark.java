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
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * Benchmark                           (arg)  Mode  Cnt         Score         Error  Units
 * calcDynamicallyWithArrayAsCache         5  avgt    3        22,018 ±      37,872  ns/op
 * calcDynamicallyWithArrayAsCache        20  avgt    3        59,679 ±      30,623  ns/op
 * calcDynamicallyWithArrayAsCache        21  avgt    3        55,867 ±      30,065  ns/op
 * calcDynamicallyWithArrayAsCache    123456  avgt    3     50581,847 ±   87364,685  ns/op
 * calcDynamicallyWithArrayAsCache  33554432  avgt    3  25966247,002 ± 8040093,663  ns/op
 * calcDynamicallyWithMapAsCache           5  avgt    3        99,566 ±      53,111  ns/op
 * calcDynamicallyWithMapAsCache          20  avgt    3       300,518 ±     200,339  ns/op
 * calcDynamicallyWithMapAsCache          21  avgt    3       304,308 ±     117,137  ns/op
 * calcDynamicallyWithMapAsCache      123456  avgt    3      1957,946 ±     933,134  ns/op
 * calcDynamicallyWithMapAsCache    33554432  avgt    3      6418,653 ±    9578,871  ns/op
 * calcRecursively                         5  avgt    3         9,900 ±       0,481  ns/op
 * calcRecursively                        20  avgt    3        42,444 ±       1,240  ns/op
 * calcRecursively                        21  avgt    3        39,268 ±       1,509  ns/op
 * calcRecursively                    123456  avgt    3    254698,192 ±   25725,423  ns/op
 * calcRecursively                  33554432  avgt    3  62053100,176 ± 2500441,078  ns/op
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 3, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class SeqElemCalcBenchmark {
    @SuppressWarnings("unused")
    @Param({"5", "20", "21", "123456", "33554432"})
    static int arg;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SeqElemCalcBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static int calcRecursively() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionCalcStrategy());
        return sem.calc(arg);
    }

    @Benchmark
    public static int calcRecursivelyWithArrayAsCache() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionWithArrayCacheCalcStrategy());
        return sem.calc(arg);
    }

    @Benchmark
    public static int calcRecursivelyWithMapAsCache() {
        SeqElemCalc sem = new SeqElemCalc(new RecursionWithMapCacheCalcStrategy());
        return sem.calc(arg);
    }
}
