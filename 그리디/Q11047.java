
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int money = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = n - 1;
        int count = 0;
        int quo;

        while (money > 0) {
            quo = money / arr[index];
            if (quo > 0) {
                money %= arr[index];
                count += quo;
            }
            index--;
        }
        System.out.println(count);

    }
}
