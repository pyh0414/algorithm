import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n]; // 일반 정수배열
        int[] b = new int[n]; // a배열의 n번까지의 합을 n으로 나눈 값을 저장할 배열
        int sum; // a배열에서 n번째까지의 합

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        a[0] = b[0]; // a[0]은 a[0]까지의 값은 한번 나눈 값이므로 초기화 해줌
        sum = a[0]; // sum 또한 a[0]을 제외하고 누적된 값이 없으므로 초기화

        for (int j = 1; j < n; j++) {
            a[j] = (b[j] * (j + 1)) - sum; // 누적된값+a[n]/n = b[n]에서 a[n]을 왼쪽에 놓고 모든 값을 오른쪽으로 넘김. 미지수 x구하는 방법
            sum += a[j]; // sum에 누적값 계산
        }

        for (int s = 0; s < n; s++) {
            System.out.print(a[s] + " ");
        }

    }
}