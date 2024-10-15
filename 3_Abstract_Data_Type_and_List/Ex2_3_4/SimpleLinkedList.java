package Hw3_22000081_NguyenTienDat.Ex2_3_4;
import java.util.LinkedList;
import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T> {
    class Node {
        T data ;
        Node next ;
    }

    private Node top = null ;
    private Node bot = null ;
    private int n = 0;
    public void add (T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            top = newNode;
            bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int idx = 0; idx < i; idx++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int idx = 0; idx < i; idx++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isConstrain(T data) {
        Node currentNode = top;
        for (int i = 0; i < n; i++) {
            if (currentNode.data.equals(data)) {
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            throw new IllegalStateException("Danh sách rỗng");
        }
        T data = top.data;
        top = top.next;
        n--;
        if (isEmpty()) {
            top = bot = null;
        }
        return data;
    }

    public T removeBot() {
        if (isEmpty()) {
            throw new IllegalStateException("Danh sách rỗng");
        }
        T data = bot.data;
        if (bot == top) {
            bot = top = null;
        } else {
            Node current = top;
            for(int i = 0; i < n - 2; i++) {
                current = current.next;
            }
            current.next = null;
            bot = current;
        }
        n--;
        return data;
    }

    public void remove(T data) {
        if (isEmpty()) {
            throw new IllegalStateException("Danh sách rỗng");
        }
        if (top.data.equals(data)) {
            removeTop();
            return;
        }
        Node current = top;
        while(current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                n--;
                if (current.next == null) {
                    bot = current;
                }
                return;
            }
            current = current.next;
        }
    }


}
