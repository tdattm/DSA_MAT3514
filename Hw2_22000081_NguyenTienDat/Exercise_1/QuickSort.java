package Hw2_22000081_NguyenTienDat.Exercise_1;

public class QuickSort extends Sort{
    @Override
    public void sort(int[] arr) {
        System.out.println("Mảng ban đầu: ");
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Tìm vị trí pivot sau khi sắp xếp
            int pivotIndex = partition(arr, low, high);

            // In mảng sau khi phân chia với pivot
            System.out.println("Mảng sau khi phân chia với pivot " + arr[pivotIndex] + ":");
            printArray(arr);

            // Sắp xếp các phần tử bên trái pivot
            quickSort(arr, low, pivotIndex - 1);

            // Sắp xếp các phần tử bên phải pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Chọn phần tử cuối cùng làm pivot
        int i = (low - 1);  // Chỉ số của phần tử nhỏ hơn

        for (int j = low; j < high; j++) {
            comparisons++;  // Tăng biến comparisons mỗi khi có một phép so sánh
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Đưa pivot về đúng vị trí của nó trong mảng đã sắp xếp
        swap(arr, i + 1, high);
        return i + 1;
    }
}
