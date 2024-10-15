package Hw2_22000081_NguyenTienDat.Exercise_1;

public class BubbleSort extends Sort {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
                printArray(arr);
            }
        }
    }
}
