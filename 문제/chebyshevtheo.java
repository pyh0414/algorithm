import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] ary = new int[2000000];
        Scanner sc = new Scanner(System.in);

        for (int i = 2; i <= (int) Math.sqrt(1234567); i++) {
            for (int j = i * i; j <= 1234568; j += i) {
                ary[j] = 1;
            }
        }

        int num = 0;
        int count;

        while (true) {
            num = sc.nextInt();
            if (num == 0) {
                return;
            }
            count = 0;
            for (int j = num + 1; j <= 2 * num; j++) {
                if (ary[j] == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}