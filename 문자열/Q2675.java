/*
 * 2018.01.16
 * ���ڿ� �ݺ�
 * https://www.acmicpc.net/problem/2675
 **/

package ���ڿ�;

import java.util.Scanner;

public class Q2675 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // �Է¹��� �ܾ� Ƚ��

		String[] strAry = new String[n]; // �Է¹��� ���ڿ�
		int[] countAry = new int[n]; // �� ���ڿ��� ��� �ݺ��� ������

		int flag;
		for (int i = 0; i < n; i++) {
			countAry[i] = sc.nextInt();
			strAry[i] = sc.next();
		}
		sc.close();
		for (int j = 0; j < n; j++) {
			String str = strAry[j]; // ù���� ���ڿ�
			int count = countAry[j]; // ù���� ���ڿ��� �ݺ��� Ƚ��

			flag = 0; // �� �ܾ �ݺ�Ƚ���� üũ
			for (int k = 0; k < str.length(); k++) {
				char c = str.charAt(k);
				flag = 0;
				while (flag < count) { // ������ �ݺ�Ƚ������ ���ĺ��� ���
					System.out.print(c);
					flag++; // �ѹ� ����ϸ� �ݺ�Ƚ���� ����
				}
			}
			System.out.println();
		}

	}

}
