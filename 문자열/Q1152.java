/*
 *  2018.01.02 
 *  단어의 개수
 *  https://www.acmicpc.net/problem/1152
 **/

package 문자열;

import java.util.Scanner;

public class Q1152 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str;
		String strAry[];

		str = sc.nextLine();
		strAry = str.split(" "); // 문장을 공백을 기준으로 분리하여 배열에 저장.
		                         // 공백을 만나기 전까지의 문자를 배열에 한다.
        sc.close();
		System.out.println("단어의 개수는 : " + strAry.length + " 개 입니다.");

	}

}
