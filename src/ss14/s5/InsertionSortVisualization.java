package ss14.s5;

import java.util.Arrays;

public class InsertionSortVisualization {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            System.out.println("Bước " + i + ": Chèn phần tử " + key);
            System.out.println("Mảng hiện tại trước khi so sánh: " + Arrays.toString(arr));

            /* Di chuyển các phần tử của arr[0..i-1], mà lớn hơn key,
               đến một vị trí phía trước vị trí hiện tại của chúng */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                System.out.println("  Di chuyển " + arr[j + 1] + ": " + Arrays.toString(arr));
            }
            arr[j + 1] = key;
            System.out.println("Mảng sau khi chèn " + key + ": " + Arrays.toString(arr));
            System.out.println("------------------");
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }
}
