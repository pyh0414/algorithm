package SortingAlgorithm;

public class SelectionSort {

	public static void main(String[] args) {

		int[] sample = { 4, 54, 2, 8, 63, 7, 55, 56, 124, 1, 78, 45, 55, 99, 231, 219, 185 };
		int minIndex, temp;
		int count=0;

		for (int i = 0; i < sample.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < sample.length; j++) {
				if (sample[j] < sample[minIndex]) {
					count++;
					minIndex = j;
				}
			}
			temp = sample[i];
			sample[i] = sample[minIndex];
			sample[minIndex] = temp;

		}

		for (int n : sample) {
			System.out.print(n + " ");
		}
		
		System.out.println(System.lineSeparator() + count + "¹ø");
	}

}
