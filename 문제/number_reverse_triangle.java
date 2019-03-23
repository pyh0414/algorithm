import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ary = new int[n][n];
        int count = 0;
        int x, y; // 배열 내에서의 x,y좌표

        for (int i = 0; i < n; i++) { // 대각선 방향으로 형성되는 군집을 제어
            x = i; // 가로방향을 기준으로 counting하기 때문에 x값을 변하고 y는 0으로 고정
            y = 0;

            while (x >= 0) { // 하나의 군집에서 x값이 --되면서 0이 될때까지 반복
                count++;
                ary[y][x] = count;
                x--; // 군집에서 x를 감소하는 방향
                y++; // 군집에서 y는 증가하는 방향
            }

        }

        for (int s = 0; s < n; s++) {
            for (int f = 0; f < n; f++) {
                if (ary[s][f] != 0) {
                    System.out.print(ary[s][f] + " ");
                }
            }
            System.out.println("");
        }
    }
}