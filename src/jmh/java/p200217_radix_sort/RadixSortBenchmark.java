package p200217_radix_sort;

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

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Benchmark                          Mode  Cnt       Score       Error  Units
 * RadixSortBenchmark.jdkSortBench    avgt    3    1571,077 ±    39,401  ns/op
 * RadixSortBenchmark.radixSortBench  avgt    3  383611,117 ± 58074,767  ns/op
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 3, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class RadixSortBenchmark {
    private static final int SIZE = 1000000;
    private static final List<Integer> ORIGINAL =
            new Random().ints(SIZE, 0, Integer.MAX_VALUE)
                        .boxed()
                        .collect(Collectors.toList());
    private static final Sorter<Integer> radixSorter = new Sorter<>(new RadixSortStrategy());
    private static final Sorter<Integer> jdkSorter = new Sorter<>(new JDKSortStrategy());

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RadixSortBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public List<Integer> radixSortBench() {
        return radixSorter.sort(ORIGINAL);
    }

    @Benchmark
    public List<Integer> jdkSortBench() {
        return jdkSorter.sort(ORIGINAL);
    }
}
