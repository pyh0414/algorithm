/*
 *  2018.01.02 
 *  �ܾ��� ����
 *  https://www.acmicpc.net/problem/1152
 **/

package ���ڿ�;

import java.util.Scanner;

public class Q1152 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str;
		String strAry[];

		str = sc.nextLine();
		strAry = str.split(" "); // ������ ������ �������� �и��Ͽ� �迭�� ����.
		                         // ������ ������ �������� ���ڸ� �迭�� �Ѵ�.
        sc.close();
		System.out.println("�ܾ��� ������ : " + strAry.length + " �� �Դϴ�.");

	}

}
