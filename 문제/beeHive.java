import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) { // 첫번째 방이면 하나의 방을 지나왔으므로 1개를 출력하고 return;
            System.out.println(1);
            return;
        }

        int i = 1;

        while (true) {

            if (n >= (3 * i * i) - (3 * i) + 2 && n <= ((3 * i * i) + (3 * i) + 1)) { // 방 level에 따라 최솟값~최댓값이 존재하는데 입력받은
                                                                                      // 방(n)이 어느 범위(방)에 속해 있는지 검사.
                break;
            }
            i++; // 방의 level을 제어하는 변수

        }
        System.out.println(i + 1); // 첫번째 방이 아닌이상, 첫번째 방은 기본적으로 건너왔기 때문에 +1
    }
}