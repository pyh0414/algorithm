import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(getSum(n));
    }

    static int getSum(int n) {
        if (0 <= n && n <= 9) {
            return n;
        } else {
            return getSum(n / 10) + (n % 10);
        }
    }
}