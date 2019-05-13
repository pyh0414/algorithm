import java.util.*;

public class Main {

    static ArrayList<Integer> copy = new ArrayList<Integer>();
    // static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int num;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            list.add(num);
        }

        Collections.sort(list); // 이진탐색을 하기 위해 먼저 list를 정렬함

        int result = 0; // num과 더했을 때 최소값을 가장 작게 만드는 정수

        int min = 987654321; // 두 용액을 더했을 때의 가장 작은 최소값
        int big = 0, small = 0; // 두 용액에서 큰값과 작은값
        int gap = 0; // 두 용액의 차
        int n1 = 987654321, n2 = 0; // 두 용액(n1 < n2)

        for (int j = 0; j < n; j++) { // O(n)

            num = list.get(j);
            // copy.addAll(list);
            // copy.remove(j); // O(n)

            result = search(num); // num과 더했을 때 최소값을 가장 작게 만드는 정수를 찾는다

            // copy.clear(); /// O(n)

            if (num > result) { // 두 용액에서 큰 값과 작은 값을 구함
                big = num;
                small = result;
            } else {
                big = result;
                small = num;
            }

            gap = Math.abs(num + result); // gap은 0과의 차이 이므로, 절대값으로 구해줌

            if (gap <= min) { // 두 용액의 차가 기존의 최소값보다 작으면 min값을 수정
                if (small < 0 && n1 < 0 && small > n1) { // 최소값이 같은 용액이 여러개 있을 때, 그 중 용액의 최소값이 가장 작은 정수를 선택
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

        if (num < 0) { // num과 반대되는 값을 찾음. 3인 경우 -3을 찾는다
            n = Math.abs(num);
        } else {
            n = 0 - num;
        }

        start = 0; // 찾으려는 값보다 항상 작거나, 멀리 있는 값의 인덱스
        end = list.size() - 1; // 찾으려는 값보다 항상 크거나, 가까운 값의 인덱스

        if (list.get(start) == n) { // num과 정확히 반대되는 값을 찾으면 그 값을 return
            return list.get(start);
        } else if (list.get(end) == n) {
            return list.get(end);
        }

        int mid;

        while (start + 1 < end) { // 이진 탐색으로 숫자를 찾음
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

        if (list.get(start) == num) { // -5 -4 -3 -2 -1 4 중에서 -1을 검사할때, 결국 start=4, end=5번쨰 인덱스를 가진다. 근데 4는 -1본인 자신
                                      // 이므로 이런 경우를 예외처리 해주어야 한다.
            return list.get(end);
        } else if (list.get(end) == num) {
            return list.get(start);
        }

        if (Math.abs(num + list.get(start)) < Math.abs(num + list.get(end))) { // start와 end중에서 num과 더했을 때, 더 최소가 되는 값을
                                                                               // return
            min = list.get(start);
        } else {
            min = list.get(end);
        }
        return min;
    }
}