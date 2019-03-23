/*
 *  2018.01.05 
 *  벌집
 *  https://www.acmicpc.net/problem/2292
 **/

package 규칙찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Q2292 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int roomNum = sc.nextInt();
		sc.close();

		int i = 0;
		int count = 1;
		int min, max;

		while (true) {

			if (roomNum == 1) { // 1번 방을 탐색하는 경우는 1번 탐색한다.
				System.out.println(count);
				break;
			}
			min = 2 + (3 * i) * (i + 1); // 각 층의 최솟값, 최댓값을 구함
			max = (3 * i * i) + ((9 * i) + 7);

			i++; // 각 층을 나타내는 값
			count++; // 일단 방에 들어간 후 검사하므로, 특정 범위에 방이 있는지 없는지 검사하기 전에 방을 counting한다.

			if (roomNum >= min && roomNum <= max) { // 찾고자 하는 방의 번호가 특정 범위내에 있으면 현재 방을 출력한다.
				System.out.println(count);
				break;
			}

		}

	}
}
