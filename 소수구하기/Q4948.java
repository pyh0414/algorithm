/*
 * 2018.01.02 
 * ����Ʈ�� ����
 * https://www.acmicpc.net/problem/4948
 **/

package �Ҽ����ϱ�;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q4948 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num;
		int[] visit = new int[246914];
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count;
		visit[1] = 1;

		// for (int i = 2; i * i < 246913; i++) {
		//
		// for (int j = i * i; j < 246913; j = i + j) {
		//
		// if (visit[j] == 0) {
		//
		// visit[j] = 1; // �Ҽ��� �ƴѰ��� 1ǥ��
		//
		// }
		//
		// }
		//
		// }

		for (int i = 2; i <= 496; i++) { // 496*496 = 246016
			for (int j = i * i; j <= 246913; j = j + i) {
				if (visit[j] == 0) {
					visit[j] = 1;                    // �Ҽ��� �ƴ� �κ��� 1�� ���
				}
			}
		}

		while (true) {

			num = sc.nextInt();

			if (num == 0)
				break;

			count = 0;

			for (int i = num + 1; i <= 2 * num; i++) {

				if (visit[i] == 0) {

					count++;

				}

			}

			list.add(count);

		}

		for (int z : list) {
			System.out.println(z);
		}

	}

}
