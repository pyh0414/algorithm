import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, num;
        int[][] ary = new int[5][5]; // 입력받은 행렬을 저장
        int[][] check = new int[5][5]; // 상하좌우에 있는 값보다 제일 작은값을 체크하는 배열

        for (int i = 0; i < 5; i++) { // 모든 행렬 입력받기
            for (int k = 0; k < 5; k++) {
                ary[i][k] = sc.nextInt();
            }
        }

        // 꼭지점 부분을 먼저 확인
        if (ary[0][0] < ary[1][0] && ary[0][0] < ary[0][1]) {
            check[0][0] = 11;
        }
        if (ary[4][0] < ary[3][0] && ary[4][0] < ary[4][1]) {
            check[4][0] = 11;
        }
        if (ary[4][4] < ary[3][4] && ary[4][4] < ary[4][3]) {
            check[4][4] = 11;
        }
        if (ary[0][4] < ary[1][4] && ary[0][4] < ary[0][3]) {
            check[0][4] = 11;
        }

        // 가장자리에서 꼭지점 부분을 제외한 부분을 확인
        for (int i = 1; i <= 3; i++) {
            if (ary[i][0] < ary[i - 1][0] && ary[i][0] < ary[i + 1][0] && ary[i][0] < ary[i][1]) { // left
                check[i][0] = 11;
            }

            if (ary[4][i] < ary[4][i - 1] && ary[4][i] < ary[4][i + 1] && ary[4][i] < ary[3][i]) { // bottom
                check[4][i] = 11;
            }

            if (ary[i][4] < ary[i - 1][4] && ary[i][4] < ary[i + 1][4] && ary[i][4] < ary[i][3]) { // right
                check[i][4] = 11;
            }

            if (ary[0][i] < ary[0][i + 1] && ary[0][i] < ary[0][i - 1] && ary[0][i] < ary[1][i]) { // top
                check[0][i] = 11;
            }

        }

        // 가장자리를 제외한 안쪽 부분
        for (int y = 1; y <= 3; y++) {
            for (int x = 1; x <= 3; x++) {
                num = ary[y][x];
                if (num < ary[y][x - 1] && num < ary[y][x + 1] && num < ary[y - 1][x] && num < ary[y + 1][x]) {
                    check[y][x] = 11;
                }
            }
        }

        for (int t = 0; t < 5; t++) {
            for (int s = 0; s < 5; s++) {
                if (check[t][s] == 11) {
                    System.out.print("* ");
                    continue;
                } else {
                    System.out.print(ary[t][s] + " ");
                }
            }
            System.out.println("");
        }

    }
}
