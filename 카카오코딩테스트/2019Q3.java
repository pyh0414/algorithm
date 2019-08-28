
// https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=java
// 후보키

import java.util.*;

class Solution {
    public int solution(String[][] relation) {

        int answer = 0;
        int ySize = relation.length;
        int xSize = relation[0].length;
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 1; i < (1 << xSize); i++) {
            if (check(i, relation, ySize, xSize)) { // 유일성을 먼저 체크
                list.add(i);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                int x = countBits(a);
                int y = countBits(b);

                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        while (list.size() != 0) { // 최소성 검사
            int n = list.remove(0); // n을 포함하는 나머지 키들을 제거
            answer++;

            for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
                int c = it.next();
                if ((n & c) == n) {
                    it.remove();
                }
            }
        }
        return answer;
    }

    boolean check(int subset, String[][] relation, int ySize, int xSize) { // subset이 relation을 유일하게 식별해주는지 검사

        for (int y = 0; y < ySize - 1; y++) {
            for (int yy = y + 1; yy < ySize; yy++) {

                boolean isSame = true;

                for (int k = 0; k < xSize; k++) {
                    if ((subset & 1 << k) == 0) {
                        continue;
                    }
                    if (relation[y][k].equals(relation[yy][k]) == false) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    System.out.println(subset);
                    return false;
                }
            }
        }
        return true;
    }

    int countBits(int n) {

        int ret = 0;

        while (n != 0) {
            if ((n % 1) != 0) {
                ret++;
            }
            n = n >> 1;
        }
        return ret;
    }
}