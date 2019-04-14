import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ary = new String[n];

        for (int i = 0; i < n; i++) {
            ary[i] = sc.next();
        }

        int min;
        String temp;

        for (int a = 0; a < n; a++) {
            min = a;
            for (int b = a + 1; b < n; b++) {
                if (ary[min].compareTo(ary[b]) > 0) {
                    min = b;
                }
            }
            temp = ary[a];
            ary[a] = ary[min];
            ary[min] = temp;

        }

        for (int z = 0; z < n; z++) {
            System.out.println(ary[z]);
        }
    }
}