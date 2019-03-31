import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        int y = sc.nextInt() - 1;
        int x = sc.nextInt() - 1;
        int[][] ary = new int[height][width];

        int mineCount = 0;

        for (int a = 0; a < height; a++) {
            for (int b = 0; b < width; b++) {
                ary[a][b] = sc.nextInt();
            }
        }

        if (ary[y][x] == 1) {
            System.out.println("game over");
            return;
        }

        if (y - 1 >= 0 && ary[y - 1][x] == 1) { // 12시
            mineCount++;
        }

        if (y + 1 <= height - 1 && ary[y + 1][x] == 1) { // 6시
            mineCount++;
        }

        if (x + 1 <= width - 1 && ary[y][x + 1] == 1) { // 3시
            mineCount++;
        }

        if (x - 1 >= 0 && ary[y][x - 1] == 1) { // 9시
            mineCount++;
        }

        if (x + 1 <= width - 1 && y - 1 >= 0 && ary[y - 1][x + 1] == 1) { // 1사분면
            mineCount++;
        }

        if (x - 1 >= 0 && y - 1 >= 0 && ary[y - 1][x - 1] == 1) { // 2사분면
            mineCount++;
        }

        if (x - 1 >= 0 && y + 1 <= height - 1 && ary[y + 1][x - 1] == 1) { // 3사분면
            mineCount++;
        }

        if (x + 1 <= width && y + 1 >= 0 && ary[y + 1][x + 1] == 1) {
            mineCount++;
        }

        System.out.println(mineCount);
    }
}