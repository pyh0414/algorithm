/*
 * 2018.01.02 
 * 골드바흐의 추측
 * https://www.acmicpc.net/problem/9020
 **/

package 소수구하기;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9020 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num, small, big;

		for (int i = 0; i < T; i++) {

			int n = sc.nextInt();
			small = n / 2;
			big = n / 2;

			while (small > 0) {
				if (pnCheck(small) && pnCheck(big)) {
					System.out.println(small + " " + big);
					break;
				}
				small--;
				big++;
			}

		}

	}

	static boolean pnCheck(int num) { // 소수인 경우 false를 반환

		if (num == 1) {
			return false;
		}

		int n = (int) Math.sqrt(num);

		for (int j = 2; j <= n; j++) {
			if (num % j == 0) {
				return false;
			}
		}

		return true;

	}

}
