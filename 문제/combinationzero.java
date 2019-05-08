import java.util.*;

public class Main {

    static int two = 0;
    static int five = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        check(n, 1); // 분모
        check(n - m, 2); // 분자
        check(m, 2); // 분자

        if (two <= 0 || five <= 0) {
            System.out.println(0);
        } else if (two > five) {
            System.out.println(five);
        } else {
            System.out.println(two);
        }

    }

    static void check(int n, int c) {

        int t = 0, f = 0;
        for (int j = 1; j <= n; j++) {

            int i = j;

            if (i % 2 == 0 || i % 5 == 0) {
                while (i % 2 == 0) {
                    i = i / 2;
                    t++;
                }
                while (i % 5 == 0) {
                    i = i / 5;
                    f++;
                }
            }
        }
        if (c == 1) {
            two += t;
            five += f;
        } else {
            two -= t;
            five -= f;
        }
    }

}
