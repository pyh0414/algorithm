
// https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
// 프렌즈 4블럭

import java.util.*;

class Solution {

    // 오른쪽, 아래, 왼쪽
    static int[] dx = { 1, 1, 0 };
    static int[] dy = { 0, 1, 1 };

    static List<Integer> listX = new ArrayList<Integer>();
    static List<Integer> listY = new ArrayList<Integer>();

    static char[][] blocks;
    static int count = 0;

    public int solution(int m, int n, String[] board) {

        int height = m;
        int width = n;
        blocks = new char[height][width];

        for (int i = 0; i < height; i++) {
            String str = board[i];
            for (int j = 0; j < width; j++) {
                blocks[i][j] = str.charAt(j);
            }
        }

        while (findRemovableBlocks()) { // 제거할 수 있는 블럭이 발견할 떄까지, 그 블록들을 없애면서 반복
            removeBlocks();
        }

        return count;
    }

    boolean findRemovableBlocks() { // 2x2구역이 있는지 검사,있다면 2x2구역의 시작점(왼쪽위)를 저장

        int height = blocks.length;
        int width = blocks[0].length;
        String str = "";

        for (int y = 0; y < height - 1; y++) { // 블럭이 만들어 지는 경우를 찾음, 찾으면 시작은(왼쪽위)를 저장
            for (int x = 0; x < width - 1; x++) {

                char c = blocks[y][x];
                if (c == ' ') { // '#'는 블럭의 시작점이 될 수 없기 때문에 continue;
                    continue;
                }
                int count = 0;
                int nx = 0, ny = 0;

                for (int k = 0; k < 3; k++) { // 오른쪽/오른쪽+아래/아래 부분에서 현재 문자와 같은지 검사
                    ny = y + dy[k];
                    nx = x + dx[k];
                    if (blocks[ny][nx] == c) {
                        count++;
                    }
                }
                if (count == 3) { // 하나의 블럭을 찾으면 그 시작점을 리스트에 저장
                    listX.add(nx);
                    listY.add(ny - 1);
                }
            }
        }

        if (listX.size() > 0 && listY.size() > 0) { // 시작점이 있으면 return true;
            return true;
        }
        return false;
    }

    void removeBlocks() { // 없어질 블럭에 '#'를 표시하고, 남은 블럭을 재정렬

        int x, y;
        int height = blocks.length;
        int width = blocks[0].length;

        for (int i = 0; i < listX.size(); i++) { // 없앨 블럭을 표시

            y = listY.get(i);
            x = listX.get(i);

            if (blocks[y][x] != ' ') {
                blocks[y][x] = ' ';
                count++;
            }

            for (int k = 0; k < 3; k++) {
                int newY = y + dy[k];
                int newX = x + dx[k];
                if (blocks[newY][newX] != ' ') {
                    blocks[newY][newX] = ' ';
                    count++;
                }
            }
        }

        for (y = height - 1; y >= 0; y--) { // 블럭 재정렬
            for (x = 0; x < width; x++) {
                if (blocks[y][x] == ' ') {
                    continue;
                } else {
                    int yy = y;
                    while (yy + 1 < height && blocks[yy + 1][x] == ' ') {
                        char temp;
                        temp = blocks[yy][x];
                        blocks[yy][x] = blocks[yy + 1][x];
                        blocks[yy + 1][x] = temp;
                        yy++;

                    }
                }
            }
        }

        listX.clear();
        listY.clear();

    }
}