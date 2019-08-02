import java.util.*;

public class Main {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int[][] arr;
    static int N;
    static boolean[][] check;
    static int level;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 2][N + 2];

        int y, x;
        for (y = 0; y < N; y++) {
            for (x = 0; x < N; x++) {
                arr[y + 1][x + 1] = sc.nextInt();
            }
        }

        int result = 1;

        for (int k = 1; k <= 100; k++) {

            int safeZoneCount = 0;
            level = k; // 잠기는 높이
            check = new boolean[N + 2][N + 2];

            for (y = 0; y < N; y++) {
                for (x = 0; x < N; x++) {
                    if (arr[y + 1][x + 1] > level) {
                        check[y + 1][x + 1] = true; // 잠기지 않는 부분
                    }
                }
            }

            for (y = 0; y < N; y++) {
                for (x = 0; x < N; x++) {
                    if (check[y + 1][x + 1]) {
                        safeZoneCount++;
                        dfs(y + 1, x + 1);
                    }
                }
            }
            result = Math.max(result, safeZoneCount);
        }
        System.out.println(result);
    }

    static void dfs(int y, int x) {
        check[y][x] = false;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (check[newY][x + dx[i]]) {
                dfs(newY, newX);
            }

        }
    }
}
