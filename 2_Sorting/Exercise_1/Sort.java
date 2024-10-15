package Hw2_22000081_NguyenTienDat.Exercise_1;

public abstract class Sort {
    protected int comparisons = 0; // Count comparisons
    protected int swaps = 0; // Count swaps

    public abstract void sort(int[] arr);

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    protected void swap(int[] arr, int i, int j) {
        swaps++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    // Reset counters for each sort
    public void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }
}
