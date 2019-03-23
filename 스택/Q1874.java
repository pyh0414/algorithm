/*
 * 2018.01.06
 *스택수열
 * https://www.acmicpc.net/problem/1874
 **/

package 스택;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q1874 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack stack = new Stack();
		int[] arr = new int[T];
		ArrayList<Character> list = new ArrayList<Character>();

		for (int i = 0; i < T; i++) {
			arr[i] = sc.nextInt();
		}

		int index = 0;

		for (int j = 1; j <= T; j++) {
			stack.push(j);
			list.add('+');

			while (!stack.empty() && (int) stack.peek() == arr[index]) {
				stack.pop();
				list.add('-');
				index++;
			}
		}

		for (char n : list) {
			System.out.println(n);
		}

	}

}
