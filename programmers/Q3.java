import java.util.*;

class Solution {
    public int solution(int[] cookie) {

        int max = 0;

        for (int i = 1; i < cookie.length; i++) {

            int l = i - 1;
            int r = i;
            int left = cookie[l];
            int right = cookie[r];

            if (left == right) {
                max = Math.max(max, left);
            }

            while (true) {
                if (l > 0 && left <= right) {
                    l--;
                    left += cookie[l];
                } else if (r < cookie.length - 1 && left >= right) {
                    r++;
                    right += cookie[r];
                } else {
                    break;
                }
                if (right == left) {
                    max = Math.max(max, left);
                }
            }

        }
        return max;
    }
}