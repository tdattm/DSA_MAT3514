package Hw2_22000081_NguyenTienDat.Exercise_2;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            arr[j + 1] = key;
            printArray(arr);
        }
    }
}

