/*
 *  2018.01.22
 *  방 번호
 *  https://www.acmicpc.net/problem/1475
 **/

package 규칙찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Q1475 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String T = String.valueOf(sc.nextInt());
		int[] numAry = new int[10]; // 입력된 숫자의 빈도수를 체크하는 배열. 각 숫자의 빈도수는 곧 사용된 세트를 의미한다.

		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '9') { // 6와9는 구분없이 사용할 수 있으므로, 입력된 숫자가 9이면 6에 카운팅 해준다.
				numAry[6]++;
				continue;
			}
			numAry[T.charAt(i) - '0']++; // 아스키코드를 이용하여 숫자 빈도수 체크
		}

		numAry[6] = (int) Math.round((double) numAry[6] / 2); // 한 세트에는 6,9가 있고 구분없이 6에 카운팅 된다. 입력된 숫자에 6,9가 있으면 빈도수가 2로
																// 되어 세트가
																// 2개 사용된 표시된다 -> 빈도수/2값을 반올림하여 해결. 빈도수가 1일땐 1세트, 2일땐
																// 1세트, 3일땐 2세트....

		Arrays.sort(numAry); // 최대 빈도수값을 구하기 위해 정렬한다.

		System.out.print(numAry[numAry.length - 1]);

	}

}
