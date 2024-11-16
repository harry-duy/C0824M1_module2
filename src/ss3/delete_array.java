package ss3;

import java.util.Scanner;

public class delete_array {
    public static void main(String[] args) {

        int N = 10;
        int[] arr = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Mang ban dau: ");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Nhap phan tu can xoa: ");
        int X = scanner.nextInt();

        int index_del = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] == X) {
                index_del = i;
                break;
            }
        }

        if (index_del != -1) {

            for (int i = index_del; i < N - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[N - 1] = 0;

            System.out.print("Mang sau khi xoa " + X + ": ");
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Phan tu " + X + " khong ton tai trong mang.");
        }

        scanner.close();
    }
}
