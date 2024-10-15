package Hw2_22000081_NguyenTienDat.Exercise_2;

public abstract class Sort<T extends Comparable<T>> {
    protected int comparisons = 0;
    protected int swaps = 0;

    public abstract void sort(T[] array);

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    public void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    protected int compare(T a, T b) {
        comparisons++;
        return a.compareTo(b);
    }

    protected void swap(T[] array, int i, int j) {
        swaps++;
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(T[] arr) {
        System.out.print("[");
        for (T i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}

