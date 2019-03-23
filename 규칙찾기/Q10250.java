/*
 *  2018.01.08 
 *  ACMȣ��
 *  https://www.acmicpc.net/problem/10250
 **/

package ��Ģã��;

import java.util.Scanner;

public class Q10250 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int w, h, n;
		int x = 1, y = 1;

		int[][] tCase = new int[T][3];

		for (int k = 0; k < T; k++) {
			for (int i = 0; i < 3; i++) {
				tCase[k][i] = sc.nextInt();
			}
		}

		for (int j = 0; j < T; j++) {

			h = tCase[j][0];
			w = tCase[j][1];
			n = tCase[j][2];

			// -----------------------------------------�Է�����
			if (1 > h || w > 99 || (1 > n && n > h * w)) {
				System.out.println("���� �ٽ� �Է��� �ּ���");
			}
			// -----------------------------------------

			x = (n / h) + 1; // ���������� �ٷ� �չ��� ��쵵 x���⿡���� 1�� ���� ������ ������ +1.
			y = n % h; // y�������� ���° ������ Ȯ��

			if (n % h == 0) { // ���� ����� ���� ��� x�� �������� �ʾ�����, n/h�� 1�� �ǹǷ� 1�� �����ϰ� ��.
				x--;
				y = h;// �� ��� x���� 1 ������
			}

			System.out.println(100 * y + x);

		}
	}

}
