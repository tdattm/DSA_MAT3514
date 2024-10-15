package Hw2_22000081_NguyenTienDat.Exercise_1;

import java.util.Arrays;
import java.util.Random;

public class TestSort {
    private static final String[] sortAlgorithms = {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort", "QuickSort"};
    private static final long[][] executionTimes = new long[sortAlgorithms.length][5]; // 5 là số giá trị n

    public static void main(String[] args) {
        int[] inputSizes = {5, 10, 50, 100, 200};
        for (int nIndex = 0; nIndex < inputSizes.length; nIndex++) {
            int n = inputSizes[nIndex];
            int[] arr = generateRandomArray(n);
            System.out.println("Array size: " + n);

            // Test Bubble Sort
            System.out.println("1. Bubble Sort :");
            executionTimes[0][nIndex] = testSort(new BubbleSort(), arr);

            // Test Selection Sort
            System.out.println("2. Selection Sort :");
            executionTimes[1][nIndex] = testSort(new SelectionSort(), arr);

            // Test Insertion Sort
            System.out.println("3. Insertion Sort :");
            executionTimes[2][nIndex] = testSort(new InsertionSort(), arr);

            // Test Merge Sort
            System.out.println("4. Merge Sort :");
            executionTimes[3][nIndex] = testSort(new MergeSort(), arr);

            // Test Quick Sort
            System.out.println("5. QuickSort :");
            executionTimes[4][nIndex] = testSort(new QuickSort(), arr);
        }

        // In bảng kết quả sau khi chạy tất cả các thuật toán
        printExecutionTimeTable(inputSizes);


    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
        return arr;
    }

    private static long testSort(Sort sortAlgorithm, int[] originalArray) {
        int[] arr = Arrays.copyOf(originalArray, originalArray.length);
        sortAlgorithm.resetCounters(); // Reset counters before sorting

        long start = System.nanoTime();
        sortAlgorithm.sort(arr);
        long end = System.nanoTime();

        printResults(sortAlgorithm.getClass().getSimpleName(), sortAlgorithm.getComparisons(), sortAlgorithm.getSwaps(), start, end);

        return end - start; // Trả về thời gian thực thi
    }


    private static void printResults(String algorithm, int comparisons, int swaps, long start, long end) {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Execution time (ns): " + (end - start));
        System.out.println();
    }

    private static void printExecutionTimeTable(int[] inputSizes) {
        // In tiêu đề bảng
        System.out.printf("%-15s", "Algorithm");
        for (int size : inputSizes) {
            System.out.printf("%15d", size);
        }
        System.out.println();

        // In thời gian thực thi của từng thuật toán
        for (int i = 0; i < sortAlgorithms.length; i++) {
            System.out.printf("%-15s", sortAlgorithms[i]);
            for (int j = 0; j < inputSizes.length; j++) {
                System.out.printf("%15d", executionTimes[i][j]);
            }
            System.out.println();
        }
    }
}

