package Hw2_22000081_NguyenTienDat.Exercise_2;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            printArray(arr);
        }
    }
}
