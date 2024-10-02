package data.structure.queue;

import java.util.StringJoiner;

public class ArrayQueue<T> implements  Queue<T>{

    private int size;
    private int capacity;
    private final static float GROWTH_FACTOR = 1.5f;
    private T[] queue;

    public ArrayQueue() {
        this(16);
    }

    public ArrayQueue(final int capacity) {
        this.capacity = capacity;
        this.queue = (T[])new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseCapacityAndCopyData() {
        capacity = (int)(capacity * GROWTH_FACTOR);
        T[] temp = (T[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public void enqueue(T data) {
        if (size + 1 > capacity) {
            increaseCapacityAndCopyData();
        }
        queue[size++] = data;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Is Empty");
        }
        T data = queue[0];
        shiftDataLeft();
        size--;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[0];
    }

    private void shiftDataLeft() {
        for (int i = 0; i < size; i++) {
            queue[i] = queue[i + 1];
        }
        queue[size - 1] = null;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        for (int i = 0; i < size; i++) {
            sj.add(queue[i].toString());
        }
        return sj.toString();
    }
}
