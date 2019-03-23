/*
 * 2018.01.02 
 * ���ĺ� ã��
 * https://www.acmicpc.net/problem/10809
 **/

package ���ڿ�;

import java.util.Arrays;
import java.util.Scanner;

public class Q10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		sc.close();
		int[] alphabet = new int[26];

		Arrays.fill(alphabet, -1);                   // �ѹ��� ������ �ʴ� ���ĺ��� -1�� ����ϹǷ� ���� ��� �ε����� -1�� �ʱ�ȭ
		for (int i = 0; i < s.length(); i++) {
			int n = s.charAt(i) - 'a';               // ���ĺ� �迭�������� �ε������� ���Ѵ�.

			if (alphabet[n] == -1) {                 // �ܾ�� �ߺ��Ǵ� ���ڰ� ���� �� ó�� �湮�ϴ� ��츸 üũ
				alphabet[n] = i;                     // �ܾ ó�� ������ ��ġ�� üũ
			}
		}

		for (int k : alphabet) {
			System.out.print(k + " ");
		}

	}

}
