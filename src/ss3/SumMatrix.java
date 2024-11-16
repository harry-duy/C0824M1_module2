package ss3;

import java.util.Scanner;
public class SumMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng cho mảng: ");
        int soHang = scanner.nextInt();
        System.out.print("Nhập số cột cho mảng: ");
        int soCot = scanner.nextInt();

        double[][] mang2D = new double[soHang][soCot];

        System.out.println("Nhập giá trị cho mỗi phần tử của mảng:");
        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                System.out.print("Phần tử hàng " + i + ", cột " + j + ": ");
                mang2D[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\nMảng 2 chiều vừa nhập:");
        for (double[] row : mang2D) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.print("Nhập số cột muốn tính tổng (tính từ 0): ");
        int cot = scanner.nextInt();
        scanner.close();

        if (cot < 0 || cot >= soCot) {
            System.out.println("Số cột không hợp lệ.");
            return;
        }

        double tong = 0;
        for (double[] row : mang2D) {
            tong += row[cot];
        }

        System.out.println("Tổng của cột " + cot + " là: " + tong);
    }
}
