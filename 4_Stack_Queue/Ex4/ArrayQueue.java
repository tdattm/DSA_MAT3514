package Hw4_22000081_NguyenTienDat.Ex4;
import java.util.*;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    private void resize() {
        int newSize = n * 2; // Kích thước mới gấp đôi kích thước cũ
        E[] newQueue = (E[]) new Object[newSize]; // Khởi tạo mảng mới

        // Sao chép các phần tử từ mảng cũ sang mảng mới
        System.arraycopy(queue, top, newQueue, 0, count);

        queue = newQueue; // Cập nhật mảng queue với mảng mới
        top = 0; // Đặt lại chỉ số top
        n = newSize; // Cập nhật kích thước mới
    }

    @Override
    public void enqueue(E element) {
        // TODO Auto-generated method stub
        if (n == count) {
            resize();
        }

        int rear = (top + count) % n; // Tính vị trí tiếp theo để thêm phần tử
        queue[rear] = element; // Thêm phần tử vào cuối
        count++; // Tăng số lượng phần tử hiện có
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        if (isEmpty()) { // Kiểm tra xem hàng đợi có rỗng hay không
            throw new NoSuchElementException("Queue is empty");
        }
        E element = queue[top]; // Lấy phần tử đầu tiên
        queue[top] = null; // Loại bỏ phần tử
        top = (top + 1) % n; // Di chuyển chỉ số top đến phần tử tiếp theo
        count--; // Giảm số lượng phần tử
        return element; // Trả về phần tử đã lấy
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return count == 0;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return num < count;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
