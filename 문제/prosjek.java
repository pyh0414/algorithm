import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int sum;

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        a[0] = b[0];
        sum = a[0];

        for (int j = 1; j < n; j++) {
            a[j] = (b[j] * (j + 1)) - sum;
            sum += a[j];
        }

        for (int s = 0; s < n; s++) {
            System.out.print(a[s] + " ");
        }

    }
}