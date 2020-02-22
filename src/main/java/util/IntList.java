package util;

import java.util.Arrays;
import java.util.Objects;

public class IntList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new int[DEFAULT_CAPACITY];
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int size;

    /**
     * For JOL purposes
     */
    public int[] getElementData() {
        return elementData;
    }

    private int[] elementData = new int[DEFAULT_CAPACITY];

    public int size() {
        return size;
    }

    public boolean add(int e) {
        add(size(), e);
        return true;
    }

    public boolean addAll(int[] e) {
        int size = size() + e.length;
        int[] elementData = this.elementData;
        if (size > this.elementData.length) {
            elementData = grow(size);
        }
        System.arraycopy(e, 0,
                elementData, size(),
                e.length);
        this.size = size;
        return true;
    }

    public void add(int index, int element) {
        rangeCheck(index);
        final int s;
        int[] elementData;
        if ((s = size) == (elementData = this.elementData).length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    public int get(int index) {
        Objects.checkIndex(index, size);
        return elementData[index];
    }

    public void clear() {
        elementData = new int[0];
        size = 0;
    }

    private int[] grow() {
        return grow(size + 1);
    }

    private int[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
