package ť;

import java.util.LinkedList;
import java.util.Scanner;

public class Q11866 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int n = sc.nextInt();
		int count = 0;
		int index = n - 1;

		int[] list = new int[T];
		for (int i = 0; i < T; i++) {
			list[i] = i + 1;
		}

		System.out.print("<");

		while (count != T) {

			if (list[index] != 0) {

				if (count == T - 1) {
					System.out.print(list[index]);
				} else {
					System.out.print(list[index] + ", ");
				}

				list[index] = 0;
				count++;
			}

			int flag = -1;

			while (flag < n) {

				flag++;
				index++;

				if (index != list.length && list[index] == 0) {

					flag--;
					continue;

				} else if (index == list.length) {
					index = 0;
				}
			}

			if (index > list.length - 1) {
				index %= list.length - 1;
			}

		}

		System.out.print(">");

	}
}