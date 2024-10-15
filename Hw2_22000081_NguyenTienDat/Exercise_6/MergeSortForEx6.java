package Hw2_22000081_NguyenTienDat.Exercise_6;
import java.util.Random;

public class MergeSortForEx6 {
    static Random rand = new Random();

    // Hàm chính để thực hiện merge sort
    private static void MergeSort(int[] array) {
        if (array.length < 2) {
            return; // Mảng có ít hơn 2 phần tử đã được coi là sắp xếp
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Chia mảng thành 2 nửa
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Đệ quy sắp xếp nửa trái và nửa phải
        MergeSort(left);
        MergeSort(right);

        // Hợp nhất 2 mảng đã sắp xếp
        merge(array, left, right);
    }

    // Hàm để hợp nhất 2 mảng đã sắp xếp
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // So sánh từng phần tử của 2 mảng và hợp nhất vào mảng chính
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Sao chép các phần tử còn lại của mảng trái (nếu có)
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Sao chép các phần tử còn lại của mảng phải (nếu có)
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int n = rand.nextInt(10) + 1;
        int k = rand.nextInt(n) + 1;
        int[] arr = generateRandomArray(n);
        System.out.println("Array size: " + n);
        System.out.println("Array before sorting: ");
        printArray(arr);
        MergeSort(arr);
        System.out.println("Array after sorting: ");
        printArray(arr);
        System.out.print(String.format("The %d'th smallest element is: ", k) + arr[k-1]);
        System.out.println();
    }
}

