package Hw2_22000081_NguyenTienDat.Exercise_1;

public class SelectionSort extends Sort{
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                comparisons++;
                if (arr[j] < arr[minIndex]){
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
