/*
 *  2018.01.19 
 *  �м�ã��
 *  https://www.acmicpc.net/problem/1193
 */

package ��Ģã��;

import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int line = 0;
		int gap;
		int bottom = 1, top = 1;
		boolean isOdd;

		for (int i = 1; i <= n; i++) {

			sum += i; // ǥ�� ���� ĥ�� �Ͽ�, 1~N���� ������ ���� ���Ѵ�.

			if (n == 1) {
				line = 1;
				break;
			}
			if (n <= sum) { // ���� 1~N���� ������ ��(sum)�� ���ϴ� �Է¹��� �� n���� �۰� �Ǹ� �ش� n��° ���ݿ� ���ϴ� ���� �ִ�.
				line = i;
				break;
			}
		}

		gap = sum - n; // n���� ���ݿ��� ������ ���� ���ʰ����� ���° ������ �ִ� ������ ���Ѵ�.

		if (line % 2 == 0) { // ����� ���������� ���� �и�,������ �ʱ�ȭ ���� �޸����ش�.

			top = line;
			isOdd = false; // ¦��
		} else {

			bottom = line;
			isOdd = true; // Ȧ��
		}

		for (int i = 0; i < gap; i++) { // ������ ���� ��, �� ���� ������ ���� ������ ����ŭ �����Ѵ�.

			if (isOdd) { // Ȧ���� ��� ���ڴ� ��������, �и� ������.
				top++;
				bottom--;
			} else { // ¦���� ��� ���ڴ� ������ �и� ��������.
				top--;
				bottom++;
			}
		}

		System.out.println(top + "/" + bottom);
	}
}
