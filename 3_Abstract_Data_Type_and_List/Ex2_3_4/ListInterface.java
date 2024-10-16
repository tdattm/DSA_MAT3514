package Hw3_22000081_NguyenTienDat.Ex2_3_4;

public interface ListInterface<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
}
