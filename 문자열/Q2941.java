/*
 *  2018.01.05
 *  ũ��Ƽ�� ���ĺ� 
 *  https://www.acmicpc.net/problem/2941
 **/

package ���ڿ�;

import java.util.Scanner;

public class Q2941 {

	public static void main(String[] args) {

		String[] croatiaAlphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" }; // ����� ũ�ξ�Ƽ�� ���ĺ� �迭 �ʱ�ȭ

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String changedStr = null;
         sc.close();
		for (int i = 0; i < croatiaAlphabet.length; i++) {
			str = str.replaceAll(croatiaAlphabet[i], "X");   // croatiaAlphabet �迭���� ���� ���� ������ X�� ġȯ
		}

		System.out.println(str);

	}

}