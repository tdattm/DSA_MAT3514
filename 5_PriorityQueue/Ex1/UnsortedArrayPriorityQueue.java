package Hw5_22000081_NguyenTienDat.Ex1;

import java.util.NoSuchElementException;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriorityQueueInterface {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {return this.key;}

        @Override
        public E getValue() {return this.element;}
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 1000;

    @SuppressWarnings("unchecked")
    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }

    @SuppressWarnings("unchecked")
    public UnsortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
    }

    @Override
    public int size() {return this.n;}

    @Override
    public boolean isEmpty() {return n==0;}

    public void reSize() {
        // Tạo mảng mới với kích thước gấp đôi
        int newSize = array.length * 3/2;
        ArrEntry<K, E>[] newArray = new ArrEntry[newSize];

        // Sao chép các phần tử từ mảng cũ sang mảng mới
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }

        // Cập nhật mảng và kích thước mới
        array = newArray;
    }

    @Override
    public void insert(Entry entry) {
        if (n >= defaultsize) {
            reSize();
        }
        array[n++] = new ArrEntry<>((K) entry.getKey(),(E) entry.getValue());
    }

    @Override
    public void insert(Object o, Object o2) {
        if (n >= defaultsize) {
            reSize();
        }
        array[n++] = new ArrEntry<>((K) o, (E) o2);
    }

    @Override
    public Entry removeMin() {
        if (isEmpty()) throw new NoSuchElementException("Array is empty");
        int minIdx = 0;
        for (int i = 0; i < n; i++) {
            if(array[minIdx].getKey().compareTo(array[i].getKey()) < 0) minIdx = i;
        }

        Entry minEntry = array[minIdx];
        array[minIdx] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    @Override
    public Entry min() {
        if (isEmpty()) {throw new NoSuchElementException("Array is empty");}

        Entry min = array[0];
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo(array[0].getKey()) < 0) min = array[i];
        }
        return min;
    }

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> pq = new UnsortedArrayPriorityQueue<>();

        // Thêm phần tử vào hàng đợi
        pq.insert(3, "Công việc 3");
        pq.insert(1, "Công việc 1");
        pq.insert(2, "Công việc 2");

        // Lấy phần tử có key nhỏ nhất
        System.out.println("Phần tử nhỏ nhất: " + pq.min().getValue());  // Công việc 1

        // Xóa phần tử có key nhỏ nhất
        pq.removeMin();
        System.out.println("Phần tử nhỏ nhất sau khi xóa: " + pq.min().getValue());  // Công việc 2
    }
}
