package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    ImmutableArrayList empty = new ImmutableArrayList();
    ImmutableArrayList lst = new ImmutableArrayList(new Object[] {1, 2, 3});
    
    @Test
    public void testAddMethod1() {
        ImmutableArrayList res =  (ImmutableArrayList) lst.add(5);
        Object[] resArray = new Object[]{1, 2, 3, 5};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddEmptyMethod2() {
        ImmutableArrayList res =  (ImmutableArrayList) empty.add(5, 1);
    }

    @Test
    public void testAddMethod2() {
        ImmutableArrayList res =  (ImmutableArrayList) lst.add(2, 7);
        Object[] resArray = new Object[]{1, 2, 7, 3};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testAddAllMethod1() {
        Object[] addArray = new Object[]{5, 6, 7};
        ImmutableArrayList res =  (ImmutableArrayList) lst.addAll(addArray);
        Object[] resArray = new Object[]{1, 2, 3, 5, 6, 7};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllEmptyMethod2() {
        Object[] addArray = new Object[]{6, 7, 8, 9, 10};
        ImmutableArrayList res =  (ImmutableArrayList) empty.addAll(5, addArray);
    }

    @Test
    public void testAddAllMethod2() {
        Object[] addArray = new Object[]{6, 7, 8, 9, 10};
        ImmutableArrayList res =  (ImmutableArrayList) lst.addAll(2, addArray);
        Object[] resArray = new Object[]{1, 2, 6, 7, 8, 9, 10, 3};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test
    public void testGetMethod() {
        int indx = 2;
        Object res =   lst.get(indx);
        Object exp = 3;
        assertEquals(exp, res);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetEmptyMethod() {
        int indx = 2;
        Object res =  empty.get(indx);
    }

    @Test
    public void testRemoteMethod() {
        int el = 1;
        ImmutableArrayList res =  (ImmutableArrayList) lst.remove(el);
        Object[] resArray = new Object[]{1, 3};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoteEmptyMethod() {
        int el = 4;
        ImmutableArrayList res =  (ImmutableArrayList) lst.remove(el);
    }

    @Test
    public void testSetMethod() {
        int el = 5;
        ImmutableArrayList res =  (ImmutableArrayList) lst.set(0, el);
        Object[] resArray = new Object[]{5, 2, 3};
        assertArrayEquals(resArray, res.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyMethod() {
        int el = 4;
        int indx = 10;
        ImmutableArrayList res =  (ImmutableArrayList) lst.set(indx, el);
    }

    @Test
    public void testIndexOfMethod() {
        int el = 2;
        int res =  lst.indexOf(el);
        int exp = 1;
        assertEquals(exp, res);
    }

    @Test
    public void testIndexOfNoneMethod() {
        int el = 12;
        int res =  lst.indexOf(el);
        int exp = -1;
        assertEquals(exp, res);
    }

    @Test
    public void testSizeMethod() {
        int res =  lst.size();
        int exp = 3;
        assertEquals(exp, res);
    }

    @Test
    public void testClearMethod() {
        ImmutableArrayList res = (ImmutableArrayList) lst.clear();
        ImmutableArrayList exp = empty;
        assertArrayEquals(exp.toArray(), res.toArray());
    }

    @Test
    public void testIsEmptyMethod() {
        boolean res =  lst.isEmpty();
        boolean exp = false;
        assertEquals(exp, res);
    }

    @Test
    public void testIsEmptyMethodEmpty() {
        boolean res =  empty.isEmpty();
        boolean exp = true;
        assertEquals(exp, res);
    }

    @Test
    public void testToArrayMethod() {
        Object[] res =  lst.toArray();
        Object[] exp = {1, 2, 3};
        assertArrayEquals(exp, res);
    }

    @Test
    public void testToStringMethod() {
        assertEquals(Arrays.toString(new Object[] {1, 2, 3}), lst.toString());
    }
    
}
