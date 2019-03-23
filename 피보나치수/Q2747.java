/*
 * 2018.03.03
 * �Ǻ�ġ ��
 * https://www.acmicpc.net/problem/2747
 **/

package �Ǻ���ġ��;

import java.util.Scanner;

public class Q2747 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.close();

		if (T <= 1) {
			System.out.println(T);
			return;
		}

		int otherother = 0; // ���ؾ� �ϴ� ������ ù��° (2���� �����̹Ƿ�, 0���� �ʱ�ȭ)
		int other = 1; // ���ؾ� �ϴ� ������ �ι�° (2���� �����̹Ƿ�, 1�� �ʱ�ȭ)
		int sum = 0;

		for (int i = 0; i <= T - 2; i++) {

			sum = otherother + other; // n����

			otherother = other;
			other = sum;

		}

		System.out.println(sum);

	}

}
