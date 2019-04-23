import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[][] ary = new int[8][8];
        boolean rightNeedToCheck = true, leftNeedToCheck = true, topNeedToCheck = true, bottomNeedToCheck = true; // 상,하,좌,우로
                                                                                                                  // 체크할
                                                                                                                  // 필요가
                                                                                                                  // 있는지
                                                                                                                  // 없는지
        int x = 0, y = 0; // 킹의 x,y위치
        int n;
        int result = 0; // 킹이 룩에게 잡힐 가능성이 있는지 없는지

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                n = sc.nextInt();
                if (n == 1) { // 킹의 위치를 확인
                    x = j;
                    y = i;
                    continue;
                }
                ary[i][j] = n;
            }
        }

        for (int i = 1; i <= 6; i++) { // 상,하,좌,우로 한칸씩 증가하면서 검사
            // 오른쪽 확인
            if (rightNeedToCheck && x + i < 8) { // 오른쪽으로 진행할 수 있고(rightNeedToCheck가 true), 배열에서 벗어나지 않으면
                if (ary[y][x + i] == 3) { // 기물이 먼저 나타나면 이후에 룩이 있어도 킹은 잡히지 않음. 그렇다면 오른쪽 방향은 잡힐 가능성이 없음
                    rightNeedToCheck = false;
                } else if (ary[y][x + i] == 2) { // 기물보다 룩이 먼저 나타나면 킹은 잡힐 가능성이 있다. result=1로 하고 for문을 빠져나온다
                    result = 1;
                    break;
                }
            }

            // 왼쪽 확인
            if (leftNeedToCheck && x - i >= 0) {
                if (ary[y][x - i] == 3) {
                    leftNeedToCheck = false;
                } else if (ary[y][x - i] == 2) {
                    result = 1;
                    break;
                }
            }

            // 위쪽 확인
            if (topNeedToCheck && y - i >= 0) {
                if (ary[y - i][x] == 3) {
                    topNeedToCheck = false;
                } else if (ary[y - i][x] == 2) {
                    result = 1;
                    break;
                }
            }

            // 아래쪽 확인
            if (bottomNeedToCheck && y + i < 8) {
                if (ary[y + i][x] == 3) {
                    bottomNeedToCheck = false;
                } else if (ary[y + i][x] == 2) {
                    result = 1;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}