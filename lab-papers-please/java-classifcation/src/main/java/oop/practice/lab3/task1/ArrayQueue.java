package oop.practice.lab3.task1;
import java.util.ArrayList;

public class ArrayQueue<T> implements Queue<T> {
    private ArrayList<T> items;

    public ArrayQueue() {
        this.items = new ArrayList<>();
    }

    @Override
    public void enqueue(T item) {
        items.add(item);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.get(0);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public int size() {
        return items.size();
    }
}
