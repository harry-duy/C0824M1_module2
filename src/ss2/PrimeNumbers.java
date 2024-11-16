package ss2;

public class PrimeNumbers {

    public static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là:");

        int count = 0;

        

        for (int i = 2; i < 100; i++) {

            if (isPrime(i)) {
                System.out.printf("%-4d", i);
                count++;

                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }


        System.out.println("\nTổng số lượng các số nguyên tố: " + count);
    }
}
