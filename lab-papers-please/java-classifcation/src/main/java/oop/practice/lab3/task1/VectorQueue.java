package oop.practice.lab3.task1;

import java.util.Vector;

public class VectorQueue<T> implements Queue<T> {
    private Vector<T> vector;
    private int capacity;

    public VectorQueue() {
        this.capacity = Integer.MAX_VALUE;
        this.vector = new Vector<>();
    }

    public VectorQueue(int capacity) {
        this.capacity = capacity;
        this.vector = new Vector<>();
    }

    @Override
    public void enqueue(T item) {
        if (!isFull()){
            vector.add(item);
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        T item = vector.remove(0);
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return vector.firstElement();
    }

    @Override
    public boolean isEmpty() {
        return vector.isEmpty();
    }

    private boolean isFull() {
        return vector.size() >= capacity;
    }

    @Override
    public int size() {
        return vector.size();
    }
}


