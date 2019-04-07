import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int start = sc.nextInt();

        ArrayList list = new ArrayList();

        for (int i = 0; i < size; i++) {

            for (int a = 0; a < size - i - 1; a++) { // 피라미드에서 앞부분 공백을 출력하는 부분.
                System.out.print(" ");
            }

            if (i % 2 == 0) { // 짝수행의 경우 숫자가 뒤에서부터 counting된다.
                for (int b = size - i; b < size + 1 + i; b++) {
                    if (start == 9) { // 숫자가 9가 되면 다시 1로 처리해야 하므로, 먼저 저장하고 1로 설정하낟.
                        list.add(start);
                        start = 1;
                    } else { // 9가 아니면 start++을 하고 자료구조에 저장.
                        list.add(start++);
                    }
                }
                for (int s = list.size() - 1; s >= 0; s--) { // 한 행을 출력하는 부분. 짝수행은 역순이기 떄문에 자료구조의 마지막 부터 출력.
                    System.out.print(list.get(s));
                }
                list.clear();
            } else if (i % 2 != 0) { // 홀수행의 경우 숫자가 앞에서부터 counting된다.
                for (int b = size - i; b < size + 1 + i; b++) {
                    if (start == 9) { // 마찬가지로 9인 경우 start값을 1로 초기화 해주고 출력한 다음에 continue;
                        System.out.print(start);
                        start = 1;
                        continue;
                    }
                    System.out.print(start++);
                }
            }
            System.out.println(""); // 행 간의 개행
        }

    }
}