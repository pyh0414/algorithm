import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList list = new ArrayList(); // 2진수를 저장한 리스트

        if (n == 1) { // 입력받은 숫자가 1이면 1을 출력
            System.out.println(1);
            return;
        }

        while (true) {
            list.add(n % 2); // 2진수는 입력받은 숫자의 나머지 값
            n /= 2; // 한번 나눴으면 n 값은 다시 2로 나눈 몫으로 설정

            if (n == 1) { // 마지막으로 남은 몫이 1인 경우 1을 저장하고 while문을 빠져 나온다.
                list.add(1);
                break;
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) { // 저장된 2진수를 역으로 출력
            System.out.print(list.get(i));
        }
    }
}