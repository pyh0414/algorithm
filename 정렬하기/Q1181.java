/*
*  2018.01.09 / 1181��
*  �ܾ�����
*  https://www.acmicpc.net/problem/1181
**/

package �����ϱ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1181 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String word;

		String[] strAry = new String[num];
		ArrayList list = new ArrayList();

		for (int i = 0; i < strAry.length; i++) {
			word = sc.next();

			if (list.contains(word)) { // �ߺ� �ܾ� �˻�
				strAry[i] = "";
				continue;
			}

			list.add(word);
			strAry[i] = word;

		}

		Arrays.sort(strAry); // ���ĺ������� ����

		String temp;

		for (int i = 0; i < strAry.length - 1; i++) { // ���̼����� ����
			for (int j = 0; j < (strAry.length - i) - 1; j++) {

				if (strAry[j].length() > strAry[j + 1].length()) {
					temp = strAry[j];
					strAry[j] = strAry[j + 1];
					strAry[j + 1] = temp;
				}
			}
		}

		for (String s : strAry) {
			if (s == "") {
				continue;
			}
			System.out.println(s);
		}

	}

}
