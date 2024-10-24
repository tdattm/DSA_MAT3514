package Hw5_22000081_NguyenTienDat.Ex1;

import java.util.NoSuchElementException;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public E getValue() {
            return this.element;
        }
    }

    ArrEntry<K, E>[] array;  // Mảng lưu các phần tử đã sắp xếp
    int n = 0;  // Số phần tử hiện tại
    int defaultsize = 1000;  // Kích thước mặc định
    int head = 0;

    // Constructor khởi tạo mảng
    @SuppressWarnings("unchecked")
    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];
    }


    @SuppressWarnings("unchecked")
    public SortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    public void reSize() {
        // Tạo mảng mới với kích thước gấp đôi mảng cũ
        int newSize = array.length * 3/2;
        ArrEntry<K, E>[] newArray = new ArrEntry[newSize];

        // Sao chép phần tử từ mảng cũ sang mảng mới theo thứ tự đã sắp xếp
        for (int i = 0; i < n; i++) {
            newArray[i] = array[(head + i) % array.length];
        }

        // Cập nhật mảng và các biến liên quan
        array = newArray;
        head = 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n >= defaultsize) {
            reSize();
        }
        int position = (head + n) % array.length;
        int positionOrd = n;

        // Find position of added data
        for (int i=0; i<n; i++) {
            int index = (head + i) % array.length;
            if (array[index].getKey().compareTo(entry.getKey()) == 1) {
                position = index;
                positionOrd = i;
                break;
            }
        }

        for (int i = n; i > positionOrd; i--) {
            int index = (head + i) % array.length;
            int preInd = (head + i - 1) % array.length;
            array[index] = array[preInd];
        }
        array[position] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(K k, E e) {
        Entry newEntry = new ArrEntry(k, e);
        insert(newEntry);
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority Queue is null");
        Entry min = array[head];
        array[head] = null;
        head++;
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return array[head];
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
