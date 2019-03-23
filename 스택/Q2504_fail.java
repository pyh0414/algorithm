package Ω∫≈√;

import java.util.Scanner;
import java.util.Stack;

public class Q2504_fail {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String T = sc.next();
		Stack<String> stack = new Stack();

		int check = 0;

		for (int j = 0; j < T.length(); j++) {

			if (check == -1) {
				System.out.println(0);
				return;
			}

			String s = String.valueOf(T.charAt(j));

			if (s.equals("(") || s.equals("[")) {
				stack.push(s);
			} else {

				if (s.equals(")")) {
					if (stack.peek().equals("(")) {
						stack.pop();
						stack.push("2");
					} else {

						check = stackInnerLoop(stack, "[", "(", 2);

					}

				} else if (s.equals("]")) {
					if (stack.peek().equals("[")) {
						stack.pop();
						stack.push("3");
					} else {

						check = stackInnerLoop(stack, "(", "[", 3);

					}
				}
			}
		}

		int sum = 0;

		while (!stack.empty()) {
			sum += Integer.valueOf(stack.peek());
			stack.pop();
		}
		System.out.println(sum);
	}

	public static int stackInnerLoop(Stack<String> stack, String s1, String s2, int value) {

		int result = 0;

		while (!stack.isEmpty()) {
			String top = stack.peek();
			if (top.equals(s1)) {
				return -1;
			} else if (top.equals(s2)) {
				stack.pop();
				result *= value;
				stack.push(String.valueOf(result));
				break;
			} else {
				result += Integer.parseInt(stack.pop());
			}
		}
		return result;
	}
}
