package data.structure.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void initializeHead(T data) {
        head = new Node<>(data, null);
        tail = head;
    }

    public void add(T data) {
        if (isEmpty()) {
            initializeHead(data);
        } else {
            Node<T> temp = new Node<>(data, null);
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            initializeHead(data);
        } else {
            head = new Node<>(data, head);
        }
        size++;
    }

    private Node<T> getByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node<T> temp = head;
        while (temp != null && count != index) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public int indexOf(T data) {
        if(isEmpty()) {
            throw new RuntimeException("List Is Empty");
        }
        int count = 0;
        Node<T> temp = head;
        while (temp != null && !temp.data.equals(data)) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
           return -1;
        }
        return count;
    }

    public void set(int index, T data) {
        Node<T> temp = getByIndex(index);
        temp.data = data;
    }

    public T removeFirst() {
       if (isEmpty()) {
           throw new RuntimeException("List Is Empty");
       }
       Node<T> temp = head;
       head = head.next;
       temp.next = null;
       size--;
       return temp.data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List Is Empty");
        }
        if (size == 1) {
            return removeFirst();
        }
        Node<T> prev = getByIndex(size - 2);
        prev.next = null;
        T data = tail.data;
        tail = prev;
        size--;
        return data;
    }

    public T remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> prev = getByIndex(index - 1);
            Node<T> nodeToRemove = prev.next;
            prev.next = nodeToRemove.next;
            nodeToRemove.next = null;
            size--;
            return nodeToRemove.data;
        }
    }

    public void remove(T data) {
        if (isEmpty()) {
            throw new RuntimeException("List Is Empty");
        }
        Node<T> curr = head;
        Node<T> prev = null;
        while (curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) {
            throw new NoSuchElementException();
        }
        if (curr == head) {
            head = head.next;
        } else {
            prev.next = curr.next;
            if (curr == tail) {
                tail = prev;
            }
        }
        curr.next = null;
        size--;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
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
