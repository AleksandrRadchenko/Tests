package util;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static util.IntListProfiling.SIZE;
import static util.IntListProfiling.SOURCE_ARRAY;
import static util.IntListProfiling.SOURCE_LIST;

/**
 * Benchmark                                  Mode  Cnt     Score     Error  Units
 * IntListBenchmark.arrayListAddAllBench      avgt    5  2229.842 ± 915.490  ms/op
 * IntListBenchmark.arrayListAddBench         avgt    5     0.058 ±   0.015  ms/op
 * IntListBenchmark.arrayListAddUnboxedBench  avgt    5     0.060 ±   0.010  ms/op
 * IntListBenchmark.intListAddAllBench        avgt    5     0.004 ±   0.001  ms/op
 * IntListBenchmark.intListAddBench           avgt    5     0.045 ±   0.023  ms/op
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 2, time = 1)
@State(Scope.Benchmark)
public class IntListBenchmark {
    private static final Random RND = new Random();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntListBenchmark.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public static IntList intListAddBench() {
        IntList intList = new IntList();
        for (int i = 0; i < SIZE; i++) {
            intList.add(SOURCE_ARRAY[i]);
        }
        return intList;
    }

    @Benchmark
    public static IntList intListAddAllBench() {
        IntList intList = new IntList();
        intList.addAll(SOURCE_ARRAY);
        return intList;
    }

    @Benchmark
    public static List<Integer> arrayListAddBench() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            integers.add(SOURCE_LIST.get(i));
        }
        return integers;
    }

    @Benchmark
    public static List<Integer> arrayListAddUnboxedBench() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            integers.add(SOURCE_ARRAY[i]);
        }
        return integers;
    }

    @Benchmark
    public static List<Integer> arrayListAddAllBench() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            integers.addAll(SOURCE_LIST);
        }
        return integers;
    }
}
