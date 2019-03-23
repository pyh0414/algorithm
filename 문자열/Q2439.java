/*
 *  2018.01.02 / 2439번
 *  입력받은 라인 수만큼 출력하고, 1번쨰 줄은 별 1개, 2번째 줄은 별2개......N개 만큼 출력
 * */

package algorithm;

import java.util.Scanner;

public class Q2439 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();                           // 라인 수 

		for (int i = 1; i <= count; i++) {                  // 바깥 for문의 i값은 1,2,3...n 까지
			for (int k = count; k > 0; k--) {               // 안쪽 for문의 k값은 n,n-1,n-2...1
				if (k <= i) {                               // 만약 k 값이 i보다 작거나 같다(공백을 다 출력했다면 별모양 출력) 
					System.out.print("*");                
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();                            // 개행

		}
	}

}
