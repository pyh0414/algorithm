/*
*  2018.01.09 / 2108��
*  �����
*  https://www.acmicpc.net/problem/2108
**/

package �����ϱ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2108 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num;
		int count = sc.nextInt();

		int[] numAry = new int[count]; // �Է¹��� ���� ������ �迭

		ArrayList<Integer> list = new ArrayList<>(); // �ֺ󰪵��� ����
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // �� �������� �󵵼��� hashMap�� ����

		int max = 1; // �ֺ��� ������ ����.
		int mode = 0; 

		for (int i = 0; i < count; i++) {
			num = sc.nextInt();
			numAry[i] = num;
			sum += num;

			if (map.get(num) == null) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}

			if (map.get(num) > max) {
				max = map.get(num);
			}

		}

		for (int j = -4000; j <= 4000; j++) {

			if (map.get(j) == null) {
				continue;
			} else if (map.get(j) == max) {
				list.add(j);
			}

		}

		Collections.sort(list);

		if (list.size() == 1) {
			mode = list.get(0);
		} else if (list.size() >= 2) {
			mode = list.get(1);
		}

		Arrays.sort(numAry);

		System.out.println(Math.round(((double) sum / (double) count))); // ���� N���� ������
		System.out.println(numAry[count / 2]);
		System.out.println(mode);
		System.out.println(numAry[numAry.length - 1] - numAry[0]); // �ִ�밪�� �ּҰ��� ����

	}
}
