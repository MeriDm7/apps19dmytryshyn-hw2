package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
     private Object[] array;

    public ImmutableArrayList(Object[] array) {
        this.array = array;
    }

    public ImmutableArrayList() {
        this.array = new Object[0];
    }

    private void indx(int index) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    //додає елемент у кінець колекції
    @Override
    public ImmutableList add(Object e) {
        return addAll(size(), new Object[] {e});
        }


    //додає елемент до колекції за індексом, та кидає виключну
    // ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    //додає масив елементів у кінець колекції
    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    // додає масив елементів починаючи з зазначеного індекса,
    // та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        indx(index);
        Object[] newarraylist = new Object[size() + c.length];
        for (int i = 0; i < index; i++) {
            newarraylist[i] = array[i];
        }
        for (int i = 0; i < c.length; i++) {
            newarraylist[index + i] = c[i];
        }
        for (int i = index; i < size(); i++) {
            newarraylist[i + c.length] = array[i];
        }
        return new ImmutableArrayList(newarraylist);
    }

    //повертає елемент за індексом, та кидає виключну ситуацію,
    // якщо індекс виходить за межі колекції
    @Override
    public Object get(int index) {
        indx(index);
        return array[index];
    }

    //видаляє елемент за індексом, та кидає виключну
    // ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList remove(int index) {
        indx(index);
        Object[] newarraylist =  new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            newarraylist[i] = array[i];
        }
        for (int i = index + 1; i < size(); i++) {
            newarraylist[i - 1] = array[i];
        }
        return new ImmutableArrayList(newarraylist);
    }

    //змінює значення елементу за індексом, та кидає
    // виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList set(int index, Object e) {
        indx(index);
        Object[] newarraylist = new Object[size()];
        System.arraycopy(array, 0, newarraylist, 0, size());
        newarraylist[index] = e;
        return new ImmutableArrayList(newarraylist);
    }

    //шукає індекс елемента (повертає індекс першого
    // який знайшов, або -1 у випадку відсутності)
    @Override
    public int indexOf(Object e) {
        for(int i = 0; i < size(); i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //розмір колекції
    @Override
    public int size(){
        return array.length;
    }

    //очищує вміст колекції
    @Override
    public  ImmutableList clear() {
        return new ImmutableArrayList();
    }

    //якщо у колеції нема елементів то повертає true
    @Override
    public  boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    //перетворює колекцію до масиву обєктів
    @Override
    public Object[] toArray(){
        Object[] arraynew = new Object[size()];
        System.arraycopy(array, 0, arraynew, 0, size());
        return arraynew;
    }

    //повертає рядок, де через кому відображаютсься елементи колекції
    @Override
    public String toString(){
        return Arrays.toString(array);
    }




    
}
