package data.structure.heap;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class MaxHeap<T extends Comparable<T>> implements Heap<T> {

    private int size;
    private int capacity;
    private final static int GROWTH_FACTOR = 2;
    private T[] heap;

    public MaxHeap() {
        this(16);
    }

    public MaxHeap(final int capacity) {
        this.capacity = capacity;
        this.heap = (T[])new Comparable[capacity];
        this.size = 0;
    }

    public MaxHeap(final List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Provided Collection Is Null 😔");
        }
        this.capacity = list.size();
        this.heap = (T[])new Comparable[capacity];
        this.size = capacity;
        heapify(list);
    }

    public MaxHeap(final List<T> heap1, final List<T> heap2) {
        if (heap1 == null || heap2 == null) {
            throw new IllegalArgumentException("Provided Heaps Are Null");
        }
        this.capacity = heap1.size() + heap2.size();
        this.heap = (T[])new Comparable[capacity];
        this.size = capacity;
        heapify(heap1, heap2);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null Value Provided");
        }
        ensureCapacity();
        heap[size++] = data;
        shiftUp(size - 1);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Heap Is Empty");
        }
        T root = heap[0];
        heap[0] = heap[--size];
        heap[size] = null;
        shiftDown(0);
        return root;
    }

    public T peek() {
        if (isEmpty()) {
            return  null;
        }
        return heap[0];
    }

    public T pushPop(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null Value Provided");
        }
        if (isEmpty()) {
            return data;
        } else {
            T root = heap[0];
            if (compare(root, data) <= 0) {
                return data;
            }

            heap[0] = data;
            shiftDown(0);
            return root;
        }
    }

    public T popPush(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Null Value Provided");
        }
        if (isEmpty()) {
            return null;
        }
        T root = heap[0];
        heap[0] = data;
        shiftDown(0);
        return root;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public void delete(T data) {
        int index = indexOf(data);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        heap[index] = heap[--size];
        heap[size] = null;
        shiftDown(index);
    }

    public void merge(MaxHeap<T> otherHeap) {
        if (otherHeap == null) {
            throw new IllegalArgumentException("MaxHeap Provided Is Null");
        }
        increaseCapacity(otherHeap.heap.length);
        for (int i = 0; i < otherHeap.heap.length; i++) {
            push(otherHeap.heap[i]);
        }
    }

    private void heapify(List<T> list) {
        int index = size % 2 == 0 ? Math.floorDiv(size, 2) : Math.floorDiv(size - 1, 2);
        for (int i = 0; i < list.size(); i++) {
            heap[i] = list.get(i);
        }
        for (int i = index; i >= 0; i--){
            shiftDown(i);
        }
    }

    private void heapify(List<T> heap1, List<T> heap2) {
        int index = size % 2 == 0 ? Math.floorDiv(size, 2) : Math.floorDiv(size - 1, 2);
        int idx = 0;
        for (int i = 0; i < heap1.size(); i++) {
            heap[idx++] = heap1.get(i);
        }
        for (int i = 0; i < heap2.size(); i++) {
            heap[idx++] = heap2.get(i);
        }
        for (int i = index; i >= 0; i--) {
            shiftDown(i);
        }
    }

    private void shiftUp(int index) {
        int parentIdx = Math.floorDiv(index - 1, 2);
        if (parentIdx >= 0 && isLess(parentIdx, index)) {
            swap(parentIdx, index);
            shiftUp(parentIdx);
        }
    }

    private void shiftDown(int index) {
        int leftChildIdx = index * 2 + 1;
        int rightChildIdx = index * 2 + 2;
        int parentIdx = index;
        if (leftChildIdx < size && isLess(parentIdx, leftChildIdx)) {
            parentIdx = leftChildIdx;
        }
        if (rightChildIdx < size && isLess(parentIdx, rightChildIdx)) {
            parentIdx = rightChildIdx;
        }
        if (parentIdx != index) {
            swap(parentIdx, index);
            shiftDown(parentIdx);
        }
    }

    private boolean isLess(int parentIdx, int childIdx) {
        T parent = heap[parentIdx];
        T child = heap[childIdx];
        return parent.compareTo(child) < 0;
    }

    private int compare(T data1, T data2) {
        return data1.compareTo(data2);
    }

    private void swap(int idx1, int idx2) {
      T temp = heap[idx1];
      heap[idx1] = heap[idx2];
      heap[idx2] = temp;
    }

    private void ensureCapacity() {
        if (size + 1 > capacity) {
            capacity = capacity * GROWTH_FACTOR;
            T[] tempHeap = (T[])new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                tempHeap[i] = heap[i];
            }
            heap = tempHeap;
        }
    }

    private void increaseCapacity(int extraSpace) {
        if (extraSpace != 0) {
            this.capacity = Math.max(capacity * GROWTH_FACTOR, size + extraSpace);
            T[] tempHeap = (T[])new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                tempHeap[i] = heap[i];
            }
            heap = tempHeap;
        }
    }

    private int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (heap[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(heap[i].toString());
        }
        return sj.toString();
    }
}
