package data.structure.queue;

import data.structure.list.LinkedList;

import java.util.StringJoiner;

public class LinkedQueue<T> implements  Queue<T>{

    private int size;
    private Node<T> head;
    private Node<T> tail;

   private static class Node<E> {
       private Node<E> next;
       private Node<E> prev;
       private E data;

       public Node(final E data) {
           this(null, null, data);
       }

       public Node(final Node<E> next, final Node<E> prev, final E data) {
           this.next = next;
           this.prev = prev;
           this.data = data;
       }
   }

   public LinkedQueue() {
       this.size = 0;
       this.head = null;
       this.tail = null;
   }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void initializeHead(T data) {
       head = new Node<>(data);
       tail = head;
    }

    @Override
    public void enqueue(T data) {
       if (isEmpty()) {
           initializeHead(data);
       } else {
           tail = new Node<>(null, tail, data);
           tail.prev.next = tail;
       }
       size++;

    }

    @Override
    public T dequeue() {
       if (isEmpty()) {
           throw new RuntimeException("Queue Is Empty");
       }
       Node<T> temp = head;
       head = head.next;
       temp.next = null;
       head.prev = null;
       size--;
       return temp.data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[","]");
        Node<T> temp = head;
        while (temp != null) {
            sj.add(temp.data.toString());
            temp = temp.next;
        }
        return sj.toString();
    }
}
