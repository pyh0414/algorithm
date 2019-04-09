import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        while (num > 1) { // 나누는 대상의 값이 1이면 모두 나누어 떨어졌음을 의미하기 때문에 1보다 커야함
            for (int i = 2; i <= num; i++) { // 2~n까지의 수로 현재 num을 나누어 봄
                if (num % i == 0) { // i번째 숫자가 나누어 떨어지면 이는 소인수(n을 가장 작은 소수부터 시작했기 때문)
                    num /= i; // num을 i로 나눔.
                    System.out.println(i);
                    break;
                }
            }
        }

    }
}