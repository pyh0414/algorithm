import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        int[][] ary = new int[10][10];

        for (int i = 0; i < n; i++) { // 뒤집는 횟수를 결정. n번만큼 뒤집는다.

            for (int a = 0; a < 10; a++) { // x축을 먼저 뒤집는다.
                if (ary[i][a] == 1) { // i(y축)값을 고정 되어있고, a값(x축)이 변하면서 뒤집는다.
                    ary[i][a] = 0;
                } else {
                    ary[i][a] = 1;
                }
            }

            for (int b = 0; b < 10; b++) { // 같은 방법으로 y축을 뒤집는다.
                if (ary[b][i] == 1) {
                    ary[b][i] = 0;
                } else {
                    ary[b][i] = 1;
                }
            }

            ary[i][i] = 1; // 대각선 방향은 결국에는 1이 출력된다.
        }

        for (int q = 0; q < 10; q++) {
            for (int w = 0; w < 10; w++) {
                System.out.print(ary[q][w] + " ");
            }
            System.out.println("");
        }
    }
}