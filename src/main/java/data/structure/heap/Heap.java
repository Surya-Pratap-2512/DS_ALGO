package data.structure.heap;

public interface Heap<T extends Comparable<T>> {

    int size();
    boolean isEmpty();
    void push(T data);
    T pop();
    T peek();
    T pushPop(T data);
    T popPush(T data);
    boolean contains(T data);
    void delete(T data);
}
