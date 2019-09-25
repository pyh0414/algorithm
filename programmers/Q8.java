// https://programmers.co.kr/learn/courses/30/lessons/49993
// 예상 대진표

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b - a >= 1) {
            b = b % 2 == 1 ? (b = b / 2 + 1) : (b = b / 2);
            a = a % 2 == 1 ? (a = a / 2 + 1) : (a = a / 2);
            answer++;
        }

        return answer;
    }
}