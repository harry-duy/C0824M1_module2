package ss3;
import java.util.Scanner;
public class tongDuongCheoChinhOfMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của ma trận vuông: ");
        int kichThuoc = scanner.nextInt();

        double[][] maTranVuong = new double[kichThuoc][kichThuoc];

        System.out.println("Nhập giá trị cho mỗi phần tử của ma trận:");
        for (int i = 0; i < kichThuoc; i++) {
            for (int j = 0; j < kichThuoc; j++) {
                System.out.print("Phần tử hàng " + i + ", cột " + j + ": ");
                maTranVuong[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("\nMa trận vuông vừa nhập:");
        for (double[] row : maTranVuong) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        double tongDuongCheoChinh = 0;
        for (int i = 0; i < kichThuoc; i++) {
            tongDuongCheoChinh += maTranVuong[i][i];
        }

        System.out.println("Tổng của các phần tử trên đường chéo chính là: " + tongDuongCheoChinh);

        scanner.close();
    }
}
