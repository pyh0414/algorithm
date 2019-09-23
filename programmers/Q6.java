// https://programmers.co.kr/learn/courses/30/lessons/49993
// 숫자게임

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {

        List<Integer> b = new ArrayList<Integer>();

        int score = 0;

        for (int i = 0; i < B.length; i++) {
            b.add(B[i]);
        }

        Collections.sort(b);
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            int aNum = A[i];
            for (int j = 0; j < b.size(); j++) {
                int bNum = b.get(j);
                if (bNum > aNum) {
                    score++;
                    b.remove(j);
                    break;
                }
            }
        }
        return score;
    }
}