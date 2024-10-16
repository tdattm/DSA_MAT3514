package Hw4_22000081_NguyenTienDat.Ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E> {
    private E[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 1000;

    public ArrayStack() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Tăng gấp đôi kích thước của mảng nếu đã full.
    public void resize(){
        E[] newArray = (E[]) new Object[2*size];
        System.arraycopy(array, 0, newArray,0, size);
        array = newArray;
    }

    @Override
    public void push(E element){
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    @Override
    public E pop(){
        if (isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        E element = array[--size];
        array[size] = null;
        return element;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public E top(){
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return array[size - 1];
    }

    public Iterator<E> iterator(){
        return new Iterator<E>() {
            private int currentIndex = size - 1; //Duyet tu tren xuong

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return array[currentIndex--];
            }
        };
    }
}
