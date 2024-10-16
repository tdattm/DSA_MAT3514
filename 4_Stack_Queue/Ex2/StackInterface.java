package Hw4_22000081_NguyenTienDat.Ex2;

import java.util.Iterator;

public interface StackInterface<E> extends Iterable<E> {
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
