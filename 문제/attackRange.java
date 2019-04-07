import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() - 1; // 행렬 크기
        int y = sc.nextInt() - 1; // 행크기
        int x = sc.nextInt() - 1; // 열 크기
        int length = sc.nextInt(); // 범위

        int ax, bx, cx, dx;
        int ay, by, cy, dy;

        int aax, bbx, ccx, ddx;
        int aay, bby, ccy, ddy;

        int count = 1;

        int[][] ary = new int[n + 1][n + 1];
        ary[y][x] = 1000;

        for (int i = 1; i <= length; i++) {

            ax = x + i;
            ay = y;
            bx = x;
            by = y - i;
            cx = x - i;
            cy = y;
            dx = x;
            dy = y + i;

            if (ax <= n) { // 3시 방향 i출력
                ary[ay][ax] = i;
            }

            if (by >= 0) { // 12시 방향 i출력
                ary[by][bx] = i;
            }

            if (cx >= 0) { // 9시 방향 i출력
                ary[cy][cx] = i;
            }

            if (dy <= n) { // 6시 방향 i출력
                ary[dy][dx] = i;
            }

            aax = ax;
            aay = ay; // 1사분면에서 사거리를 표시하기위한 변수

            bbx = bx;
            bby = by; // 2사분면에서 사거리를 표시하기위한 변수

            ccx = cx;
            ccy = cy; // 3사분면에서 사거리를 표시하기위한 변수

            ddx = dx;
            ddy = dy; // 4사분면에서 사거리를 표시하기위한 변수

            count = 1;

            for (int z = 0; z < i - 1; z++) {

                if (aax - count <= n && aay - count >= 0) { // 1사분면
                    ary[aay - count][aax - count] = i;
                }

                if (bbx - count >= 0 && by + count >= 0) { // 2사분면
                    ary[bby + count][bbx - count] = i;
                }

                if (ccx + count >= 0 && ccy + count <= n) { // 3 사분면
                    ary[ccy + count][ccx + count] = i;
                }

                if (ddx + count <= n && ddy - count <= n) { // 4 사분면
                    ary[ddy - count][ddx + count] = i;
                }
                count++;
            }
        }

        for (int s = 0; s < n + 1; s++) {
            for (int t = 0; t < n + 1; t++) {
                if (ary[s][t] == 1000) {
                    System.out.print("x ");
                } else {
                    System.out.print(ary[s][t] + " ");
                }
            }
            System.out.println("");
        }
    }
}