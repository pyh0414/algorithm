/*
 *  2018.01.04
 *  다이얼
 *  https://www.acmicpc.net/problem/5622
 **/

package 문자열;

import java.util.Scanner;

public class Q5622 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int time = 0;

		sc.close();

		for (int k = 0; k < str.length(); k++) {

			String s = String.valueOf(str.charAt(k));

			if ("ABC".contains(s)) {
				time += 3;
			} else if ("DEF".contains(s)) {
				time += 4;
			} else if ("GHI".contains(s)) {
				time += 5;
			} else if ("JKL".contains(s)) {
				time += 6;
			} else if ("MNO".contains(s)) {
				time += 7;
			} else if ("PQRS".contains(s)) {
				time += 8;
			} else if ("TUV".contains(s)) {
				time += 9;
			} else if ("WXYZ".contains(s)) {
				time += 10;
			}
		}

		System.out.println(time);
	}

}
