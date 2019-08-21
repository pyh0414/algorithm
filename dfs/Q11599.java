import java.util.*;

public class Main {

    // 우,하,좌,상
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static boolean[][] check;
    static char[][] arr = new char[12][6];
    static int groupColorCount = 0;
    static List<Integer> yPosition = new ArrayList<Integer>();
    static List<Integer> xPosition = new ArrayList<Integer>();
    static int result = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int y, x;

        for (y = 11; y >= 0; y--) {
            String s = sc.next();
            for (x = 0; x < 6; x++) {
                arr[y][x] = s.charAt(x);
            }
        }

        if (!hasGroup()) { // 그룹이 하나라도 존재하지 않으면 0출력 후, return;
            System.out.println(0);
            return;
        }

        while (hasGroup()) { // group이 존재할 때 까지 반복
            for (y = 0; y < 12; y++) {
                for (x = 0; x < 6; x++) {
                    if (arr[y][x] != '.' && arr[y][x] != '?') {
                        groupColorCount = 0;
                        yPosition.clear();
                        xPosition.clear();

                        check = new boolean[12][6];
                        dfs(y, x, arr[y][x]);

                        if (groupColorCount >= 4) { // X 색깔을 탐색하여, 블럭이 4개 이상 모이면 '?'로 체크함.
                            colorCheck();
                        }
                    }
                }
            }
            move(); // 현 상황에서 그룹을 모두 찾으면, 그룹을 제거하고 블럭을 떨어뜨림
        }
        System.out.println(result);
    }

    static void dfs(int y, int x, char color) { // 각각의 알파벳을 기준으로 dfs탐색, groupColorCount을 사용한다.

        groupColorCount++;
        check[y][x] = true;
        yPosition.add(y);
        xPosition.add(x);

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX < 0 || newX > 5 || newY < 0 || newY > 11 || arr[newY][newX] != color) {
                continue;
            }
            if (arr[newY][newX] == color && !check[newY][newX]) {
                dfs(newY, newX, color);
            }
        }
    }

    static void colorCheck() { // 그룹에 속해있는 블럭을 '?'로 바꿈
        for (int i = 0; i < yPosition.size(); i++) {
            arr[yPosition.get(i)][xPosition.get(i)] = '?';
        }
    }

    static void move() { // 그룹이 없어지고, 블럭을 아래로 떨어뜨림

        boolean[] heights = new boolean[6];
        boolean check;
        int x, y;

        for (x = 0; x < 6; x++) { // 각 x축에서 '?'가 있는 곳을 체크
            for (y = 0; y < 12; y++) {
                check = false;
                if (arr[y][x] == '?') {
                    heights[x] = true;
                }
            }
        }

        for (x = 0; x < 6; x++) {
            if (!heights[x]) {
                continue;
            }
            for (y = 0; y < 12; y++) {
                if (arr[y][x] != '?' && arr[y][x] != '.') {
                    while (y > 0 && arr[y - 1][x] == '?') { // 실제로 블럭을 떨어뜨리는 부분, 현재 블럭을 기준으로 아래 블럭이 '?'이 아닐때까지 반복
                        char temp;
                        temp = arr[y - 1][x];
                        arr[y - 1][x] = arr[y][x];
                        arr[y][x] = temp;
                        y--;
                    }
                }
            }
            for (y = 0; y < 12; y++) { // '?'부분은 '.'로 바꿈
                if (arr[y][x] == '?') {
                    arr[y][x] = '.';
                }
            }
        }
        result++; // 한번 연쇄작용이 발생하였음
    }

    static boolean hasGroup() { // 그룹이 존재하는지 검사, dfs()사용

        int y, x;

        for (y = 0; y < 12; y++) {
            for (x = 0; x < 6; x++) {
                if (arr[y][x] != '.' && arr[y][x] != '?') {
                    groupColorCount = 0;
                    check = new boolean[12][6];
                    dfs(y, x, arr[y][x]);

                    if (groupColorCount >= 4) { // 없앨 수 있는 그룹이 있으면 return true;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}