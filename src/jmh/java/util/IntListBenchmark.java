package util;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark                      Mode  Cnt    Score    Error  Units
 * IntListBenchmark.arrayListAdd  avgt   15  211.780 �  4.041  ns/op
 * IntListBenchmark.intListAdd    avgt   15   94.285 � 13.331  ns/op
 */
@SuppressWarnings({"unused"})
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(1)
@Measurement(iterations = 5, time = 1)
@Warmup(iterations = 2, time = 1)
public class IntListBenchmark {
    private static final int SIZE = 1 << 19; //1 << 29 = 536,870,912
    private static final int UNIT = 1 << 20; //1,048,576
    private static final Random RND = new Random();
    private static final int[] SOURCE_ARRAY = RND.ints(SIZE).toArray();

    @State(Scope.Benchmark)
    public static class IntListState {
        final IntList DESTINATION = new IntList(SIZE);
    }

    @State(Scope.Benchmark)
    public static class ArrayListState {
        final ArrayList<Integer> SOURCE_LIST = new ArrayList<>();
        final Integer[] SOURCE_ARRAY_BOXED = new Integer[SIZE];
        @Setup
        public void setup() {
            for (int i = 0; i < SOURCE_ARRAY.length; i++) {
                SOURCE_LIST.add(SOURCE_ARRAY[i]);
                //noinspection UnnecessaryBoxing
                SOURCE_ARRAY_BOXED[i] = Integer.valueOf(SOURCE_ARRAY[i]);
            }
        }
        final ArrayList<Integer> DESTINATION = new ArrayList<>(SIZE);
    }

    @State(Scope.Benchmark)
    public static class IntArrayListState {
        final IntArrayList DESTINATION = new IntArrayList(SIZE);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntListBenchmark.class.getSimpleName())
                .addProfiler(StackProfiler.class, "lines=1;period=1")
                .jvmArgs("-XX:+HeapDumpOnOutOfMemoryError")
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void intListAdd(IntListState state, Blackhole bh) {
        for (int i = 0; i < SIZE; i++) {
            bh.consume(state.DESTINATION.add(SOURCE_ARRAY[i]));
        }
        state.DESTINATION.clear(); // takes about 2% CPU time
    }

    @Benchmark
    public void intArrayListAdd(IntArrayListState state, Blackhole bh) {
        for (int i = 0; i < SIZE; i++) {
            bh.consume(state.DESTINATION.add(SOURCE_ARRAY[i]));
        }
        state.DESTINATION.clear();
    }

    @Benchmark
    public void arrayListAddPrimitive(ArrayListState state, Blackhole bh) {
        for (int i = 0; i < SIZE; i++) {
            bh.consume(state.DESTINATION.add(SOURCE_ARRAY[i]));
        }
        state.DESTINATION.clear();
    }

    @Benchmark
    public void arrayListAddBoxed(ArrayListState state, Blackhole bh) {
        for (int i = 0; i < SIZE; i++) {
            bh.consume(state.DESTINATION.add(state.SOURCE_ARRAY_BOXED[i]));
        }
        state.DESTINATION.clear();
    }
}
