// https://programmers.co.kr/learn/courses/30/lessons/49993
// 스킬트리

class Solution {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;
        int i = 0;
        String result = "";
        int[] check = new int[100];

        for (i = 0; i < skill.length(); i++) {
            check[skill.charAt(i)] = i + 1;
        }

        for (String str : skill_trees) {
            result = "";
            for (i = 0; i < str.length(); i++) {

                String s = String.valueOf(str.charAt(i));

                if (skill.contains(s)) {
                    result += s;
                }
            }

            if (result == "" || (result.length() == 1 && result.charAt(0) == skill.charAt(0))) {
                answer++;
                continue;
            }

            if (result.charAt(0) == skill.charAt(0) && result.length() > 1) {
                boolean isOrdered = true;
                for (i = 1; i < result.length(); i++) {
                    char pre = result.charAt(i - 1);
                    char cur = result.charAt(i);

                    if (check[cur] != check[pre] + 1) {
                        isOrdered = false;
                        break;
                    }
                }

                if (isOrdered) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
