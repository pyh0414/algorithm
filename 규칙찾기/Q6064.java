/*
 *  2018.01.26
 *  캉이달력
 *  https://www.acmicpc.net/problem/6064
 **/

package 규칙찾기;

import java.util.Scanner;

public class Q6064 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M, N, x, y;
		int x1, y1, k;
		int depth = 1;
		boolean isFind;

		for (int i = 0; i < T; i++) {

			
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			x1 = 1;
			y1 = 1;
			k = 1;
			depth=1;

			while (true) {

				if (x1 == x) {
					k = M;
				} else if (y1 == y) {
					k = N;
				}

				if (x1 >= M) {
					if (x1 % M == 0) {
						x1 = M;
					} else {
						x1 = x1 % M;
					}
				}

				if (y1 >= N) {
					if (y1 % N == 0) {
						y1 = N;
					} else {
						y1 = y1 % N;
					}
				}

				if (x1 == x && y1 == y) {
					System.out.println(depth);
					break;
				} else if (depth > (M * N)) {
					System.out.println(-1);
					break;
				}

				x1 += k;
				y1 += k;
				depth += k;
			}

		}
	}
}
