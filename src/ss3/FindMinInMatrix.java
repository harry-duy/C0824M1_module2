package ss3;

import java.util.Scanner;
public class FindMinInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so hang cua ma tran: ");
        int rows = scanner.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        System.out.println("Nhap cac phan tu cho ma tran:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phan tu [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        double max = matrix[0][0];
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Gia tri lon nhat trong ma tran la: " + max);
        System.out.println("Toa do cua gia tri lon nhat: [" + maxRow + "][" + maxCol + "]");

        scanner.close();
    }

}
