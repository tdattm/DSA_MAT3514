package Hw2_22000081_NguyenTienDat.Exercise_2;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
                printArray(array);
            }
        }
    }
}
