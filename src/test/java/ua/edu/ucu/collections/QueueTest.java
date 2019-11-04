package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue q = new Queue(new ImmutableLinkedList(new Object[] {3, 5, 7}));
    private Queue empty = new Queue();
    
    @Test
    public void testPeek() {
        assertEquals(3, q.peek());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() {
        empty.peek();
    }

    @Test
    public void testDeQueue() {
        assertEquals(3, q.dequeue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeQueueException() {
        empty.dequeue();
    }

    @Test
    public void testEnQueue() {
        empty.enqueue(7);
        assertEquals(7, empty.peek());
    }
}
