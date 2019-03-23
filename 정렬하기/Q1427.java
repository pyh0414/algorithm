/*
 *  2018.01.09 / 1427번
 *  소트인사이드
 *  https://www.acmicpc.net/problem/1427
 **/

package 정렬하기;

import java.util.Scanner;

public class Q1427 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		sc.close();
		int temp;

		int[] numAry = new int[num.length()];

		for (int i = 0; i < numAry.length; i++) {
			numAry[i] = num.charAt(i) - 48;
		}

		for (int i = 0; i < numAry.length; i++) {
			for (int j = 0; j < (numAry.length - i) - 1; j++) {         // 안쪽 for문이 끝날 때 가장 오른쪽에 i개수 만큼 정렬되기 떄문에 -i
				
				if (numAry[j] < numAry[j + 1]) {
					temp = numAry[j];
					numAry[j] = numAry[j + 1];
					numAry[j + 1] = temp;
				}
				
			}
		}

		for (int n : numAry) {
			System.out.print(n);
		}

	}

}
