package ss14.s6;

public class InsertionSort {

    public static void insertionSort(int[] list) {
        int n = list.length;
        for (int i = 1; i < n; i++) {
            int key = list[i];
            int j = i - 1;

            /* Di chuyển các phần tử của list[0..i-1], mà lớn hơn key,
               đến một vị trí phía trước vị trí hiện tại của chúng */
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};
        System.out.println("Mảng trước khi sắp xếp: " + java.util.Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("Mảng sau khi sắp xếp: " + java.util.Arrays.toString(numbers));
    }
}
