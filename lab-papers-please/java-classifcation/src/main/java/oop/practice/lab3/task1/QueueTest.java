package oop.practice.lab3.task1;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("\n---Testing Array Queue---");
        testQueue(new ArrayQueue<>());

        System.out.println("\n---Testing Linked Queue---");
        testQueue(new LinkedQueue<>());

        System.out.println("\n---Testing Vector Queue---");
        testQueue(new VectorQueue<>());

    }

    private static void testQueue(Queue<Integer> queue) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assert queue.size() == 3 : "Size should be 3";
        assert queue.peek() == 1 : "Peek should be 1";
        assert queue.dequeue() == 1 : "Dequeue should be 1";
        assert queue.size() == 2 : "Size should be 2 after one dequeue";
        assert queue.dequeue() == 2 : "Dequeue should be 2";
        assert queue.dequeue() == 3 : "Dequeue should be 3";

        System.out.println("Queue passed all tests!");
    }
}
