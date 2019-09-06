import java.util.regex.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        List list1 = subset(str1.toLowerCase());
        List list2 = subset(str2.toLowerCase());

        int intersection = 0; // 교집합
        int union = list1.size() + list2.size(); // 합집합

        List<Integer> check = new ArrayList<Integer>();

        for (int a = 0; a < list1.size(); a++) {
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

        int symmetryDOF = union - intersection; // symmetry difference of sets : 차집합

        if (symmetryDOF == 0 && intersection == 0) {
            return 65536;
        }

        return (int) (((float) intersection / symmetryDOF) * 65536);
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
            boolean isMatch = Pattern.matches("^[a-z]*$", str);
            if (isMatch) {
                list.add(str);
            }
            start++;
            end++;
        }
        return list;
    }

}