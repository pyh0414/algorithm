/*
 *  2018.01.05 
 *  ����
 *  https://www.acmicpc.net/problem/2292
 **/

package ��Ģã��;

import java.util.Arrays;
import java.util.Scanner;

public class Q2292 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int roomNum = sc.nextInt();
		sc.close();

		int i = 0;
		int count = 1;
		int min, max;

		while (true) {

			if (roomNum == 1) { // 1�� ���� Ž���ϴ� ���� 1�� Ž���Ѵ�.
				System.out.println(count);
				break;
			}
			min = 2 + (3 * i) * (i + 1); // �� ���� �ּڰ�, �ִ��� ����
			max = (3 * i * i) + ((9 * i) + 7);

			i++; // �� ���� ��Ÿ���� ��
			count++; // �ϴ� �濡 �� �� �˻��ϹǷ�, Ư�� ������ ���� �ִ��� ������ �˻��ϱ� ���� ���� counting�Ѵ�.

			if (roomNum >= min && roomNum <= max) { // ã���� �ϴ� ���� ��ȣ�� Ư�� �������� ������ ���� ���� ����Ѵ�.
				System.out.println(count);
				break;
			}

		}

	}
}
