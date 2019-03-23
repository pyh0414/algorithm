/*
 *  2018.01.21
 *  Fly me to the Alpha Centauri 
 *  https://www.acmicpc.net/problem/1011
 **/

package ��Ģã��;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1011 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x, y, gap = 0, count = 0;
		ArrayList<Integer> countAry = new ArrayList<Integer>(); // �۵�Ƚ���� �ּҰ��� ������ ����Ʈ

		for (int i = 0; i < n; i++) {      // x,y �� ���� �������� �̵��Ÿ��� �ϳ��� �����ϸ鼭 �̵��Ѵ�.

			x = sc.nextInt();
			y = sc.nextInt();

			gap = 0;
			count = 0;
			while (true) {
				gap++; // �̵��Ÿ� ������ ���� ��ġ���� n+1�� �̵��� �� �����Ƿ� �̵��Ÿ��� 1�� �������ش�
				if (y - x <= gap) {   // �̵��� �� �ִ� �Ÿ��� 1ȸ ������            
					if (y - x <= 0) {     // 0�� ���� ���� �´�� ������ counting������ �ʴ´�
						countAry.add(count);
						break;
					}
					count++; 
					countAry.add(count);
					break;
				} else {         
					x += gap; // x���� y �������� 1,2,3..�� �̵��Ÿ��� �����ذ��� �̵�
					y -= gap; // y���� x �������� 1,2,3..�� �̵��Ÿ��� �����ذ��� �̵�
					count += 2; // x,y���ÿ� �̵��ϹǷ� �̵� Ƚ���� 2�� ����
				}
			}
		}

		for (int num : countAry) {
			System.out.println(num);
		}

	}

}
