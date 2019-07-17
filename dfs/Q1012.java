import java.util.*;

public class Main {
    // 우,하,좌,상
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] farm;
    static int earthworm = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            farm = new int[y + 2][x + 2];
            int count = sc.nextInt(); // 배추의 수

            for (int k = 0; k < count; k++) {

                int width = sc.nextInt();
                int height = sc.nextInt();
                farm[height + 1][width + 1] = 1;

            }
            for (int yy = 0; yy < y; yy++) {
                for (int xx = 0; xx < x; xx++) {
                    if (farm[yy + 1][xx + 1] == 1) {
                        dfs(yy + 1, xx + 1);
                        earthworm++;
                    }

                }
            }
            System.out.println(earthworm);
            earthworm = 0;
        }
    }

    static void dfs(int y, int x) {

        farm[y][x] = 0;

        for (int i = 0; i < 4; i++) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (farm[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }

    }
}
// 0 0 0 0 0 0 0 0 0 0 0 0
// 0 1 1 0 0 0 0 0 0 0 0 0
// 0 0 1 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 1 0 0 0 0 0 0
// 0 0 0 0 0 1 0 0 0 0 0 0
// 0 0 0 1 1 0 0 0 1 1 1 0
// 0 0 0 0 0 1 0 0 1 1 1 0
// 0 0 0 0 0 0 0 0 0 0 0 0