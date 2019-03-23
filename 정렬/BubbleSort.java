package SortingAlgorithm;

public class BubbleSort {
	// 오름차순 정렬
	public static void main(String[] args) {

		int[] sample = { 4, 54, 2, 8, 63, 7, 55, 56, 124, 1, 78, 45, 55, 99, 231, 219, 185 };
		int temp, count = 0;

		for (int i = 0; i < sample.length - 1; i++) {
			for (int j = 0; j < sample.length - 1 - i; j++) { 

				if (sample[j] > sample[j + 1]) {
					count++;
					temp = sample[j];
					sample[j] = sample[j + 1];
					sample[j + 1] = temp;
				}
			}
		}

		for (int n : sample) {
			System.out.print(n + " ");
		}

		System.out.println(System.lineSeparator() + count + "번");
	}

}
