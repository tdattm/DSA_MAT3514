package Hw2_22000081_NguyenTienDat.Exercise_2;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] arr) {
        System.out.println("Mảng ban đầu: ");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            System.out.println("Mảng sau khi phân chia với pivot " + arr[pivotIndex] + ":");
            printArray(arr);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (compare(arr[j], pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }
}

