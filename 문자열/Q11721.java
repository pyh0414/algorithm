/*
 *  2018.01.02 / 11721번
 *  알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다 한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
 **/

package algorithm;

import java.util.Scanner;

public class Q11721 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[] ary = new char[100];
		String str = null;

		str = sc.next();
		str.toCharArray();                          // 문자열을 문자배열로 변환    

		for (int i = 0; i < str.length(); i++) {    // 배열에서 0인 부분은 제외하고, 문자 10개 단위로 끊음
			if (i > 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(str.charAt(i));
		}

	}

}
