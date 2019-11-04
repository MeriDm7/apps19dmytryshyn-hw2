package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    private Stack s = new Stack(new ImmutableLinkedList(new Object[] {7, 3, 1}));
    private Stack empty = new Stack();
    
    @Test
    public void testPeek() {
        assertEquals(1, s.peek());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPeekException() {
        empty.peek();
    }

    @Test
    public void testPop() {
        assertEquals(1, s.pop());
        assertEquals(3, s.peek());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPopException() {
        empty.pop();
    }

    @Test
    public void testPush() {
        empty.push(11);
        assertEquals(11, empty.peek());
    }
}
