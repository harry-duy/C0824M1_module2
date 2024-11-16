package ss3;
import java.util.Scanner;
public class MergeArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap kich thuoc mang 1: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];

        System.out.print("Nhap kich thuoc mang 2: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];

        System.out.println("Nhap cac phan tu cua mang 1:");
        for (int i = 0; i < size1; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }

        System.out.println("Nhap cac phan tu cua mang 2:");
        for (int i = 0; i < size2; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }

        int[] array3 = new int[size1 + size2];

        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }


        for (int i = 0; i < size2; i++) {
            array3[size1 + i] = array2[i];
        }

        System.out.println("Mang thu 3 sau khi gop:");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
    }
}
