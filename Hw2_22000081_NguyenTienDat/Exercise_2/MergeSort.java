package Hw2_22000081_NguyenTienDat.Exercise_2;
import java.util.*;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] array) {
        System.out.println("***Mảng trước khi chia:");
        printArray(array);

        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        System.out.println("Chia mảng thành:");
        printArray(left);
        printArray(right);

        sort(left);
        sort(right);

        merge(array, left, right);

        System.out.println("Mảng sau khi hợp nhất:");
        printArray(array);
    }

    private void merge(T[] array, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            comparisons++;
            if (compare(left[i], right[j]) <= 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}

