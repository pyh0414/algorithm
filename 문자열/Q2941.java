/*
 *  2018.01.05
 *  크로티아 알파벳 
 *  https://www.acmicpc.net/problem/2941
 **/

package 문자열;

import java.util.Scanner;

public class Q2941 {

	public static void main(String[] args) {

		String[] croatiaAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" }; // 변경된 크로아티아 알파벳 배열 초기화

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String changedStr = null;
         sc.close();
		for (int i = 0; i < croatiaAlphabet.length; i++) {
			str = str.replaceAll(croatiaAlphabet[i], "X");   // croatiaAlphabet 배열에서 같은 값이 잇으면 X로 치환
		}

		System.out.println(str);

	}

}