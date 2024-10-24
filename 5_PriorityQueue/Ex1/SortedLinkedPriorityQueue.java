package Hw5_22000081_NguyenTienDat.Ex1;

public class SortedLinkedPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface<K, E> {

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

        public String toString() {
            return String.format("Key: %s - Element: %s\n", key.toString(), element.toString());
        }
    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() { return n;}

    @Override
    public boolean isEmpty() { return n==0;}

    @Override
    public void insert(Entry<K, E> entry) {
        NodeEntry newNode = (NodeEntry) entry;
        if (head == null || head.getKey().compareTo(newNode.getKey()) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            NodeEntry current = head;
            while (current.next != null && current.next.getKey().compareTo(newNode.getKey()) < 0){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Entry newNode = new NodeEntry(k, e);
        insert(newNode);
    }

    @Override
    public Entry<K, E> removeMin() {
        return null;
    }

    @Override
    public Entry<K, E> min() {
        return null;
    }
}
