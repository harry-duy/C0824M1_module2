package ss3;
import java.util.Scanner;
public class CountTheNumberOfOccurrencesOfACharacterInAString {
    public static void main(String[] args) {
        String chuoi = "hello world, i am software engineering";
        System.out.println(chuoi);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một ký tự để đếm: ");
        char kyTuNhap = scanner.next().charAt(0);

        int count = 0;

        for (int i = 0; i < chuoi.length(); i++) {
            char kyTuHienTai = chuoi.charAt(i);
            if (kyTuHienTai == kyTuNhap) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự '" + kyTuNhap + "' trong chuỗi là: " + count);

        scanner.close();
    }
}
