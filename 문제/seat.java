import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt();
        int height = sc.nextInt();
        int seatCount = sc.nextInt();
        int count = 0;
        int direction = 1;
        int x = 0, y = -1;
        boolean down = true, up = false, right = false, left = false;

        int[][] ary = new int[height][width];

        if (seatCount > width * height) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= seatCount; i++) {

            if (down && y + 1 < height && ary[y + 1][x] == 0) {
                ary[y + 1][x] = i + 1;
                y++;
                continue;
            } else {
                down = false;
                up = false;
                right = true;
                left = false;
            }

            if (right && x + 1 < width && ary[y][x + 1] == 0) {
                ary[y][x + 1] = i + 1;
                x++;
                continue;
            } else {
                down = false;
                up = true;
                right = false;
                left = false;
            }
            if (up && y - 1 >= 0 && ary[y - 1][x] == 0) {
                ary[y - 1][x] = i + 1;
                y--;

                continue;
            } else {
                down = false;
                up = false;
                right = false;
                left = true;
            }
            if (left && x - 1 >= 0 && ary[y][x - 1] == 0) {
                ary[y][x - 1] = i + 1;
                x--;

                continue;
            } else {

                i--;
                down = true;
                up = false;
                right = false;
                left = false;
            }

        }

        System.out.println((x + 1) + " " + (y + 1));
    }

}