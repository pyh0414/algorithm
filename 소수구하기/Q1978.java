/*
 * 2018.01.02 
 * �Ҽ� ã��
 * https://www.acmicpc.net/problem/1978
 **/

package �Ҽ����ϱ�;

import java.util.Scanner;

public class Q1978 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num;
		int flag = 0;
		int pnCount = 0; // �Ҽ����� counting
		int j;

		for (int i = 0; i < n; i++) {

			num = sc.nextInt();

			if (num == 1) { // 1�� �Ҽ��� �ƴϹǷ� ����.
				continue;
			}

			j = 1; // �� ���ڸ� ������ ������ ��
			flag = 0; // �Ҽ� üũ count��
			while (j <= num) { // j

				if (num % j == 0) { // �� ���ڸ� 1..n���� ���ϴ� ���� ������ ������ �Ͽ�, ������ �������� flag++�� �Ѵ�.
					flag++;
				}

				j++; // �Է¹��� ���ڿ� ������ ������ ���� 1�����Ѵ�.
			}
			if (flag == 2) { // �Է¹��� ù���� ���� �˻��Ͽ�, ���� flag==2�̴� ->������ �������� ���� 2�� �ִ�(1�� �ڱ��ڽ�) = �Ҽ��̴�.

				pnCount++;
			}

		}
		sc.close();

		System.out.println(pnCount);

	}

}
