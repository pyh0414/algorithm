package SortingAlgorithm;

public class InsertionSort {

	public static void main(String[] args) {

		int[] sample = { 4, 54, 2, 8, 63, 7, 55, 56, 124, 1, 78, 45, 55, 99, 231, 219, 185 };
		int standard, cmp;
		int count = 0;

		for (int i = 1; i < sample.length; i++) {
			standard = sample[i];
			cmp = i - 1;

			while (cmp >= 0 && standard < sample[cmp]) {
				sample[cmp + 1] = sample[cmp];
				cmp--;
			}
			sample[cmp + 1] = standard;
			count++;
		}

		for (int n : sample) {
			System.out.print(n + " ");
		}
		System.out.println(System.lineSeparator() + count + "¹ø");
	}

}
