package ss3;
import java.util.Scanner;
public class insert_array {
    public static void main(String[] args) {

        int N = 10;
        int[] arr = new int[N];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap 5 phan tu dau tien cua mang: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Phan tu thu " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Nhap gia tri can chen: ");
        int X = scanner.nextInt();

        System.out.print("Nhap vi tri can chen (0 - 9): ");
        int index = scanner.nextInt();


        if (index < 0 || index >= N) {
            System.out.println("Khong the chen vao vi tri nay.");
        } else {

            for (int i = N - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = X;

            System.out.print("Mang sau khi chen: ");
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        scanner.close();
    }
}
