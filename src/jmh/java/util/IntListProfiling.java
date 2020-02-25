package util;

import java.util.ArrayList;

public class IntListProfiling {
    private static final int SIZE = 1 << 29; //1 << 29 = 536,870,912
    private static final int UNIT = 1 << 20; //1,048,576
    private static final IntList INT_LIST = new IntList(SIZE);
    private static final ArrayList<Integer> ARRAY_LIST = new ArrayList<>(SIZE);

    public static void main(String[] args) {
        System.out.println("Max heap: " + Runtime.getRuntime().maxMemory()/(UNIT) + "Mb");
        for (int i = 0; i < SIZE; i++) {
            intListAddBench();
//            arrayListAddBench(); // OOME for 1<<29 size
        }
        System.out.println("Remaining heap: " + Runtime.getRuntime().freeMemory()/(UNIT) + "Mb"  );
    }

    public static boolean intListAddBench() {
        return INT_LIST.add(42);
    }

    public static boolean arrayListAddBench() {
        return ARRAY_LIST.add(42);
    }

}
