package ť;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();

		int docCount; // ��������
		int doc; // ã���� �ϴ� ������ queue�Ǿ ��ġ�� �ִ���
		int max = 0; // �߿䵵�� ���� ���� ��
		boolean flag = false;
		int count;

		int num = 0; // ť���� ã�����ϴ� ��ġ�� �ִ� ����

		while (T-- > 0) {

			docCount = sc.nextInt();
			doc = sc.nextInt();

			for (int i = 0; i < docCount; i++) {
				int x = sc.nextInt();

				if (doc == i) {
					num = x;
				}
				que.add(x);
			}

			max = Collections.max(que); // ť���� �ִ밪 ���ϱ�

			count = 0;

			while (true) {
				if (que.peek() == max) {

					if (que.peek() == num) {
						count++;
						System.out.println(count);
						break;
					}
					que.remove();
					max = Collections.max(que);
					count++;

				} else {

					que.add(que.remove());

				}
			}

		}
	}
}
