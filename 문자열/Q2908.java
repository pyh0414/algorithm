/*
 *  2018.01.04 
 *  ���
 *  https://www.acmicpc.net/problem/2908
 **/

package ���ڿ�;

import java.util.Scanner;

public class Q2908 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		sc.close();
		
		int reverseNum1 = (num1 % 100 % 10) * 100 + ((num1 % 100) / 10) * 10 + (num1 / 100); // ������, ������ ������ �̿��Ͽ� �ݴ밪��
																								// �ѹ��� ����
		int reverseNum2 = (num2 % 100 % 10) * 100 + ((num2 % 100) / 10) * 10 + (num2 / 100);

		System.out.println(reverseNum1 > reverseNum2 ? reverseNum1 : reverseNum2); 
	}
}
