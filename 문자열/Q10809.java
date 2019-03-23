/*
 * 2018.01.02 
 * 알파벳 찾기
 * https://www.acmicpc.net/problem/10809
 **/

package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class Q10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int[] alphabet = new int[26];

		Arrays.fill(alphabet, -1);                   // 한번도 나오지 않는 알파벳은 -1을 출력하므로 먼저 모든 인덱스를 -1로 초기화
		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - 'a';               // 알파벳 배열에에서의 인덱스값을 구한다.

			if (alphabet[n] == -1) {                 // 단어에서 중복되는 문자가 있을 때 처음 방문하는 경우만 체크
				alphabet[n] = i;                     // 단어가 처음 나오는 위치는 체크
			}
		}

		for (int k : alphabet) {
			System.out.print(k + " ");
		}

	}

}
