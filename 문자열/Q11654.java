/*
 *  2018.01.16 
 *  아스키 코드
 *  https://www.acmicpc.net/problem/11654
 **/

package 문자열;

import java.util.Scanner;

public class Q11654 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		sc.close();
		System.out.println((int) c.charAt(0));
	}
}
