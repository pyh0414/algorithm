import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 첫번째 수의 분자/분모
        int aNume = sc.nextInt();
        int aDeno = sc.nextInt();

        // 두번쨰 수의 분자/분모
        int bNume = sc.nextInt();
        int bDeno = sc.nextInt();

        // 두 수를 더한 값
        int resultNume, resultDeno;

        resultDeno = aDeno * bDeno;
        resultNume = (aNume * bDeno) + (bNume * aDeno);

        // 결과값의 분자/분모에서 최대공약수를 구하기 위한 변수
        int a, b, r;

        // 큰 값을 a로 초기화
        if (resultDeno > resultNume) {
            a = resultDeno;
            b = resultNume;
        } else {
            a = resultNume;
            b = resultDeno;
        }

        // 유클리드 호제법으로 최대공약수 구하기
        while (true) {
            r = a % b;
            if (r == 0) {
                break;
            }
            a = b;
            b = r;
        }

        // 분자/분모를 최댜공약수로 나누어서 기약분수로 만듬
        resultDeno /= b;
        resultNume /= b;

        System.out.println(resultNume + " " + resultDeno);

    }
}