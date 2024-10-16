package Hw3_22000081_NguyenTienDat.Ex2_3_4;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList(){
        if (n <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        array = (T[]) new Object[n];
    }

    public void resize() {
        int newSize = array.length * 2;
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    public void add(T data) {
        if (n > defaultSize) {
            resize();
        }

        array[n++] = data;
    }

    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException();
        }
        array[i] = data;
    }

    public void remove(T data) {
        for (int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                System.arraycopy(data, i + 1, data, i, n - i - 1);
                n--;
                return;
            }
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if(array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public int indexOf(T data){
        if (isContain(data)) {
            for (int i = 0; i < n; i++) {
                if (array[i].equals(data)){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0; // Chỉ số hiện tại

            public boolean hasNext() {
                return index < n; // Kiểm tra xem còn phần tử tiếp theo không
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(); // Ném ngoại lệ nếu không còn phần tử
                }
                return array[index++]; // Trả về phần tử hiện tại và tăng chỉ số
            }
        };
    }
}