/*
 *  2018.01.04 
 * �׷�ܾ� üĿ
 * https://www.acmicpc.net/problem/1316
 **/

package ���ڿ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1316 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �Է¹��� ���ڿ� ��
		int count = n; // �׷�ܾ� ��.
		String str;

		Loop1: for (int i = 0; i < n; i++) {

			str = sc.next(); // �Է¹��� ���ڿ�
			for (int k = 0; k < str.length(); k++) { // ���ڿ��� ���� ������ ���ĺ�
				int c = str.charAt(k); // �׷�ܾ �˻��� ���� ���ĺ����� �ƽ�Ű�ڵ带 �̿�

				for (int j = k + 1; j < str.length(); j++) { // ���� ���ĺ��� �� ���� ���ĺ��� ������ �˻�
					if (c == str.charAt(j)) { // ���� ���ĺ��� ������� ���� index�� �˻�
						continue;
					} else { // ���� ���ĺ��� index���� ū ���� �˻��ϸ鼭, ���� ���ĺ��� ���� ���� ���ĺ��� �߰��ϰ� �Ǹ�, ���ĺ��� ���ؾ��ĺ��� ���� ����
								// ������ �Ǹ� �׷�ܾ�� ���ܵȴ�.

						for (int z = j + 1; z < str.length(); z++) {
							if (c == str.charAt(z)) {
								count--; // ���� ���ĺ��� ���� ���� �߰ߵǸ� �׷�ܾ��� ������ �ϳ� ���̰�, Loop1���� ����.
								continue Loop1;
							}
						}
					}
				}
			}
		}
        sc.close();
		System.out.println(count);
	}

}
