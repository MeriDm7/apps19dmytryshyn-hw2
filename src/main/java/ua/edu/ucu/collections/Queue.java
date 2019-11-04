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

    public Object peek() {
        if (queue.size() > 0) {
            return queue.getFirst();
        }
        throw new IndexOutOfBoundsException();
    }

    public Object dequeue() {
        if (queue.size() > 0) {
            Object first = queue.getFirst();
            queue = queue.removeFirst();
            return first;
        }
        throw new IndexOutOfBoundsException();
    }

    public void enqueue(Object e) {
        queue = queue.addLast(e);
    }






    
}
