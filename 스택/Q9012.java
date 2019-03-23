/*
 *  2018.02.02
 *  °ýÈ£ 
 *  https://www.acmicpc.net/problem/9012
 **/

package ½ºÅÃ;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	    Stack stack = new Stack();
		int check;

		while (T-- > 0) {

			String str = sc.next();
			check = 0;

			for (int i = 0; i < str.length(); i++) {

				if (String.valueOf(str.charAt(i)).equals("(")) {
					check++;
				} else if (String.valueOf(str.charAt(i)).equals(")")) {
					check--;
				}

				if (check < 0) {
					break;
				}
			}
			if (check == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
