import java.util.*;

public class Main {

    static int arr[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 1; // start에서는 성공
        int end = n; // end에서는 실패

        if (check(end, 1)) {
            System.out.println(end);
            return;
        }

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (check(mid, 2)) { // mid 길이에서 중복없이 가능 한지
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }

    static boolean check(int n, int c) { // n거리에서 중복없이 가능한가?

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int num;
        int count = 0;
        int successCount = arr.length - n + 1; // 되는 경우의 수, 처음에는 모두 된다는 전제

        for (int i = 0; i < n; i++) {
            num = arr[i];
            if (map.get(num) == null) {
                map.put(num, 1);
            } else { // 숫자가 두개 이상인 경우
                map.put(num, map.get(num) + 1);
                successCount--;
                count++;
            }
        }
        if (c == 1) {
            if (count == 0) {
                return true;
            } else {
                return false;
            }
        }

        int oldElement, newElement;
        int index = 0;

        for (int i = n; i < arr.length; i++) {

            oldElement = arr[index++];
            map.put(oldElement, map.get(oldElement) - 1);

            newElement = arr[i];
            if (map.get(newElement) == null || map.get(newElement) <= 0) { // 추가된 값이 기존에 없는 경우
                map.put(newElement, 1);
            } else { // 숫자가 두개 이상인 경우
                map.put(newElement, map.get(newElement) + 1); // map.get() : O(1)
            }

            if (Collections.max(map.values()) >= 2) { // 이 부분에서 시간 초과 남.values()가 O(n)
                successCount--;
            }
        }

        if (successCount > 0) {
            return true;
        } else {
            return false;
        }
    }
}