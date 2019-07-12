import java.util.*;
import java.awt.Point;

public class Main {

    static Queue<Point> que = new LinkedList<Point>();
    static int danji = 0;
    static int[] dy = { 0, 1, 0, -1 };
    static int[] dx = { 1, 0, -1, 0 };
    static int[][] arr;
    static int danjiHomes;
    static int N;

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
                    bfs(x + 1, y + 1);
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

    public static void bfs(int x, int y) {

        que.offer(new Point(x, y));

        while (!que.isEmpty()) {
            danjiHomes++;
            arr[y][x] = 0;
            Point now;
            now = que.poll();
            for (int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];
                if (arr[newY][newX] == 1) {
                    arr[newY][newX] = 0;
                    que.offer(new Point(newX, newY));
                }
            }
        }
    }
}
