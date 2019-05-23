import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int start, end, mid;
        // start : m보다 무조건 작은값
        // end : m보다 무조건 큰 값

        start = 0;
        end = n - 1;

        if (arr[start] > m && arr[end] < m) {
            System.out.println(-1);
            return;
        } else if (arr[start] == m) {
            System.out.println(start + " 번째에 있습니다.");
            return;
        } else if (arr[end] == m) {
            System.out.println(end + " 번째에 있습니다.");
            return;
        }

        while (start + 1 < end) {
            mid = (start + end) / 2;

            if (arr[mid] == m) {
                System.out.println(mid + " 번쨰에 있습니다.");
                return;
            }

            if (arr[mid] > m) {
                end = mid;
            } else if (arr[mid] < m) {
                start = mid;
            }
        }
        System.out.println("찾으려는 숫자가 없습니다.");
    }
}