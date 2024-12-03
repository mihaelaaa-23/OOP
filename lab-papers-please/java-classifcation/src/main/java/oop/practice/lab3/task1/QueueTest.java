package oop.practice.lab3.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue<Integer> arrayQueue;
    private Queue<Integer> vectorQueue;
    private Queue<Integer> linkedQueue;

    @BeforeEach
    public void setUp() {
        arrayQueue = new ArrayQueue<>(5);  // Initialize with capacity 5
        vectorQueue = new VectorQueue<>(5);
        linkedQueue = new LinkedQueue<>(5);
    }

    @Test
    public void testEnqueueAndDequeue() {
        assertEnqueueAndDequeue(arrayQueue);
        arrayQueue.clear();

        assertEnqueueAndDequeue(vectorQueue);
        vectorQueue.clear();

        assertEnqueueAndDequeue(linkedQueue);
        linkedQueue.clear();
    }

    @Test
    public void testPeek() {
        assertPeek(arrayQueue);
        arrayQueue.clear();

        assertPeek(vectorQueue);
        vectorQueue.clear();

        assertPeek(linkedQueue);
        linkedQueue.clear();
    }

    @Test
    public void testIsEmpty() {
        assertIsEmpty(arrayQueue);
        arrayQueue.clear();

        assertIsEmpty(vectorQueue);
        vectorQueue.clear();

        assertIsEmpty(linkedQueue);
        linkedQueue.clear();
    }

    @Test
    public void testIsFull() {
        assertIsFull(arrayQueue);
        arrayQueue.clear();

        assertIsFull(vectorQueue);
        vectorQueue.clear();
    }

    @Test
    public void testBoundaryConditions() {
        assertBoundaryConditions(arrayQueue);
        arrayQueue.clear();

        assertBoundaryConditions(vectorQueue);
        vectorQueue.clear();
    }

    private void assertEnqueueAndDequeue(Queue<Integer> queue) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue(), "Dequeue should return the first enqueued item");
        assertEquals(2, queue.dequeue(), "Dequeue should return the second enqueued item");
        assertEquals(3, queue.dequeue(), "Dequeue should return the third enqueued item");

        assertTrue(queue.isEmpty(), "Queue should be empty after all items are dequeued");
    }

    private void assertPeek(Queue<Integer> queue) {
        queue.enqueue(10);
        assertEquals(10, queue.peek(), "Peek should return the first item without removing it");

        queue.enqueue(20);
        assertEquals(10, queue.peek(), "Peek should still return the first item");

        queue.dequeue();
        assertEquals(20, queue.peek(), "Peek should update to the next item after a dequeue");
    }

    private void assertIsEmpty(Queue<Integer> queue) {
        assertTrue(queue.isEmpty(), "Queue should initially be empty");

        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");

        queue.dequeue();
        assertTrue(queue.isEmpty(), "Queue should be empty after all items are dequeued");
    }

    private void assertIsFull(Queue<Integer> queue) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertFalse(queue.isFull(), "Queue should not be full before reaching capacity");

        queue.enqueue(5);
        assertTrue(queue.isFull(), "Queue should be full after reaching capacity");

        assertThrows(IllegalStateException.class, () -> queue.enqueue(6), "Enqueueing into a full queue should throw");
    }

    private void assertBoundaryConditions(Queue<Integer> queue) {
        // Dequeue from an empty queue
        assertThrows(IllegalStateException.class, queue::dequeue, "Dequeue should throw when queue is empty");

        // Peek from an empty queue
        assertThrows(IllegalStateException.class, queue::peek, "Peek should throw when queue is empty");

        // Fill the queue and ensure capacity is respected
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertThrows(IllegalStateException.class, () -> queue.enqueue(6), "Enqueue should throw when queue is full");

        // Ensure size is consistent
        assertEquals(5, queue.size(), "Queue size should reflect the number of items");

        // Clear the queue and ensure it is empty
        queue.clear();
        assertTrue(queue.isEmpty(), "Queue should be empty after clear");
    }
}
