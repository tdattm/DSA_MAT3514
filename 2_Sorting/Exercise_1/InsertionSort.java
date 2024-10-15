package Hw2_22000081_NguyenTienDat.Exercise_1;

public class InsertionSort extends Sort{
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                comparisons++;
                arr[j+1] = arr[j];
                j--;
                swaps++;
            }
            arr[j+1] = key;
            printArray(arr);
        }
    }
}
