/*
 * 2018.01.16
 * 문자열 반복
 * https://www.acmicpc.net/problem/2675
 **/

package 문자열;

import java.util.Scanner;

public class Q2675 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 입력받을 단어 횟수

		String[] strAry = new String[n]; // 입력받은 문자열
		int[] countAry = new int[n]; // 각 문자열을 몇번 반복할 것인지

		int flag;
		for (int i = 0; i < n; i++) {
			countAry[i] = sc.nextInt();
			strAry[i] = sc.next();
		}
		sc.close();
		for (int j = 0; j < n; j++) {
			String str = strAry[j]; // 첫번쨰 문자열
			int count = countAry[j]; // 첫번쨰 문자열을 반복할 횟수

			flag = 0; // 각 단어를 반복횟수를 체크
			for (int k = 0; k < str.length(); k++) {
				char c = str.charAt(k);
				flag = 0;
				while (flag < count) { // 정해진 반복횟수동안 알파벳을 출력
					System.out.print(c);
					flag++; // 한번 출력하면 반복횟수를 수정
				}
			}
			System.out.println();
		}

	}

}
