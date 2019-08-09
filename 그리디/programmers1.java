// https://programmers.co.kr/learn/courses/30/lessons/42862?language=java#

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];

        int i;
        int answer = n - lost.length;

        for (i = 0; i < reserve.length; i++) {
            students[reserve[i]] = 2;
        }

        for (i = 0; i < lost.length; i++) {
            if (students[lost[i]] == 2) {
                students[lost[i]] = 1;
                answer++;
            }
        }

        int index;
        for (i = 0; i < lost.length; i++) {
            index = lost[i];

            if (students[index] == 1) {
                continue;
            } // 여벌 체육복을 가지고 있지만 도난 당한 경우

            if (students[index - 1] == 2) {
                students[index - 1] = 1;
                answer++;
                continue;
            } // 먼저 왼쪽 친구한테 빌린다.

            if (students[index + 1] == 2) {
                students[index + 1] = 1;
                answer++;
            } // 오른쪽 친구한테 빌린다.

        }
        return answer;
    }
}
