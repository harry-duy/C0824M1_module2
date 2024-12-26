package ss11.s3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ReverseArray {

    public static void reverseArray(int[] arr) {
        if (arr == null || arr.length <= 1) { // Xử lý trường hợp null hoặc mảng rỗng/1 phần tử
            return;
        }

        // Sử dụng ArrayDeque (Deque) thay vì Stack vì hiệu suất tốt hơn
        Deque<Integer> stack = new ArrayDeque<>();

        for (int value : arr) {
            stack.push(value); // Đẩy các phần tử vào stack
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop(); // Lấy các phần tử ra và gán lại vào mảng
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        reverseArray(arr1);
        System.out.println("Mảng 1 sau khi đảo ngược: " + Arrays.toString(arr1)); // [5, 4, 3, 2, 1]

        int[] arr2 = {1}; // Test case với 1 phần tử
        reverseArray(arr2);
        System.out.println("Mảng 2 sau khi đảo ngược: " + Arrays.toString(arr2)); // [1]

        int[] arr3 = {}; // Test case với mảng rỗng
        reverseArray(arr3);
        System.out.println("Mảng 3 sau khi đảo ngược: " + Arrays.toString(arr3)); // []

        int[] arr4 = null; // Test case với mảng null
        reverseArray(arr4); // Không gây lỗi
        System.out.println("Mảng 4 (null) sau khi đảo ngược: " + Arrays.toString(arr4)); // null

    }
}
