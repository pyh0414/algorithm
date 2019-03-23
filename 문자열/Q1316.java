/*
 *  2018.01.04 
 * 그룹단어 체커
 * https://www.acmicpc.net/problem/1316
 **/

package 문자열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1316 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 입력받은 문자열 수
		int count = n; // 그룹단어 수.
		String str;

		Loop1: for (int i = 0; i < n; i++) {

			str = sc.next(); // 입력받은 문자열
			for (int k = 0; k < str.length(); k++) { // 문자열에 대한 각각의 알파벳
				int c = str.charAt(k); // 그룹단어를 검사할 기준 알파벳으로 아스키코드를 이용

				for (int j = k + 1; j < str.length(); j++) { // 기준 알파벳과 그 다음 알파벳이 같은지 검사
					if (c == str.charAt(j)) { // 같은 알파벳이 있을경우 다음 index를 검사
						continue;
					} else { // 기준 알파벳의 index보다 큰 값을 검사하면서, 기준 알파벳과 같지 않은 알파벳을 발견하게 되면, 이후부터 기준알파벳과 같은 값이
								// 나오게 되면 그룹단어에서 제외된다.

						for (int z = j + 1; z < str.length(); z++) {
							if (c == str.charAt(z)) {
								count--; // 기준 알파벳과 같은 값이 발견되면 그룹단어의 갯수를 하나 줄이고, Loop1으로 간다.
								continue Loop1;
							}
						}
					}
				}
			}
		}
        sc.close();
		System.out.println(count);
	}

}
