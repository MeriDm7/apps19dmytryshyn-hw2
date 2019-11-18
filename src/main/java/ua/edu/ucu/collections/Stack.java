package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack;

    public Stack() {
        this.stack = new ImmutableLinkedList();
    }

    public Stack(ImmutableLinkedList stack) {
        this.stack = stack;
    }

    public void checkSize() throws IndexOutOfBoundsException {
        if (stack.size() == 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Object peek() {
        checkSize();
        return stack.getLast();
    }

    public Object pop() {
        checkSize();
        Object last = stack.getLast();
        this.stack = this.stack.removeLast();
        return last;
    }

    public void push(Object e) {
        this.stack = this.stack.addLast(e);
    }


    
}
