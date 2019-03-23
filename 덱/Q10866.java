package µ¦;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10866 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String cmd;
		int n;

		while (T-- > 0) {

			cmd = sc.next();

			if (cmd.equals("push_back")) {

				n = sc.nextInt();
				dequeue.push_back(n);

			} else if (cmd.equals("push_front")) {

				n = sc.nextInt();
				dequeue.push_front(n);

			} else if (cmd.equals("pop_front")) {

				dequeue.pop_front();

			} else if (cmd.equals("pop_back")) {

				dequeue.pop_back();

			} else if (cmd.equals("size")) {

				dequeue.size();

			} else if (cmd.equals("empty")) {

				dequeue.empty();

			} else if (cmd.equals("front")) {

				dequeue.front();

			} else if (cmd.equals("back")) {

				dequeue.back();

			}
		}

	}

}

class dequeue {

	static ArrayList<Integer> deq = new ArrayList<Integer>();

	public static void push_front(int n) {

		deq.add(0, n);

	}

	public static void push_back(int n) {

		deq.add(deq.size(), n);

	}

	public static void pop_front() {

		if (deq.size() != 0) {
			System.out.println(deq.get(0));
			deq.remove(0);
		} else {
			System.out.println(-1);
		}
	}

	public static void pop_back() {

		if (deq.size() != 0) {
			System.out.println(deq.get(deq.size()-1));
			deq.remove(deq.size()-1);
		} else {
			System.out.println(-1);
		}

	}

	public static void size() {
		System.out.println(deq.size());
	}

	public static void empty() {

		if (deq.isEmpty()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void front() {

		if (!deq.isEmpty()) {
			System.out.println(deq.get(0));
		} else {
			System.out.println(-1);
		}
	}

	public static void back() {

		if (!deq.isEmpty()) {
			System.out.println(deq.get(deq.size()-1));
		} else {
			System.out.println(-1);
		}
	}
}
