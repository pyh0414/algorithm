/*
 *  2018.01.21
 *  Fly me to the Alpha Centauri 
 *  https://www.acmicpc.net/problem/1011
 **/

package 규칙찾기;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1011 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x, y, gap = 0, count = 0;
		ArrayList<Integer> countAry = new ArrayList<Integer>(); // 작동횟수의 최소값을 저장할 리스트

		for (int i = 0; i < n; i++) {      // x,y 즉 양쪽 지점부터 이동거리를 하나씩 증가하면서 이동한다.

			x = sc.nextInt();
			y = sc.nextInt();

			gap = 0;
			count = 0;
			while (true) {
				gap++; // 이동거리 변수로 과거 위치보다 n+1더 이동할 수 있으므로 이동거리를 1씩 증가해준다
				if (y - x <= gap) {   // 이동할 수 있는 거리가 1회 이하임            
					if (y - x <= 0) {     // 0인 경우는 서로 맞닿기 때문에 counting해주지 않는다
						countAry.add(count);
						break;
					}
					count++; 
					countAry.add(count);
					break;
				} else {         
					x += gap; // x부터 y 방향으로 1,2,3..씩 이동거리를 증가해가며 이동
					y -= gap; // y부터 x 방향으로 1,2,3..씩 이동거리를 증가해가며 이동
					count += 2; // x,y동시에 이동하므로 이동 횟수는 2씩 증가
				}
			}
		}

		for (int num : countAry) {
			System.out.println(num);
		}

	}

}
