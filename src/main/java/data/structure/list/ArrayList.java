package data.structure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayList<T> {
    private Integer size;
    private Integer capacity;
    private final static Float GROWTH_FACTOR = 1.5F;
    private T[] list;

    public ArrayList() {
        this(16);
    }

    public ArrayList(Integer capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity Provided.");
        }
        this.capacity = capacity;
        this.list = (T[])new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T obj) {
        if (size == capacity) {
            this.capacity = (int)(capacity * GROWTH_FACTOR);
            T[] temp = (T[])new Object[capacity];
            for (int i = 0; i < size(); i++) {
                temp[i] = list[i];
            }
            this.list = temp;
        }
        list[size++] = obj;
    }

    public void set(int index, T obj) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = obj;
    }

    public int indexOf(T obj) {
        for (int i = 0; i < size(); i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(T obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        for (int i = index + 1;  i < size(); i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        T data = list[index];
        for (int i = index + 1; i < size(); i++){
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return data;
    }

    public boolean contains(T obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public String toString() {
        StringJoiner sj  = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size(); i++) {
            sj.add(list[i].toString());
        }
        return sj.toString();
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            private int lastReturnedIndex  = -1;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastReturnedIndex = index;
                return list[index++];
            }

            @Override
            public void remove() {
                if (lastReturnedIndex < 0) {
                    throw new IllegalArgumentException();
                }
                ArrayList.this.remove(lastReturnedIndex);
                if (index > lastReturnedIndex) {
                    index--;
                }
                lastReturnedIndex = -1;
            }
        };
    }
}
