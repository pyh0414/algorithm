// https://programmers.co.kr/learn/courses/30/lessons/49993
// 짝지어 제거하기

import java.util.*;

class Solution {
    public int solution(String s) {

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (!stack.empty() && (char) stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if (stack.empty()) {
            return 1;
        }
        return 0;
    }
}