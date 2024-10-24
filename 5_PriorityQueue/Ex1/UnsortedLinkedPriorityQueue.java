package Hw5_22000081_NguyenTienDat.Ex1;

import java.util.NoSuchElementException;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K extends Comparable, E> implements Entry<K, E>{
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
            this.key = k;
            this.element = e;
            this.next = null;
        }

        public K getKey() {return this.key;}
        public E getValue() {return this.element;}
        public NodeEntry<K, E> getNext() { return next;}
        public void setNext(NodeEntry<K, E> next) {this.next = next;}
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() {return n;}

    @Override
    public boolean isEmpty() {return n == 0;}

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry newNode = (NodeEntry) entry;
        newNode.setNext(head);
        head = newNode;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Entry newEntry = new NodeEntry((K) k, (E) e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry min = this.min();
        if (min == null) throw new IllegalArgumentException("Priority Queue is empty!");
        if (min == head) {
            head = head.next;
            return min;
        }

        NodeEntry current = head;
        while (current.next != null) {
            if (current.next == min) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) throw new NoSuchElementException("Priority Queue is null");
        Entry min = head;
        NodeEntry<K, E> current = head.next;
        while (current != null) {
            if (((Comparable) min.getKey()).compareTo(current.getKey()) == 1) min = current;
            current = current.next;
        }
        return min;
    }
}
