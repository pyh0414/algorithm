import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int r;
        int A = a, B = a;
        int GCD, LCM;

        while (true) {
            r = a % b;
            if (r == 0) {
                GCD = b;
                break;
            } else {
                a = b;
                b = r;
            }
        }

        LCM = A * B / GCD;
        System.out.println("최대공약수 : " + GCD);
        System.out.println("최소공배수 : " + LCM);
    }
}