/*
 *  2018.01.04 
 *  상수
 *  https://www.acmicpc.net/problem/2908
 **/

package 문자열;

import java.util.Scanner;

public class Q2908 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		sc.close();
		
		int reverseNum1 = (num1 % 100 % 10) * 100 + ((num1 % 100) / 10) * 10 + (num1 / 100); // 나눗셈, 나머지 연산을 이용하여 반대값을
																								// 한번에 구함
		int reverseNum2 = (num2 % 100 % 10) * 100 + ((num2 % 100) / 10) * 10 + (num2 / 100);

		System.out.println(reverseNum1 > reverseNum2 ? reverseNum1 : reverseNum2); 
	}
}
