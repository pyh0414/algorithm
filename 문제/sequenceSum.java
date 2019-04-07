import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테이블의 크기
        int[][] ary = new int[n + 1][n + 1]; // 테이블을 표현할 배열
        int[] A = new int[n + 1]; // A수열을 저장 할 배열
        int a3; // A[3]값

        for (int i = 1; i <= n; i++) { // 편의를 위해 범위를 0~n-1까지가 아니라, 0~n로 설정
            for (int j = 1; j <= n; j++) {
                ary[i][j] = sc.nextInt();
            }
        }

        a3 = (ary[2][3] + ary[1][3] - ary[1][2]) / 2; // 방정식으로 해결, 문제에서 A[1]+A[2]=3, A[2]+A[3]=5, A[1]+A[3]=6이기 때문에
                                                      // A[1],A[2],A[3]을 미지수로 놓고정리하여 A[3]을 제외하고 모두 우항으로 넘긴다.
        A[3] = a3; // a3은 곧 A[3]값 이므로 A[3]은 초기화

        for (int i = 1; i <= n; i++) {

            if (i == 3) {
                continue;
            }

            A[i] = ary[3][i] - a3; // ary 각 행과 열의 값을 인덱스로 하는 A배열의 합(A[행]+A[열])의 값은 ary[행][열]값과 같다.
        } // 문제에서 ary[2][3] = 5, A[2]+A[3]=5 이기 때문에, A[3]행 값은 이미 알고 있기 때문에 이 값을 사용하여 나머지
          // 값을 구함.

        for (int s = 1; s <= n; s++) {
            System.out.print(A[s] + " ");
        }
    }
}