import java.util.*;

public class Main {

    // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };
    static int N;
    static int[][] arr;
    static int danjiHomes;
    static int danji = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N + 2][N + 2];
        ArrayList<Integer> list = new ArrayList<Integer>();

        int x, y;
        String s;
        for (y = 0; y < N; y++) {
            s = sc.next();
            for (x = 0; x < N; x++) {
                arr[y + 1][x + 1] = s.charAt(x) - '0';
            }
        }

        for (y = 0; y < N; y++) {
            for (x = 0; x < N; x++) {
                if (arr[y + 1][x + 1] == 1) {

                    danjiHomes = 0;
                    dfs(y + 1, x + 1);
                    list.add(danjiHomes);
                    danji++;

                }
            }
        }
        Collections.sort(list);
        System.out.println(danji);

        for (int n : list) {
            System.out.println(n);
        }
    }

    static void dfs(int y, int x) {

        arr[y][x] = 0;
        danjiHomes++;

        for (int i = 0; i < 4; i++) {

            int newY = y + dy[i];
            int newX = x + dx[i];
            if (arr[newY][x + dx[i]] == 1) {
                dfs(newY, newX);
            }

        }
    }
}
