/*
 * 2018.03.03
 * 피보나치 수2
 * https://www.acmicpc.net/problem/2748
 **/

package 피보나치수;

import java.util.Scanner;

public class Q2748 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.close();

		if (T <= 1) {
			System.out.println(T);
			return;
		}

		long otherother = 0; // 더해야 하는 숫자중 첫번째 (2부터 시작이므로, 0으로 초기화)
		long other = 1; // 더해야 하는 숫자중 두번째 (2부터 시작이므로, 1로 초기화)
		long sum = 0;

		for (int i = 0; i <= T - 2; i++) {

			sum = otherother + other; // n번쨰

			otherother = other;
			other = sum;

		}

		System.out.println(sum);

	}

}
