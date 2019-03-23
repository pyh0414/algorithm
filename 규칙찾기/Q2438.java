/*
 *  2018.01.18 
 *  별찍기-1
 *  https://www.acmicpc.net/problem/2438
 **/

package 규칙찾기;

import java.util.Scanner;

public class Q2438 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
