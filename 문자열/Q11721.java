/*
 *  2018.01.02 / 11721��
 *  ���ĺ� �ҹ��ڿ� �빮�ڷθ� �̷���� ���̰� N�� �ܾ �־����� �� �ٿ� 10���ھ� ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 **/

package algorithm;

import java.util.Scanner;

public class Q11721 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[] ary = new char[100];
		String str = null;

		str = sc.next();
		str.toCharArray();                          // ���ڿ��� ���ڹ迭�� ��ȯ    

		for (int i = 0; i < str.length(); i++) {    // �迭���� 0�� �κ��� �����ϰ�, ���� 10�� ������ ����
			if (i > 0 && i % 10 == 0) {
				System.out.println();
			}
			System.out.print(str.charAt(i));
		}

	}

}
