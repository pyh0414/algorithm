import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt(); // 공연장의 가로길이
        int height = sc.nextInt(); // 공연장의 세로길이
        int order = sc.nextInt(); // 대기순서
        int direction = 1;
        int x = 0, y = -1;
        boolean down = true, up = false, right = false, left = false; // 시계방향으로 탐색할 수 있도록 도와주는 변수

        int[][] ary = new int[height][width]; // 공연장의 좌석배열

        if (order > width * height) { // 공연장의 좌석보다 대기순서가 크게 되면 0을 출력하고 return
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= order; i++) { // 대기순서 만큼 반복

            if (down && y + 1 < height && ary[y + 1][x] == 0) { // 아래쪽으로 탐색
                ary[y + 1][x] = i + 1;
                y++;
                continue;
            } else { // 아래쪽이 다 탐색이 끝나면 오른쪽으로 이동해야 하기 때문에 right를 제외하고 모두 false
                down = false;
                up = false;
                right = true;
                left = false;
            }

            if (right && x + 1 < width && ary[y][x + 1] == 0) { // 오른쪽으로 탐색
                ary[y][x + 1] = i + 1;
                x++;
                continue;
            } else { // 오른쪽 탐색이 모두 끝나면 위쪽으로 이동해야 하기 떄문에 up을 제외하고 모두 false
                down = false;
                up = true;
                right = false;
                left = false;
            }
            if (up && y - 1 >= 0 && ary[y - 1][x] == 0) { // 위쪽으로 탐색
                ary[y - 1][x] = i + 1;
                y--;
                continue;
            } else { // 위쪽 탐색이 모두 끝나면 왼쪽으로 이동해야 하기 때문에 left를 제외하고 모두 false
                down = false;
                up = false;
                right = false;
                left = true;
            }
            if (left && x - 1 >= 0 && ary[y][x - 1] == 0) { // 왼쪽으로 탐색
                ary[y][x - 1] = i + 1;
                x--;
                continue;
            } else { // 왼쪽 탐색이 모두 끝나면 아래쪽으로 이동해야 하기 때문에 down을 제외하고 모두 false
                i--; // 아래쪽으로 탐색하는 로직(첫번쨰 if문)이 제일 위쪽에 있어서 i변수를 --해주어여함.
                down = true;
                up = false;
                right = false;
                left = false;
            }

        }

        System.out.println((x + 1) + " " + (y + 1));
    }

}