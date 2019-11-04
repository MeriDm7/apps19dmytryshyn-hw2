package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAddAllMethod() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5});
        ImmutableLinkedList res = (ImmutableLinkedList) linkedList.addAll(1, new Object[] {11});
        Object[] ex = new Object[] {1, 11, 2, 3, 4, 5};
        System.out.println(res.toArray());
        assertArrayEquals(ex, res.toArray());
    }
    
}
