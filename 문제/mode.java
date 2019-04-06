import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;
        int modeFrequency = 0; // 최빈값의 최대 빈도수
        int modeCount = 0; // 최대 최빈값을 가지는 숫자의 개수
        int mode = 0; // 최빈값
        int[] ary = new int[101];

        for (int i = 0; i < 10; i++) {
            n = sc.nextInt();
            sum += n; // 입력받은 숫자를 계속 더해줌
            ary[n / 10]++; // 입력받은 정수의 빈도수를 ary배열에 체크, 10의 배수이고 배열의 크기를 줄이기 위해 10으로 나눔. 나중에 출력할 땐 x10을 해야함

            if (ary[n / 10] > modeFrequency) { // 최빈값의 최대 빈도수를 찾음
                modeFrequency = ary[n / 10];
            }
        }

        for (int k = 1; k < 101; k++) {
            if (ary[k] == modeFrequency) { // 최빈값의 최대 빈도수를 가진 숫자가 몇개 있는지 구함
                modeCount++;
                mode = k * 10; // modeCount가 1개인 경우, 바로 그 값을 찾이위해 사용. modeCount > 1이면 사용되지 않음
            }
        }

        if (modeCount == 1) { // 최빈값이 하나인 경우 최빈값, 평균을 출력
            System.out.println(sum / 10);
            System.out.println(mode);
        } else {
            System.out.println(sum / 10);
            for (int j = 0; j < 101; j++) { // 최빈값이 2보다 큰 경우, 배열 앞에서 부터 탐색하면서 최대 빈도수를 가진 숫자를 출력
                if (ary[j] == modeFrequency) {
                    System.out.println(j * 10);
                    return;
                }
            }
        }
    }
}