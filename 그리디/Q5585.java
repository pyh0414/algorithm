
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int change = 1000 - n;
        int[] coins = { 500, 100, 50, 10, 5, 1 };
        int index = 0;
        int quo;
        int count = 0;

        while (change > 0) {
            quo = change / coins[index];
            if (quo > 0) {
                change %= coins[index];
                count += quo;
            }
            index++;
        }
        System.out.println(count);
    }
}
