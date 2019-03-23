/*
 *  2018.01.08 
 *  ACM호텔
 *  https://www.acmicpc.net/problem/10250
 **/

package 규칙찾기;

import java.util.Scanner;

public class Q10250 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int w, h, n;
		int x = 1, y = 1;

		int[][] tCase = new int[T][3];

		for (int k = 0; k < T; k++) {
			for (int i = 0; i < 3; i++) {
				tCase[k][i] = sc.nextInt();
			}
		}

		for (int j = 0; j < T; j++) {

			h = tCase[j][0];
			w = tCase[j][1];
			n = tCase[j][2];

			// -----------------------------------------입력조건
			if (1 > h || w > 99 || (1 > n && n > h * w)) {
				System.out.println("값을 다시 입력해 주세요");
			}
			// -----------------------------------------

			x = (n / h) + 1; // 엘리베이터 바로 앞방의 경우도 x방향에서는 1의 값을 가지기 떄문에 +1.
			y = n % h; // y방향으로 몇번째 방인지 확인

			if (n % h == 0) { // 제일 꼭대기 층의 경우 x가 증가하지 않았지만, n/h은 1이 되므로 1이 증가하게 됨.
				x--;
				y = h;// 이 경우 x값을 1 감소함
			}

			System.out.println(100 * y + x);

		}
	}

}
