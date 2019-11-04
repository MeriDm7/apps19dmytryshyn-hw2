package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAddMethod1() {
        Object[] simpleArray = new Object[]{1, 2, 3};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        ImmutableArrayList res =  (ImmutableArrayList) lst.add(5);
        Object[] resArray = new Object[]{1, 2, 3, 5};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testAddMethod2() {
        Object[] simpleArray = new Object[]{1, 2, 3};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        ImmutableArrayList res =  (ImmutableArrayList) lst.add(2, 7);
        Object[] resArray = new Object[]{1, 2, 7, 3};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testAddAllMethod1() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        Object[] addArray = new Object[]{5, 6, 7};
        ImmutableArrayList res =  (ImmutableArrayList) lst.addAll(addArray);
        Object[] resArray = new Object[]{0, 1, 2, 3, 5, 6, 7};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testAddAllMethod2() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3, 4, 5, 11};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        Object[] addArray = new Object[]{6, 7, 8, 9, 10};
        ImmutableArrayList res =  (ImmutableArrayList) lst.addAll(3, addArray);
        Object[] resArray = new Object[]{0, 1, 2, 6, 7, 8, 9, 10, 3, 4, 5, 11};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testGetMethod() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3, 4, 5, 11};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        int indx = 6;
        Object res =   lst.get(indx);
        Object exp = 11;
        assertEquals(exp, res);
    }

    @Test
    public void testRemoteMethod() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3, 4, 5, 11};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        int el = 5;
        ImmutableArrayList res =  (ImmutableArrayList) lst.remove(el);
        Object[] resArray = new Object[]{0, 1, 2, 3, 4, 11};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testSetMethod() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3, 4, 5, 11};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        int el = 5;
        ImmutableArrayList res =  (ImmutableArrayList) lst.set(0, el);
        Object[] resArray = new Object[]{5, 1, 2, 3, 4, 5, 11};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testIndexOfMethod() {
        Object[] simpleArray = new Object[]{0, 1, 2, 3, 4, 5, 11};
        ImmutableArrayList lst = new ImmutableArrayList(simpleArray);
        int el = 12;
        int res =  lst.indexOf(el);
        int exp = -1;
        assertEquals(exp, res);
    }
    
}
