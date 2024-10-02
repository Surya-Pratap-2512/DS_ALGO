package data.structure.list;

import java.util.StringJoiner;

public class Stack<T> {

    private int size;
    private int capacity;
    private final static float GROWTH_FACTOR = 1.5f;
    private T[] stack;
    //private int currentIndex;

    public Stack() {
        this(16);
    }

    public Stack(final int capacity) {
        this.capacity = capacity;
        this.stack = (T[])new Object[capacity];
        this.size = 0;
        //this.currentIndex = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void increaseSizeAndCopyData() {
        capacity = (int)(capacity * GROWTH_FACTOR);
        T[] temp = (T[])new Object[capacity];
        for (int i = 0; i < size(); i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public void push(T data) {
        if(size + 1 > capacity) {
            increaseSizeAndCopyData();
        }
        stack[size++] = data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Is Empty");
        }
        return stack[size - 1];
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Is Empty");
        }
        T data = stack[--size];
        stack[size] = null;
        return data;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (stack[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T data) {
       return indexOf(data) != -1;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i = size - 1; i >= 0; i--) {
            sj.add(stack[i].toString());
        }
        return sj.toString();
    }
}
