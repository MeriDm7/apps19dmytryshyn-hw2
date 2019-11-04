package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private  Node head;
    private int len;

    public ImmutableLinkedList() {
        this.head = null;
        this.len = 0;
    }

    public ImmutableLinkedList(Object[] c) {
        this.len = c.length;
        if (c.length != 0) {
            this.head = new Node(c[0]);
            Node current = this.head;
            for (int i = 1; i < c.length; i++) {
                current.next = new Node(c[i]);
                current = current.next;
            }
        }
    }

    private static class Node {
        private Object value;
        private Node next;

        private Node() {
            this.value = null;
            this.next = null;
        }

        private Node(Object value) {
            this.value = value;
            this.next = null;
        }

        private Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node getNode(int index) {
        indx(index);
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void indx(int index) throws IndexOutOfBoundsException {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableLinkedList copy() {
        if (this.len == 0) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList copied = new ImmutableLinkedList();
        copied.len = this.len;
        copied.head = new Node(this.head.value);
        Node current = this.head.next;
        Node temp = copied.head;
        while (current != null) {
            temp.next = new Node(current.value);
            temp = temp.next;
            current = current.next;
        }
        return copied;
    }

    //додає елемент у кінець колекції
    @Override
    public ImmutableLinkedList add(Object e) {
        return addAll(this.len, new Object[] {e});
    }

    //додає елемент до колекції за індексом,
    // та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    //додає масив елементів у кінець колекції
    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(this.len, c);
    }

    // додає масив елементів починаючи з зазначеного індекса,
    // та кидає виключну ситуацію, якщо індекс виходить за межі колекції
    @Override
    public  ImmutableLinkedList addAll(int index, Object[] c) {
        indx(index);
        ImmutableLinkedList newlst = copy();
        newlst.len = this.len + c.length;
        newlst.head = new Node(null, newlst.head);
        Node temp = newlst.getNode(index);
        for (int i = 0; i < c.length; i++) {
            temp.next = new Node(c[i], temp.next);
            temp = temp.next;
        }
        newlst.head = newlst.head.next;
        return newlst;
    }

    //повертає елемент за індексом, та кидає виключну
    // ситуацію, якщо індекс виходить за межі колекції
    @Override
    public Object get(int index) {
        if (this.len == 0) {
            throw new IndexOutOfBoundsException();
        }
        indx(index);
        return getNode(index).value;
    }

    //видаляє елемент за індексом, та кидає виключну
    // ситуацію, якщо індекс виходить за межі колекції
    @Override
    public ImmutableLinkedList remove(int index) {
        indx(index);
        if (this.len == 0) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList lstnew = copy();
        lstnew.len = this.len - 1;
        if (index == 0) {
            lstnew.head = lstnew.head.next;
        }
        else {
            Node prev = lstnew.getNode(index -1);
            prev.next = prev.next.next;
        }
        return lstnew;
    }

    //змінює значення елементу за індексом,
    // та кидає виключну ситуацію, якщо індекс
    // виходить за межі колекції
    @Override
    public ImmutableList set(int index, Object e) {
        if (this.len == 0) {
            throw new IndexOutOfBoundsException();
        }
        indx(index);
        ImmutableLinkedList lstnew = copy();
        lstnew.len = this.len;
        Node cur = lstnew.getNode(index);
        cur.value = e;
        return lstnew;
    }

    //шукає індекс елемента (повертає індекс
    // першого який знайшов, або -1 у випадку відсутності)
    @Override
    public int indexOf(Object e) {
        Node current = this.head;
        for (int i = 0; i < this.len; i++) {
            if (current.value == e) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    //розмір колекції
    @Override
    public int size() {
        return this.len;
    }

    //очищує вміст колекції
    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    //якщо у колеції нема елементів то повертає true
    @Override
    public boolean isEmpty() {
        if (len == 0) {
            return true;
        }
        return false;
    }

    //перетворює колекцію до масиву обєктів
    @Override
    public Object[] toArray() {
        Object[] res = new Object[len];
        Node current = this.head;
        for (int i = 0; i < len; i++) {
            res[i] = current.value;
            current = current.next;
        }
        return res;
    }

    //повертає рядок, де через кому
    // відображаютсься елементи колекції
    @Override
    public String toString() {
        if (this.len == 0) {
            return "";
        }
        String res = Integer.toString((Integer) this.head.value);
        Node current = this.head;
        for (int i = 0; i < this.len - 1; i++) {
            current = current.next;
            res = res + "," + current.value;
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return addAll(0, new Object[] {e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return addAll(this.len, new Object[] {e});
    }

    public Object getFirst(){
        return get(0);
    }

    public Object getLast(){
        return get(this.len - 1);
    }

    public ImmutableLinkedList removeFirst(){
        return remove(0);
    }

    public ImmutableLinkedList removeLast(){
        return remove(this.len - 1);
    }




}
