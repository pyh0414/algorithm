/*
 * 2018.04.29 
 * 빠른A+B
 * https://www.acmicpc.net/problem/15552
 **/

package 소수구하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15552 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			bw.write(a + b + "\n");

		}

		bw.flush();
		bw.close();

	}

}
