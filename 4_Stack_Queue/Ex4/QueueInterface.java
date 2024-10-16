package Hw4_22000081_NguyenTienDat.Ex4;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
