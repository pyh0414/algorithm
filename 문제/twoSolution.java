import java.util.*;

public class Main {

    static int[] arr;
    static List<Integer> minus = new LinkedList<Integer>();
    static List<Integer> plus = new LinkedList<Integer>();
    static List<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        int num;
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(num);
            }
            arr[i] = num;
        }

        Arrays.sort(arr);
        for (int h : arr) {
            System.out.print(h + " ");
        }
        System.out.println();
        System.out.println();

        int result;
        result = search(4);
        System.out.println(4 + " " + result);

        // for(int j=0;j<n;j++){
        // num = arr[j];

        // result = search(num);
        // System.out.println(num+" "+result);
        // }
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
        end = arr.length - 1;

        if (arr[start] == n) {
            return arr[start];
        } else if (arr[end] == n) {
            return arr[end];
        } else if (n < 0 && Collections.max(minus) < n) {
            return Collections.max(minus);
        } else if (n > 0 && Collections.max(plus) < n) {
            return Collections.max(plus);
        }

        int mid;

        while (start + 1 < end) {
            mid = (start + end) / 2;

            if (arr[mid] == n) {
                return arr[mid];
            }

            if (arr[mid] > n) {
                end = mid;
            } else if (arr[mid] < n) {
                start = mid;
            }
        }
        System.out.println(start + " " + end);
        min = arr[start];
        if (min > num + arr[end]) {
            min = arr[end];
        }
        return min;
    }
}