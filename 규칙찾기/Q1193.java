/*
 *  2018.01.19 
 *  분수찾기
 *  https://www.acmicpc.net/problem/1193
 */

package 규칙찾기;

import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int line = 0;
		int gap;
		int bottom = 1, top = 1;
		boolean isOdd;

		for (int i = 1; i <= n; i++) {

			sum += i; // 표에 빗금 칠을 하여, 1~N빗금 까지의 합을 구한다.

			if (n == 1) {
				line = 1;
				break;
			}
			if (n <= sum) { // 만약 1~N빗금 까지의 합(sum)을 구하다 입력받은 값 n보다 작게 되면 해당 n번째 빗금에 원하는 값이 있다.
				line = i;
				break;
			}
		}

		gap = sum - n; // n번쨰 빗금에서 빗금의 가장 위쪽값에서 몇번째 떨어져 있는 값인지 구한다.

		if (line % 2 == 0) { // 몇번쨰 빗금인지에 따라 분모,분자의 초기화 값을 달리해준다.

			top = line;
			isOdd = false; // 짝수
		} else {

			bottom = line;
			isOdd = true; // 홀수
		}

		for (int i = 0; i < gap; i++) { // 빗금의 윗쪽 값, 즉 기준 값으로 부터 떨어진 수만큼 연산한다.

			if (isOdd) { // 홀수인 경우 분자는 더해지고, 분모를 빼진다.
				top++;
				bottom--;
			} else { // 짝수인 경우 분자는 빼지고 분모를 더해진다.
				top--;
				bottom++;
			}
		}

		System.out.println(top + "/" + bottom);
	}
}
