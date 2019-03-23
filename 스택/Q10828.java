/*
 *  2018.02.01
 *  스택
 *  https://www.acmicpc.net/problem/10828
 **/

package 스택;

import java.util.Scanner;

public class Q10828 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String cmd;
		int n;

		while (T-- > 0) {

			cmd = sc.next();
			if (cmd.equals("push")) {

				n = sc.nextInt();
				Stack.push(n);

			} else if (cmd.equals("top")) {

				Stack.top();

			} else if (cmd.equals("size")) {

				Stack.size();

			} else if (cmd.equals("empty")) {

				Stack.empty();

			} else if (cmd.equals("pop")) {
				Stack.pop();
			}
		}
	}

	static class Stack {

		static int[] stack = new int[1000];
		static int currentIndex = -1;

		static void push(int n) {

			stack[++currentIndex] = n;

		}

		static void pop() {

			if (currentIndex < 0) {
				System.out.println(-1);
			} else {
				System.out.println(stack[currentIndex--]);

			}

		}

		static void size() {

			System.out.println(currentIndex+1);

		}

		static void empty() {
			if (currentIndex < 0) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

		static void top() {
			if (currentIndex < 0) {
				System.out.println(-1);
			} else {
				System.out.println(stack[currentIndex]);
			}
		}
	}
}
