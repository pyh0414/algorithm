import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] units = new int[M];
        int[] brands = new int[M];

        int unitMin = 987654321;
        int brandMin = 987654321;

        for (int i = 0; i < M; i++) {
            brands[i] = sc.nextInt();
            units[i] = sc.nextInt();

            if (units[i] < unitMin) {
                unitMin = units[i];
            }

            if (brands[i] < brandMin) {
                brandMin = brands[i];
            }
        }

        int money = 0;

        if (brandMin < unitMin * 6) {
            money += (N / 6) * brandMin;
        } else {
            money += unitMin * (N / 6) * 6;
        }

        N %= 6;

        if (brandMin < (N * unitMin)) {
            money += brandMin;
        } else {
            money += (N * unitMin);
        }

        System.out.println(money);
    }
}
