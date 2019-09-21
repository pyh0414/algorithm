// https://programmers.co.kr/learn/courses/30/lessons/49993
// 예산

import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for (int n : d) {
            if (budget >= n) {
                answer++;
                budget -= n;
            }
        }
        return answer;
    }
}