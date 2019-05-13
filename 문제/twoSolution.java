import java.util.*;

public class Main {

    // static ArrayList<Integer> copy = new ArrayList<Integer>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static ArrayList<Integer> plus = new ArrayList<Integer>();
    static ArrayList<Integer> minus = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int num;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if (num < 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
            list.add(num);
        }

        Collections.sort(list);
        Collections.sort(plus);
        Collections.sort(minus);

        int result = 0;

        int min = 987654321;
        int big = 0, small = 0, gap = 0;
        int n1 = 987654321, n2 = 0;

        for (int j = 0; j < n; j++) { // O(n)

            num = list.get(j);
            // copy.addAll(list);
            // copy.remove(j); // O(n)

            result = search(num);

            // copy.clear(); /// O(n)

            if (num > result) {
                big = num;
                small = result;
            } else {
                big = result;
                small = num;
            }

            gap = Math.abs(num + result);

            if (gap <= min) {
                if (small < 0 && n1 < 0 && small > n1) {
                    n1 = small;
                    n2 = big;
                    min = gap;
                    continue;
                }
                if (small < n1) {
                    n1 = small;
                    n2 = big;
                    min = gap;
                }
            }
        }
        System.out.println(n1 + " " + n2);
    }

    static int search(int num) { // num과 더해서 0이되거나, 0에 가장 가까운 값을 구하는 함수

        int n;
        int start, end;
        int min;

        if (num < 0) {
            n = Math.abs(num);
        } else {
            n = 0 - num;
        }

        start = 0;
        end = list.size() - 1;

        if (minus.size() == 0) { // 숫자가 양수만 있는 경우
            if (num == list.get(start)) {
                return list.get(start + 1);
            } else if (num == list.get(end)) {
                return list.get(start);
            } else {
                return list.get(start);
            }
        } else if (plus.size() == 0) { // 숫자가 음수만 있는 경우
            if (num == list.get(start)) {
                return list.get(end);
            } else if (num == list.get(end)) {
                return list.get(start);
            } else {
                return list.get(end);
            }
        }
        if (list.get(start) == n) { // num과 정확히 반대되는 값을 찾으면 그 값을 return
            return list.get(start);
        } else if (list.get(end) == n) {
            return list.get(end);
        }

        if (num < 0) {

            if (list.get(end) < n) {
                return list.get(end);
            }
        } else {
            if (list.get(start) > n) {
                return list.get(start);
            }
        }

        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;

            if (list.get(mid) == n) {
                return list.get(mid);
            }

            if (list.get(mid) > n) {
                end = mid;
            } else if (list.get(mid) < n) {
                start = mid;
            }
        }
        if (list.get(start) == num) {
            return list.get(end);
        } else if (list.get(end) == num) {
            return list.get(start);
        }
        if (Math.abs(num + list.get(start)) < Math.abs(num + list.get(end))) {
            min = list.get(start);
        } else {
            min = list.get(end);
        }
        return min;
    }
}