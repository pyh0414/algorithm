import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        mountain(n);
    }

    static void mountain(int n) {
        if (n == 1) {
            System.out.print(1);
        } else {
            mountain(n - 1); // N높이 산의 왼쪽부분
            System.out.print(n); // N높이의 산을 정의 : (n-1) N (n-1)
            mountain(n - 1); // N높이 산의 오른쪽부분
        }
    }
}