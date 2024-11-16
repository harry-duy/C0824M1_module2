package ss2;
import java.util.*;
public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng số nguyên tố cần in: ");
        int numbers = sc.nextInt();

        int count = 0;

        int N = 2;

        System.out.println(numbers + " số nguyên tố đầu tiên là:");
        while (count < numbers) {
            if (isPrime(N)) {
                System.out.print(N + " ");
                count++;
            }
            N++;
        }

        sc.close();
    }


    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
