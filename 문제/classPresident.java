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
                    if (q != e && value == ary[e][w]) {
                        if (check.contains(e)) {
                            continue;
                        } else {
                            ary[q][5] += 1;
                            check.add(e);
                        }
                    }
                }
            }

            check.clear();
            if (ary[q][5] > max) {
                max = ary[q][5];
                maxIndex = q + 1;
            }
        }

        for (int j = 0; j < n; j++) {
            if (ary[j][5] == max) {
                maxCount++;
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