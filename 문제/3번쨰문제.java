
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] T) {

        List<Integer> winter = new LinkedList<Integer>();

        winter.add(T[0]);

        for (int i = 1; i < T.length - 1; i++) {
            if (Collections.max(winter) < T[i]) {
                break;
            } else {
                winter.add(T[i]);
            }
        }

        return winter.size();
    }
}