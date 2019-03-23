import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList list = new ArrayList();
        int na, mo = 2;
        String result = "";

        if (n == 1) {
            System.out.println(1);
            return;
        }

        while (true) {
            list.add(n % 2);
            n /= 2;

            if (n == 1) {
                list.add(1);
                break;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
    }
}