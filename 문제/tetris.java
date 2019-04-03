import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int width = sc.nextInt(); // 테트리스 가로
        int height = sc.nextInt(); // 테트리스 세로
        int[][] ary = new int[height][width]; // 현재 테트리스를 저장하는 배열

        boolean depthChecek; // 막대기를 넣었을 때 맵을 벗어나는지 검사
        List<Integer> depthCheckFailList = new LinkedList<Integer>(); //
        List<Map> mapList = new LinkedList<Map>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxDepth = 0;
        int maxDepthXPosition = 0;

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                ary[h][w] = sc.nextInt();
            }
        }

        for (int x = 0; x < width; x++) { // 모든 n번째 x위치를 검사
            depthChecek = true;
            for (int y = 0; y < 4; y++) { // 일단 막대기가 맵을 벗어나는지 검사
                if (ary[y][x] == 1) {
                    depthChecek = false;
                    depthCheckFailList.add(x);
                    break;
                }
            }
            if (depthChecek) {
                map = removeXblock(ary, x, height, width);
                mapList.add(map);
            } else {
                continue;
            }
        }

        if (depthCheckFailList.size() == width) { // 모든x에 대하여 막대기가 맵을 벗어나면 0출력
            System.out.println(0 + " " + 0);
            return;
        }

        for (Map m : mapList) {

            Iterator<Integer> keys = m.keySet().iterator();

            while (keys.hasNext()) {
                int key = keys.next();
                int value = (int) m.get(key);

                if (value > maxDepth) {
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

    static Map<Integer, Integer> removeXblock(int[][] ary, int x, int height, int width) {

        boolean xBlockCheck;
        int depthCount = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int y = 0; y < height; y++) {

            if (ary[y][x] == 1) {
                break;
            }

            xBlockCheck = true;

            for (int a = 0; a < x; a++) {
                if (ary[y][a] == 0) {
                    xBlockCheck = false;
                    break;
                }
            }
            for (int b = x + 1; b < width; b++) {
                if (ary[y][b] == 0) {
                    xBlockCheck = false;
                    break;
                }
            }

            if (xBlockCheck) {
                depthCount++;
            }
        }

        map.put(x, depthCount);
        return map;
    }
}