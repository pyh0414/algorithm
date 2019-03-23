/*
 *  2018.01.03
 * 단어 공부
 * https://www.acmicpc.net/problem/1157
 **/

package 문자열;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Q1157 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		String upperCase;
		int[] strAry = new int[26];

		int maxValue = 0;
		int maxIndex = 0;
		upperCase = str.toUpperCase();

		for (int i = 0; i < upperCase.length(); i++) {
			int c = upperCase.charAt(i) - 'A';
			strAry[c]++;
			if (strAry[c] > maxValue) {
				maxValue = strAry[c];
				maxIndex = i;
			}
		}

		Arrays.sort(strAry);

		if (strAry[strAry.length - 1] == strAry[strAry.length - 2]) {
			System.out.println("?");
		} else {
			System.out.println(upperCase.charAt(maxIndex));
		}

	}
}
