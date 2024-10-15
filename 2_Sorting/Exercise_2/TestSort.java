package Hw2_22000081_NguyenTienDat.Exercise_2;
import java.util.Arrays;
import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        // Ví dụ với Integer
        Integer[] intArray = generateRandomIntegerArray(5);
        System.out.println("Integer array before sorting:");
        System.out.println(Arrays.toString(intArray));
        testSort(new BubbleSort<>(), intArray);

        // Ví dụ với String
        String[] stringArray = {"apple", "orange", "banana", "grape", "cherry"};
        System.out.println("String array before sorting:");
        System.out.println(Arrays.toString(stringArray));
        testSort(new BubbleSort<>(), stringArray);
    }

    private static Integer[] generateRandomIntegerArray(int n) {
        Random rand = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
        return arr;
    }

    private static <T extends Comparable<T>> void testSort(Sort<T> sortAlgorithm, T[] originalArray) {
        T[] arr = Arrays.copyOf(originalArray, originalArray.length);
        sortAlgorithm.resetCounters(); // Reset counters before sorting

        long start = System.nanoTime();
        sortAlgorithm.sort(arr);
        long end = System.nanoTime();

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
        printResults(sortAlgorithm.getClass().getSimpleName(), sortAlgorithm.getComparisons(), sortAlgorithm.getSwaps(), start, end);
    }

    private static void printResults(String algorithm, int comparisons, int swaps, long start, long end) {
        System.out.println(algorithm + ":");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Execution time (ns): " + (end - start));
        System.out.println();
    }
}
