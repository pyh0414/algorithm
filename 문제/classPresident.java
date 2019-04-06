import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] ary = new int[n][6];
        List<Integer> check = new LinkedList<Integer>(); // 같은 반이였던 학생수를 확인/ 검사

        int n = sc.nextInt(); // 학생의 수
        int num; // 입력받을 값
        int value; // 현재n번째 학생의 n학년
        int max = 0; // 얼마나 많은 학생과 같은반이였는지 최대값
        int maxIndex = 0; // 가장 많은 학생들과 같은반을 한 학생
        int maxCount = 0; // 최대값이 몇번 중복되는지 확인

        for (int q = 0; q < n; q++) {
            for (int w = 0; w < 5; w++) {
                num = sc.nextInt();
                ary[q][w] = num;
            }
        }

        for (int q = 0; q < n; q++) {
            for (int w = 0; w < 5; w++) {
                value = ary[q][w];

                for (int e = 0; e < n; e++) {
                    if (q != e && value == ary[e][w]) { // 나를 제외하고, 다른 학생과 같은 반이였는지 검사,
                        if (check.contains(e)) { // 이미 한번 같은반이었던 사람은 제외.
                            continue;
                        } else {
                            ary[q][5] += 1; // 같은반이었던 사람의 수를 카운팅
                            check.add(e); // 같은 반이였던 사람의 중복체크를 위해 리스트에 추가
                        }
                    }
                }
            }

            if (ary[q][5] > max) {
                max = ary[q][5];
                maxIndex = q + 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (ary[j][5] == max) {
                maxCount++; // 같은 반이였던 사람의 최대값이 중복되는 경우를 조사하기 위함.
            }
        }

        if (maxCount == 1) {
            System.out.println(maxIndex);
            return;
        } else if (maxCount > 1) {
            for (int f = 0; f < n; f++) {
                if (ary[f][5] == max) {
                    System.out.println(f + 1);
                    return;
                }
            }
        }
    }
}