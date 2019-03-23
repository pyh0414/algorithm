/*
 *  2018.01.26
 *  수 정렬하기
 *  https://www.acmicpc.net/problem/2750
 **/

package 정렬하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2750 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] numAry = new int[T];
		int temp;

		for (int i = 0; i < T; i++) {
			numAry[i] = sc.nextInt();
		}

		for (int j = 0; j < numAry.length - 1; j++) {
			for (int k = 0; k < numAry.length - j - 1; k++) {
				if (numAry[k + 1] < numAry[k]) {
                    temp=numAry[k+1];
                    numAry[k+1]=numAry[k];
                    numAry[k]=temp;
				}
			}
		}
		
		for(int n:numAry) {
			System.out.println(n);
		}
	}

}
