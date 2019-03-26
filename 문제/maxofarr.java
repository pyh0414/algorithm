import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = 0;
        int n, x = 0, y = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                n = sc.nextInt();

                if (n > max) {
                    max = n;
                    x = j + 1;
                    y = i + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(y + " " + x);
    }
}