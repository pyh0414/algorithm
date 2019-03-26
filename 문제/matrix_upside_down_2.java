import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        int[][] ary = new int[10][10];

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                ary[a][b] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) { // 뒤집는 횟수를 결정. n번만큼 뒤집는다.

            for (int x = 0; x < 10; x++) {
                if (ary[i][x] == 1) {
                    ary[i][x] = 0;
                } else {
                    ary[i][x] = 1;
                }
            }

            for (int y = 0; y < 10; y++) {
                if (ary[y][i] == 1) {
                    ary[y][i] = 0;
                } else {
                    ary[y][i] = 1;
                }
            }

            if (ary[i][i] == 1) {
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