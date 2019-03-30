import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int y, x, width, height;

        int[][] ary = new int[102][102]; // 전체 배열
        int[] extent = new int[n + 1]; // 각 색종이의 넓이는 계산하는 배열

        for (int i = 1; i <= n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            width = sc.nextInt();
            height = sc.nextInt();

            for (int a = 0; a < height; a++) {
                for (int b = 0; b < width; b++) {
                    ary[y + a][x + b] = i; // n번쨰 색종이가 차지하는 영역을 색칠
                }
            }
        }

        for (int q = 0; q < 102; q++) {
            for (int w = 0; w < 102; w++) {
                extent[ary[q][w]] += 1; // 색종이가 칠해진 영역의 넓이는 계산
            }
        }

        for (int s = 1; s <= n; s++) {
            System.out.println(extent[s]);
        }

    }
}