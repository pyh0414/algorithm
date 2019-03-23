/*
 * 2018.03.03 
 * ť
 * https://www.acmicpc.net/problem/10845
 **/


package ť;

import java.util.Scanner;

public class Q10845 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String cmd;

		while (T-- > 0) {

			cmd = sc.next();
			if (cmd.equals("push")) {

				Queue.push(sc.nextInt());

			} else if (cmd.equals("pop")) {

				Queue.pop();

			} else if (cmd.equals("size")) {

				Queue.size();

			} else if (cmd.equals("empty")) {

				Queue.empty();

			} else if (cmd.equals("front")) {

				Queue.front();

			} else if (cmd.equals("back")) {

				Queue.back();

			}
		}

		sc.close();

	}

	static class Queue {

		static int front = 0;
		static int rear = -1;
		static int[] queue = new int[10000];
		static int a = 3;

		public static void push(int n) {

			queue[++rear] = n;

		}

		public static void pop() {

			if (front == rear + 1) {
				System.out.println("-1");
			} else {

				System.out.println(queue[front++]);

			}
		}

		public static void size() {
			System.out.println(rear + 1 - front);
		}

		public static void empty() {
			if (front == rear + 1) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

		public static void front() {

			if (front == rear + 1) {
				System.out.println("-1");
			} else {
				System.out.println(queue[front]);
			}
		}

		public static void back() {

			if (front == rear + 1) {
				System.out.println("-1");
			} else {
				System.out.println(queue[rear]);
			}
		}

	}

}

// package ť;
//
// import java.util.Scanner;
//
// public class Q10845 {
//
// int varfront;
//
// int varback;
//
// int maxSize;
//
// Object[] queueArray;
//
// static Scanner scanner = new Scanner(System.in);
//
// public Q10845(int maxSize) {
//
// this.varfront = 0;
//
// this.varback = -1;
//
// this.maxSize = maxSize;
//
// this.queueArray = new Object[maxSize];
//
// }
//
// public void push(Object item) {
//
// queueArray[++varback] = item;
//
// }
//
// public Object pop() {
//
// Object item = front();
//
// if (empty() != true)
//
// varfront++;
//
// return item;
//
// }
//
// public int size() {
//
// return varback + 1 - varfront;
//
// }
//
// public boolean empty() {
//
// return (varfront == varback + 1);
//
// }
//
// public Object front() {
//
// if (empty() == true)
//
// return -1;
//
// return queueArray[varfront];
//
// }
//
// public Object back() {
//
// if (empty() == true)
//
// return -1;
//
// return queueArray[varback];
//
// }
//
// public static void main(String[] args) {
//
// Q10845 arrayQueue = new Q10845(10000);
//
// int n;
//
// n = scanner.nextInt();
//
// scanner.nextLine();
//
// String order;
//
// for (int i = 0; i < n; i++) {
//
// order = scanner.nextLine();
//
// if (order.length() > 4 && order.substring(0, 4).equals("push")) {
//
// arrayQueue.push(order.substring(5, order.length()));
//
// } else if (order.equals("pop")) {
//
// System.out.println(arrayQueue.pop());
//
// } else if (order.equals("size")) {
//
// System.out.println(arrayQueue.size());
//
// } else if (order.equals("empty")) {
//
// System.out.println(arrayQueue.empty() == true ? 1 : 0);
//
// } else if (order.equals("front")) {
//
// System.out.println(arrayQueue.front());
//
// } else if (order.equals("back")) {
//
// System.out.println(arrayQueue.back());
//
// }
//
// }
//
// }
//
// }
