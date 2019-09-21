// https://programmers.co.kr/learn/courses/30/lessons/49993
// 방문길이

import java.util.*;

class Solution {
    static List<String> pathCheck = new ArrayList<String>();

    public int solution(String dirs) {

        int y = 0, x = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            String path = "";
            int preX = x;
            int preY = y;

            if (c == 'U' && y + 1 <= 5) {
                y++;
                path = String.valueOf(preX) + String.valueOf(preY) + String.valueOf(x) + String.valueOf(x);
                System.out.print("U");
                if (!pathCheck.contains(path)) {
                    addPath(preX, preY, x, y);
                }

                continue;
            } else if (c == 'D' && y - 1 >= -5) {
                y--;
                path = String.valueOf(preX) + String.valueOf(preY) + String.valueOf(x) + String.valueOf(x);
                System.out.print("D");
                if (!pathCheck.contains(path)) {
                    addPath(preX, preY, x, y);
                }

                continue;
            } else if (c == 'R' && x + 1 <= 5) {
                x++;
                path = String.valueOf(preX) + String.valueOf(preY) + String.valueOf(x) + String.valueOf(x);
                System.out.print("R");
                if (!pathCheck.contains(path)) {
                    addPath(preX, preY, x, y);
                }

                continue;
            } else if (c == 'L' && x - 1 >= -5) {
                x--;
                path = String.valueOf(preX) + String.valueOf(preY) + String.valueOf(x) + String.valueOf(x);
                System.out.print("L");
                if (!pathCheck.contains(path)) {
                    addPath(preX, preY, x, y);
                }

                continue;
            }

        }
        return pathCheck.size() / 2;
    }

    void addPath(int preX, int preY, int x, int y) {
        pathCheck.add(String.valueOf(preX) + String.valueOf(preY) + String.valueOf(x) + String.valueOf(y));
        pathCheck.add(String.valueOf(x) + String.valueOf(y) + String.valueOf(preX) + String.valueOf(preY));

        System.out.println();
    }
}