import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt(); // 테트리스 가로
        int height = sc.nextInt(); // 테트리스 세로
        int[][] ary = new int[height][width]; // 현재 테트리스를 저장하는 배열

        boolean depthChecek; // 막대기를 넣었을 때 맵을 벗어나는지 검사
        int depthCheckFailList = 0; // 막대기를 넣었을때 맵상을 벗어나는 경우의 수
        List<Map> mapList = new LinkedList<Map>(); // ㅣ모양 블럭을 넣을 수 있는 경우의 집합
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // ㅣ모양 블럭을 넣을 수 있는 경우

        int maxDepth = 0; // 한번에 블록수평선을 없앨 수 있는 최대 개수
        int maxDepthXPosition = 0; // 한번에 블록수평선을 없앨 수 있는 x위치 값

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                ary[h][w] = sc.nextInt();
            }
        }

        for (int x = 0; x < width; x++) { // 모든 n번째 x위치를 검사
            depthChecek = true;
            for (int y = 0; y < 4; y++) { // ㅣ모양 블럭 맵을 넣는 경우 맵을 벗어나는지 검사
                if (ary[y][x] == 1) {
                    depthChecek = false;
                    depthCheckFailList++; // 맵을 벗어나는 경우를 체크
                    break;
                }
            }
            if (depthChecek) {
                map = removeBlockCheck(ary, x, height, width); // 벗어나지 않는다면, 얼마나 많은 수평블럭을 없앨 수 있는지 구함
                mapList.add(map);
            } else {
                continue;
            }
        }

        if (depthCheckFailList == width) { // 모든 x에 대하여 ㅣ블럭을 넣어 맵읇 벗어나면 게임 종료
            System.out.println(0 + " " + 0);
            return;
        }

        for (Map m : mapList) {
            Iterator<Integer> keys = m.keySet().iterator();
            while (keys.hasNext()) {

                int key = keys.next();
                int value = (int) m.get(key);

                if (value > maxDepth) { // 맵을 돌면서 가장 많이 수평블럭을 없앨 수 있는 개수와 그때의 x값을 구함
                    maxDepth = value;
                    maxDepthXPosition = key + 1;
                }
            }
        }
        if (maxDepth == 0) {
            System.out.println(0 + " " + 0);
        } else {
            System.out.println(maxDepthXPosition + " " + maxDepth);
        }
    }

    static Map<Integer, Integer> removeBlockCheck(int[][] ary, int x, int height, int width) {

        boolean removableYBlock; // 수평으로 블럭을 지울 수 있는지 체크
        int depthCount = 0; // 얼마나 많은 수평블럭을 없앨 수 있는지 체크
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 수평블럭을 얼마나 없앨 수 있는지와 그때의 x값을 저장한 변수

        for (int y = 0; y < height; y++) {

            if (ary[y][x] == 1) { // y축으로 진행하다, 블럭을 만나는 경우 break
                break;
            }

            removableYBlock = true;

            for (int a = 0; a < x; a++) { // x를 기준으로 왼쪽방향에 모두 블럭이 있는지 검사
                if (ary[y][a] == 0) {
                    removableYBlock = false;
                    break;
                }
            }
            for (int b = x + 1; b < width; b++) { // x를 기준으로 오른쪽방향에 모두 블럭이 있는지 검사
                if (ary[y][b] == 0) {
                    removableYBlock = false;
                    break;
                }
            }

            if (removableYBlock) { // 모두 있는 경우 depthCount++;
                depthCount++;
            }
        }

        map.put(x, depthCount);
        return map;
    }
}