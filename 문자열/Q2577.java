/*
 *  2018.01.02 / 2577��
 * �� ���� �Է¹޾� ������ ��, ������� 0~9�� ���ڰ� ��� ���Ǿ����� ���϶�. ���� ��� 2577���� 2�� 1�� 5�� 1�� 7�� 2�� ��� �Ǿ���.
 **/

package algorithm;

import java.util.Scanner;

public class Q2577 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b, c, mul;
		int[] result = new int[10];                       // 0~9 �� �ڸ����� �󵵼� üũ
		String str;

		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		mul = a * b * c;

		str = String.valueOf(mul);                         
		str.toCharArray();                               // �� ���� ���� mul���� char�迭�� ��ȯ

		for (int i = 0; i < str.length(); i++) {
			result[str.charAt(i) - 48]++;                // �� �迭�� ���� �����´�. �̶� char�迭���� ������ ���� 
		}                                                // �ƽ�Ű �ڵ��̹Ƿ�, -48�� �������ν�, ���ϴ� �ڸ��� ���� ���, ī���� ���ش�.

		for (int i = 0; i < result.length; i++) {
			System.out.println(i + "�� ������ : " + result[i] + "�� �Դϴ�."); 
		}

	}

}
