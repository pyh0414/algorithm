/*
 * 2018.01.02 
 * 소수
 * https://www.acmicpc.net/problem/2581
 **/

package 소수구하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2581 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int min = sc.nextInt();
		int max = sc.nextInt();
		int sum = 0, flag = 0;
		int j = 0;
		int minNum = 10001; // 최솟값을 찾기 위해 최대입력값을 초기화 하였다.

		for (int i = min; i <= max; i++) {

			if (i == 1) {
				continue;
			}

			j = 1;
			flag = 0;
			while (j <= i) {

				if (i % j == 0) {
					flag++;
				}

				j++;
			}
			if (flag == 2) {
				sum += i;
				if (minNum > i) {
					minNum = i;
				}

			}
		}

		sc.close();

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(minNum);
		}

	}

}
