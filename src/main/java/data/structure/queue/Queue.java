package data.structure.queue;

public interface Queue<T> {

    int size();
    boolean isEmpty();
    void enqueue(T data);
    T dequeue();
    T peek();

}
