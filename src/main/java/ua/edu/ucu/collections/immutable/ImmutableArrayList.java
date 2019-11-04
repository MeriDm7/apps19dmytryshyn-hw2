package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public class ImmutableArrayList implements ImmutableList{
    protected final Object[] array_list;

    public ImmutableArrayList(Object[] lst) {
        this.array_list = lst;
    }

    public ImmutableArrayList(){
        this.array_list = new Object[0];
    }

    private void Indx(int index) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    //додає елемент у кінець колекції
    @Override
    public ImmutableList add(Object e) {
        return addAll(size(), new Object[] {e});
        }


    //додає елемент до колекції за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList add(int index, Object e){
        return addAll(index, new Object[] {e});
    }

    //додає масив елементів у кінець колекції
    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    // додає масив елементів починаючи з зазначеного індекса, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList addAll(int index, Object[] c){
        Indx(index);
        Object[] new_array_list = new Object[size() + c.length];
        for (int i = 0; i < index; i++) {
            new_array_list[i] = array_list[i];
        }
        for (int i = 0; i < c.length; i++) {
            new_array_list[index + i] = c[i];
        }
        for (int i = index; i < size(); i++) {
            new_array_list[i + c.length] = array_list[i];
        }
        return new ImmutableArrayList(new_array_list);
    }

    //повертає елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public Object get(int index){
        Indx(index);
        return array_list[index];
    }

    //видаляє елемент за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList remove(int index){
        Indx(index);
        Object[] new_array_list =  new Object[size() - 1];
        for (int i = 0; i < index; i++){
            new_array_list[i] = array_list[i];
        }
        for (int i = index + 1; i < size(); i++) {
            new_array_list[i - 1] = array_list[i];
        }
        return new ImmutableArrayList(new_array_list);
    }

    //змінює значення елементу за індексом, та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableList set(int index, Object e){
        Indx(index);
        Object[] new_array_list = new Object[size()];
        System.arraycopy(array_list, 0, new_array_list, 0, size());
        new_array_list[index] = e;
        return new ImmutableArrayList(new_array_list);
    }

    //шукає індекс елемента (повертає індекс першого який знайшов, або -1 у випадку відсутності)
    @Override
    public int indexOf(Object e){
        for(int i = 0; i < size(); i++){
            if (array_list[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //розмір колекції
    @Override
    public int size(){
        return array_list.length;
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
        Object[] array = new Object[size()];
        System.arraycopy(array_list, 0, array, 0, size());
        return array;
    }

    //повертає рядок, де через кому відображаютсься елементи колекції
    @Override
    public String toString(){
        return Arrays.toString(array_list);
    }




    
}
