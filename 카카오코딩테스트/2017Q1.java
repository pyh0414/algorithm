
// https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
// 비밀지도

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            int num = arr1[i] | arr2[i];
            String s = String.valueOf(Integer.toBinaryString(num));
            String result = "";
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == '1') {
                    result += "#";
                } else {
                    result += " ";
                }
            }
            for (int j = 0; j < n - s.length(); j++) {
                result = " " + result;
            }
            System.out.println(result);
            answer[i] = result;
        }
        return answer;
    }
}