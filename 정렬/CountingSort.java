package SortingAlgorithm;

import java.util.Scanner;

public class CountingSort {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] numAry = new int[T];
		int max = 1;

		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();

			if (n > max) {
				max = n;
			}
			numAry[i] = n;
		}

		int[] countingAry = new int[max];

		for (int j = 0; j < numAry.length; j++) {
			countingAry[numAry[j] - 1]++; // 각 숫자의 빈도수 체크
		}

		for (int k = 1; k < countingAry.length; k++) {
			countingAry[k] = countingAry[k - 1] + countingAry[k]; // 각 인덱스에 이전 인덱스의 값을 더함함
		}
		int index = 0;

		for (int n = 0; n < countingAry.length; n++) {

			if (n > 0) {
				for (int i = 0; i < countingAry[n] - countingAry[n - 1]; i++) {
					numAry[index++] = n + 1;
				}
			}

			if (n == 0) {
				for (int i = 0; i < countingAry[n]; i++) {
					numAry[index++] = n + 1;
				}
			}

		}

		for (int k : numAry) {
			System.out.print(k + " ");
		}
	}
}
