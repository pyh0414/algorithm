/*
 *  2018.01.22
 *  �� ��ȣ
 *  https://www.acmicpc.net/problem/1475
 **/

package ��Ģã��;

import java.util.Arrays;
import java.util.Scanner;

public class Q1475 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String T = String.valueOf(sc.nextInt());
		int[] numAry = new int[10]; // �Էµ� ������ �󵵼��� üũ�ϴ� �迭. �� ������ �󵵼��� �� ���� ��Ʈ�� �ǹ��Ѵ�.

		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '9') { // 6��9�� ���о��� ����� �� �����Ƿ�, �Էµ� ���ڰ� 9�̸� 6�� ī���� ���ش�.
				numAry[6]++;
				continue;
			}
			numAry[T.charAt(i) - '0']++; // �ƽ�Ű�ڵ带 �̿��Ͽ� ���� �󵵼� üũ
		}

		numAry[6] = (int) Math.round((double) numAry[6] / 2); // �� ��Ʈ���� 6,9�� �ְ� ���о��� 6�� ī���� �ȴ�. �Էµ� ���ڿ� 6,9�� ������ �󵵼��� 2��
																// �Ǿ� ��Ʈ��
																// 2�� ���� ǥ�õȴ� -> �󵵼�/2���� �ݿø��Ͽ� �ذ�. �󵵼��� 1�϶� 1��Ʈ, 2�϶�
																// 1��Ʈ, 3�϶� 2��Ʈ....

		Arrays.sort(numAry); // �ִ� �󵵼����� ���ϱ� ���� �����Ѵ�.

		System.out.print(numAry[numAry.length - 1]);

	}

}
