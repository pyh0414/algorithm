/*
 *  2018.01.02 / 2439��
 *  �Է¹��� ���� ����ŭ ����ϰ�, 1���� ���� �� 1��, 2��° ���� ��2��......N�� ��ŭ ���
 * */

package algorithm;

import java.util.Scanner;

public class Q2439 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();                           // ���� �� 

		for (int i = 1; i <= count; i++) {                  // �ٱ� for���� i���� 1,2,3...n ����
			for (int k = count; k > 0; k--) {               // ���� for���� k���� n,n-1,n-2...1
				if (k <= i) {                               // ���� k ���� i���� �۰ų� ����(������ �� ����ߴٸ� ����� ���) 
					System.out.print("*");                
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();                            // ����

		}
	}

}
