package linkedList.core;

import java.util.LinkedList;

public interface MyLinkedList<T> {

    public T getIndex(int index);
    public boolean remove (T element);
    public int size ();
    public void clear();
    public void add(T element, int index);
    public void addElement(T element);

}