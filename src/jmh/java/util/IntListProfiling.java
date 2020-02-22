package util;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.layouters.CurrentLayouter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IntListProfiling {
    public static final Random RND = new Random();
    public static final int SIZE = 10000;
    public static final int[] SOURCE_ARRAY = RND.ints(SIZE).toArray();
    public static final ArrayList<Integer> SOURCE_LIST = new ArrayList<>();
    static {
        for (int i : SOURCE_ARRAY) {
            SOURCE_LIST.add(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(int[].class, new CurrentLayouter()).toPrintable(intListAddBench().getElementData()));
        System.out.println(ClassLayout.parseClass(ArrayList.class, new CurrentLayouter()).toPrintable(arrayListAddBench()));
        System.out.println(GraphLayout.parseInstance(intListAddBench()).toFootprint());
        System.out.println(GraphLayout.parseInstance(arrayListAddBench()).toFootprint());
        //noinspection InfiniteLoopStatement
        while (true) {
            IntListBenchmark.arrayListAddBench();
        }
    }

    public static IntList intListAddBench() {
        IntList intList = new IntList();
        for (int i : SOURCE_ARRAY) {
            intList.add(i);
        }
        return intList;
    }

    public static List<Integer> arrayListAddBench() {
        ArrayList<Integer> integers = new ArrayList<>();
        //noinspection CollectionAddAllCanBeReplacedWithConstructor
        integers.addAll(SOURCE_LIST);
        return integers;
    }

}
