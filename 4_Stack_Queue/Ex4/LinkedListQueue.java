package Hw4_22000081_NguyenTienDat.Ex4;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements QueueInterface<E> {

    class Node<E> { // Lớp Node đại diện cho từng phần tử trong danh sách liên kết
        E data; // Dữ liệu của nút
        Node<E> next; // Tham chiếu đến nút tiếp theo

        Node(E data) {
            this.data = data; // Khởi tạo dữ liệu
            this.next = null; // Mặc định next là null
        }
    }

    private Node<E> front; // Phần tử đầu tiên trong hàng đợi
    private Node<E> rear; // Phần tử cuối cùng trong hàng đợi
    private int size; // Số lượng phần tử hiện tại trong hàng đợi

    // Constructor khởi tạo hàng đợi
    public LinkedListQueue() {
        front = null; // Mặc định front là null
        rear = null; // Mặc định rear là null
        size = 0; // Mặc định kích thước là 0
    }

    // Phương thức thêm phần tử vào cuối hàng đợi
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element); // Tạo nút mới chứa phần tử
        if (isEmpty()) { // Nếu hàng đợi rỗng
            front = newNode; // Phần tử đầu tiên là nút mới
        } else {
            rear.next = newNode; // Thêm nút mới vào cuối
        }
        rear = newNode; // Cập nhật rear là nút mới
        size++; // Tăng kích thước hàng đợi
    }

    // Phương thức lấy và loại bỏ phần tử đầu tiên khỏi hàng đợi
    @Override
    public E dequeue() {
        if (isEmpty()) { // Kiểm tra xem hàng đợi có rỗng hay không
            throw new NoSuchElementException("Queue is empty");
        }
        E element = front.data; // Lấy dữ liệu của phần tử đầu tiên
        front = front.next; // Di chuyển front đến phần tử tiếp theo
        if (front == null) { // Nếu hàng đợi trở nên rỗng
            rear = null; // Cập nhật rear thành null
        }
        size--; // Giảm kích thước hàng đợi
        return element; // Trả về phần tử đã lấy
    }

    // Phương thức kiểm tra hàng đợi có rỗng hay không
    @Override
    public boolean isEmpty() {
        return size == 0; // Hàng đợi rỗng khi kích thước bằng 0
    }

    // Phương thức trả về kích thước của hàng đợi
    public int size() {
        return size; // Trả về kích thước hiện tại
    }

    // Phương thức trả về Iterator cho hàng đợi
    @Override
    public Iterator<E> iterator() {
        return new LinkedQueueIterator();
    }

    // Lớp Iterator nội bộ cho LinkedQueue
    private class LinkedQueueIterator implements Iterator<E> {
        private Node<E> current = front; // Vị trí hiện tại của Iterator

        // Kiểm tra xem có phần tử tiếp theo hay không
        @Override
        public boolean hasNext() {
            return current != null; // Nếu current không null, còn phần tử tiếp theo
        }

        // Trả về phần tử tiếp theo trong hàng đợi
        @Override
        public E next() {
            if (!hasNext()) { // Nếu không còn phần tử nào, ném ngoại lệ
                throw new NoSuchElementException();
            }
            E data = current.data; // Lấy dữ liệu tại vị trí hiện tại
            current = current.next; // Di chuyển current đến phần tử tiếp theo
            return data; // Trả về phần tử
        }
    }
}

