import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();
        int height = sc.nextInt();
        int[][] arr = new int[height][width];

        Queue<Tomato> que = new LinkedList<Tomato>();
        int startX, startY;
        int y, x;
        int n;
        int count = 0;

        for (y = 0; y < height; y++) {
            for (x = 0; x < width; x++) {
                n = sc.nextInt();
                if (n == 1) {
                    que.offer(new Tomato(x, y, 0));
                }
                arr[y][x] = n;
            }
        }

        if (!check(0, arr)) { // 처음부터 모두 익어있는 상태인지 검사
            System.out.println(0);
            return;
        }

        // 우,하,좌,상
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Tomato tmt;
        int day = 0;

        while (!que.isEmpty()) {
            tmt = que.poll();
            day = tmt.day;
            for (int i = 0; i < 4; i++) {

                int newY = tmt.y + dy[i];
                int newX = tmt.x + dx[i];

                if (newY < 0 || newY > height - 1 || newX < 0 || newX > width - 1) { // 배열을 벗어난 경우
                    continue;
                }

                if (arr[newY][newX] == 0) {
                    arr[newY][newX] = 1;
                    que.offer(new Tomato(newX, newY, day + 1));
                }
            }
        }
        if (check(0, arr)) { // 탐색을 했지만 아직 익지 못한 토마토가 있으면
            System.out.println(-1);
            return;
        }
        System.out.println(day);
    }

    static boolean check(int n, int[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[0].length; x++) {
                if (arr[y][x] == n) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Tomato {
    int x;
    int y;
    int day;

    Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}