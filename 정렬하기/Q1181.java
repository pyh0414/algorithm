/*
*  2018.01.09 / 1181번
*  단어정렬
*  https://www.acmicpc.net/problem/1181
**/

package 정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1181 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String word;

		String[] strAry = new String[num];
		ArrayList list = new ArrayList();

		for (int i = 0; i < strAry.length; i++) {
			word = sc.next();

			if (list.contains(word)) { // 중복 단어 검사
				strAry[i] = "";
				continue;
			}

			list.add(word);
			strAry[i] = word;

		}

		Arrays.sort(strAry); // 알파벳순으로 정렬

		String temp;

		for (int i = 0; i < strAry.length - 1; i++) { // 길이순으로 정렬
			for (int j = 0; j < (strAry.length - i) - 1; j++) {

				if (strAry[j].length() > strAry[j + 1].length()) {
					temp = strAry[j];
					strAry[j] = strAry[j + 1];
					strAry[j + 1] = temp;
				}
			}
		}

		for (String s : strAry) {
			if (s == "") {
				continue;
			}
			System.out.println(s);
		}

	}

}
