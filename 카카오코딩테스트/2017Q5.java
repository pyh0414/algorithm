
// https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
// 뉴스 클러스터링

import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String str1, String str2) {

        List list1 = subset(str1.toLowerCase());
        List list2 = subset(str2.toLowerCase());

        int intersection = 0;

        List<Integer> check = new ArrayList<Integer>(); // 교집합 구할 떄, 줍옥ㄷ

        for (int a = 0; a < list1.size(); a++) { // 교집합 개수 구하기
            String s1 = (String) list1.get(a);
            for (int b = 0; b < list2.size(); b++) {
                String s2 = (String) list2.get(b);
                if (s1.equals(s2) && !check.contains(b)) {
                    intersection++;
                    check.add(b);
                    break;
                }

            }
        }

        int union = list1.size() + list2.size() - intersection; // 합집합

        if (union == 0 && intersection == 0) {
            return 65536;
        }

        return (int) (((float) intersection / union) * 65536);
    }

    List subset(String s) { // 문자열 s의 부분집합

        List<String> list = new ArrayList<String>();
        char[] arr = s.toCharArray();
        int size = arr.length - 1;
        String str;
        int start = 0;
        int end = 1;

        while (end <= size) {
            str = String.valueOf(arr[start]) + String.valueOf(arr[end]);
            boolean isMatch = Pattern.matches("^[a-z]*$", str); // 부분집합의 원소가 영어로만 구성되어 있는지 확인
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
        }
        return list;
    }
}