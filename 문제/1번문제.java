
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {

        int minMove = 987654321;
        int move;
        int top;
        int num;

        for (int j = 0; j < A.length; j++) {

            top = A[j];
            move = 0;

            for (int i = 0; i < A.length; i++) {

                num = A[i];

                if (j == i || top == num) {
                    continue;
                }
                switch (num) {
                case 1:
                    if (top == 6) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                case 2:
                    if (top == 5) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                case 3:
                    if (top == 4) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                case 4:
                    if (top == 3) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                case 5:
                    if (top == 2) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                case 6:
                    if (top == 1) {
                        move += 2;
                    } else {
                        move++;
                    }
                    break;
                }
            }

            if (move < minMove) {
                minMove = move;
            }
        }

        return minMove;
    }
}