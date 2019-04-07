import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        int[][] ary = new int[10][10];

        for (int a = 0; a < 10; a++) { // 입력받은 배열로 초기화 해준다.
            for (int b = 0; b < 10; b++) {
                ary[a][b] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {

            for (int x = 0; x < 10; x++) { // x부분을 뒤집는 부분
                if (ary[i][x] == 1) { // 1이면 0으로, 0이면 1로 바꿔준다.
                    ary[i][x] = 0;
                } else {
                    ary[i][x] = 1;
                }
            }

            for (int y = 0; y < 10; y++) { // x과정과 똑같은 방법으로 뒤집어준다.
                if (ary[y][i] == 1) {
                    ary[y][i] = 0;
                } else {
                    ary[y][i] = 1;
                }
            }

            if (ary[i][i] == 1) { // 1,1 / 2,2 / ..의 경우 x와 y에서 중복되게 뒤집어 주므로 결국에는 반대숫자가 나온다.
                ary[i][i] = 0;
            } else {
                ary[i][i] = 1;
            }
        }

        for (int q = 0; q < 10; q++) {
            for (int w = 0; w < 10; w++) {
                System.out.print(ary[q][w] + " ");
            }
            System.out.println("");
        }
    }
}