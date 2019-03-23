/*
 * 2018.01.02 
 * �Ҽ� ���ϱ�
 * https://www.acmicpc.net/problem/1929
 **/

package �Ҽ����ϱ�;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1929 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean checker[] = new boolean[n + 1];
		checker[1] = true;

		for (int i = 2; i <= n; i++) {

			if (!checker[i]) {

				for (int j = i + i; j <= n; j += i) {

					checker[j] = true;

				}

			}
		}
		for (int i = m; i <= n; i++) {
			if (!checker[i]) {
				System.out.println(i);
			}
		}
	}
}



//public class Q1929 {
//
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int min = sc.nextInt();
//		int max = sc.nextInt();
//
//		sc.close();
//		int count; // ����� ����
//
//		ArrayList<Integer> list = new ArrayList<Integer>(); // �Ҽ��� ������ ����Ʈ
//
//		for (int i = min; i <= max; i++) {
//			if (primeCheck(i)) {
//				list.add(i);
//			}
//		}
//
//		for (int n : list) {
//			System.out.println(n);
//		}
//	}
//
//	static boolean primeCheck(int i) {
//
//		int n = (int) Math.sqrt((double) i);
//
//		for (int j = 2; j <= n; j++) {
//			if (i % j == 0) {
//				return false;
//			}
//		}
//		return true;
//
//	}
//
//}

