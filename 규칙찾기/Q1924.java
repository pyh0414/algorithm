/*
 *  2018.01.08 
 *  2007년
 *  https://www.acmicpc.net/problem/1924
 **/

package 규칙찾기;

import java.util.HashMap;
import java.util.Scanner;

public class Q1924 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String day[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int count = 0;

		int m = sc.nextInt();
		int d = sc.nextInt();

		for (int i = 0; i < m; i++) {
			if ((i + 1) == m) {
				count += d;
			} else {
				count += month[i];
			}
		}
		System.out.println(day[count % 7]);

	}

}
