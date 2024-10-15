package Hw2_22000081_NguyenTienDat.Exercise_1;

public class MergeSort extends Sort{
    @Override
    // Hàm chính để thực hiện merge sort
    public void sort(int[] array) {
        System.out.println("***Mảng trước khi chia:");
        printArray(array);

        if (array.length < 2) {
            return; // Mảng có ít hơn 2 phần tử đã được coi là sắp xếp
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Chia mảng thành 2 nửa
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // In trạng thái mảng sau khi chia
        System.out.println("Chia mảng thành:");
        printArray(left);
        printArray(right);

        // Đệ quy sắp xếp nửa trái và nửa phải
        sort(left);
        sort(right);

        // Hợp nhất 2 mảng đã sắp xếp
        merge(array, left, right);

        // In mảng sau khi hợp nhất
        System.out.println("Mảng sau khi hợp nhất:");
        printArray(array);
    }

    // Hàm để hợp nhất 2 mảng đã sắp xếp
    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // So sánh từng phần tử của 2 mảng và hợp nhất vào mảng chính
        while (i < left.length && j < right.length) {
            comparisons++;
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
}
