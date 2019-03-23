/*
 *  2018.01.02 / 2577번
 * 세 수를 입력받아 곱했을 때, 결과값에 0~9의 숫자가 몇번 사용되었는지 구하라. 예를 들어 2577에서 2는 1번 5는 1번 7은 2분 사용 되었다.
 **/

package algorithm;

import java.util.Scanner;

public class Q2577 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b, c, mul;
		int[] result = new int[10];                       // 0~9 각 자리수와 빈도수 체크
		String str;

		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		mul = a * b * c;

		str = String.valueOf(mul);                         
		str.toCharArray();                               // 세 수를 곱한 mul값을 char배열로 변환

		for (int i = 0; i < str.length(); i++) {
			result[str.charAt(i) - 48]++;                // 각 배열의 값을 가져온다. 이때 char배열에서 가져온 값을 
		}                                                // 아스키 코드이므로, -48을 해줌으로써, 원하는 자리수 값을 얻고, 카운팅 해준다.

		for (int i = 0; i < result.length; i++) {
			System.out.println(i + "의 개수는 : " + result[i] + "개 입니다."); 
		}

	}

}
