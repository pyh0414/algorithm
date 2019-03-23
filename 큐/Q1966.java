package 큐;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Queue<Integer> que = new LinkedList<Integer>();

		int docCount; // 문서갯수
		int doc; // 찾고자 하는 문서가 queue의어떤 위치에 있는지
		int max = 0; // 중요도가 가장 높은 자
		boolean flag = false;
		int count;

		int num = 0; // 큐에서 찾고자하는 위치에 있는 숫자

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

			max = Collections.max(que); // 큐에서 최대값 구하기

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
