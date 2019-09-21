// https://programmers.co.kr/learn/courses/30/lessons/49993
// 영어 끝말잇기

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<String, Integer>();
        boolean isFail = false;
        String preWord = "";

        int user = 1;
        int count = 1;

        answer[0] = 0;
        answer[1] = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (user > n) {
                user = 1;
                count++;
            }

            if (map.get(word) != null) {
                isFail = true;
                break;
            }
            if (i > 0 && preWord.charAt(preWord.length() - 1) != word.charAt(0)) {
                isFail = true;
                break;
            }
            map.put(word, 1);
            preWord = word;
            user++;
        }

        if (isFail) {
            answer[0] = user;
            answer[1] = count;
        }

        return answer;
    }
}