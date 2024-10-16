package Hw4_22000081_NguyenTienDat.Ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node stack = null;

    @Override
    public void push(E element) {
        // TODO Auto-generated method stub
        Node newNode = new Node(element);
        newNode.next = stack;
        stack = newNode;
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        Node currentNode = stack;
        stack = stack.next;
        return currentNode.element;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return stack == null;
    }

    @Override
    public E top() {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return currentNode != null;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the stack");
            }
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
