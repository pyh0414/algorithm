/*
 * 2018.01.02 
 * 소수 찾기
 * https://www.acmicpc.net/problem/1978
 **/

package 소수구하기;

import java.util.Scanner;

public class Q1978 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num;
		int flag = 0;
		int pnCount = 0; // 소수숫자 counting
		int j;

		for (int i = 0; i < n; i++) {

			num = sc.nextInt();

			if (num == 1) { // 1은 소수가 아니므로 무시.
				continue;
			}

			j = 1; // 각 숫자를 나머지 연산할 값
			flag = 0; // 소수 체크 count값
			while (j <= num) { // j

				if (num % j == 0) { // 각 숫자를 1..n까지 변하는 값과 나머지 연산을 하여, 나누어 떨어지면 flag++을 한다.
					flag++;
				}

				j++; // 입력받은 숫자와 나머지 연살할 값을 1증가한다.
			}
			if (flag == 2) { // 입력받은 첫번쨰 값을 검사하여, 만약 flag==2이다 ->나누어 떨어지는 값이 2개 있다(1과 자기자신) = 소수이다.

				pnCount++;
			}

		}
		sc.close();

		System.out.println(pnCount);

	}

}
