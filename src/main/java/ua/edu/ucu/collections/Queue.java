package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue;

    public Queue() {
        this.queue = new ImmutableLinkedList();
    }

    public Queue(ImmutableLinkedList queue) {
        this.queue = queue;
    }

    public void checkSize() throws IndexOutOfBoundsException {
        if (queue.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object peek() {
        checkSize();
        return queue.getFirst();
    }

    public Object dequeue() {
        checkSize();
        Object first = queue.getFirst();
        queue = queue.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }
}
