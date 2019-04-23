import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] ary = new int[n][3];
        List<String> check = new LinkedList<String>(); // strike인 숫자를 저장하는 배열. 나중에 ball을 검사할 때 중복되는 숫자를 피하기 위함
        String str = "";

        for (int i = 0; i < n; i++) {
            ary[i][0] = sc.nextInt(); // 물어본 숫자
            ary[i][1] = sc.nextInt(); // 스트라이크 개수
            ary[i][2] = sc.nextInt(); // 볼 개수

            str += String.valueOf(ary[i][0]);
        }

        int num, strike, ball;
        int strikeCount = 0, ballCount = 0;
        int count = 0;
        int result;

        for (int i = 123; i <= 987; i++) {

            result = 0; // i숫자가 해당 테스트케이스를 몇개나 만족하는지
            String numString = String.valueOf(i);

            if (numString.charAt(0) == numString.charAt(1) || numString.charAt(1) == numString.charAt(2)
                    || numString.charAt(0) == numString.charAt(2) || numString.contains("0")) {
                continue;
            } // 숫자중에 중복된 숫자가 있거나 0이 있는 숫자는 제외

            for (int j = 0; j < n; j++) {

                strikeCount = 0;
                ballCount = 0;
                check.clear();

                num = ary[j][0];
                strike = ary[j][1];
                ball = ary[j][2];

                if (i / 100 == num / 100) { // 100의 자리 같은지 확인
                    strikeCount++;
                    check.add(String.valueOf(i / 100));
                }
                if (i % 100 / 10 == num % 100 / 10) { // 10의자리 같은지 확인
                    strikeCount++;
                    check.add(String.valueOf(i % 100 / 10));
                }
                if (i % 100 % 10 == num % 100 % 10) { // 1의자리 같은지 확인
                    strikeCount++;
                    check.add(String.valueOf(num % 100 % 10));
                }

                if (strike == 3 && strikeCount == 3) { // 스트라이크가 3개면 return;
                    count++;
                    break;
                }

                String s1 = String.valueOf(i);
                String s2 = String.valueOf(num);
                String s3;

                for (int g = 0; g < s1.length(); g++) { // i숫자와 num숫자를 비교하면서 strike인 숫자를 제외하고 같은 숫자가 몇개나 있는지 확인
                    s3 = String.valueOf(s1.charAt(g));
                    if (s2.contains(s3) && !check.contains(s3)) {
                        ballCount++;
                    }
                }

                if (strikeCount == strike && ballCount == ball) { // i숫자가 테스트케이스를 만족한다면 result++
                    result++;
                }
            }
            if (result == n) { // 숫자i가 모든 테스트케이스를 통과하면 정답
                count++;
            }
        }
        System.out.println(count);
    }
}