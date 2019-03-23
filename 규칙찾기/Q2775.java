/*
 *  2018.01.21
 *  부녀회장이 될테야
 *  https://www.acmicpc.net/problem/2775
 **/

package 규칙찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2775 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] apartMent = new int[15][15];
		int k; // 층
		int n; // 호

		for (int i = 1; i < 15; i++) {
			apartMent[0][i] = i;
			apartMent[i][1] = 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				apartMent[i][j] = apartMent[i - 1][j] + apartMent[i][j - 1];
			}
		}

		// for (int i = 0; i < 15; i++) {
		// for (int j = 0; j < 15; j++) {
		//
		// System.out.print(apartMent[i][j] + " ");
		//
		// }
		// System.out.println();
		// }

		for (int h = 0; h < T; h++) {
			k = sc.nextInt();
			n = sc.nextInt();
			System.out.println(apartMent[k][n]);
		}
		sc.close();
	}
}
