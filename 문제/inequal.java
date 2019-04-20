import java.util.*;

public class Main {

    static boolean isFindMax = false;
    static boolean isFindMin = false;
    static char[] arr;
    static List<Integer> list = new LinkedList<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new char[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }

        // 0 : max , 1 : min
        search(9, n + 1, 0);
        list.clear();
        // search(0,n+1,1);
    }

    static void search(int start, int count, int division) {
        if (count == 0) {
            if (division == 0 && !isFindMax) { // 최대값
                check(division);
            } else {

            }
        } else {
            if (division == 0 && !isFindMax) { // 최소값
                for (int i = start; i >= 0; i--) {
                    // if(list.contains(i)){
                    // continue;
                    // }
                    list.add(i);
                    search(start, count - 1, 0);
                    list.remove(list.size() - 1);
                }
            } else { // 최소값

            }
        }
    }

    static void check(int diff) {
        if (diff == 0) {
            String s = "";
            int arrIndex = 0;
            int listIndex = 0;
            int length = list.size() + arr.length;

            for (int i = 0; i < length; i++) {
                if (i % 2 == 0) {
                    s += list.get(listIndex) + "";
                    listIndex++;
                } else {
                    s += arr[arrIndex] + "";
                    arrIndex++;
                }
            }

            for (int i = 1; i < s.length(); i += 2) {
                int start = list.get(i - 1);
                int end = list.get(i + 1);
                char c = s.charAt(i);

                if (c == '>' && start > end) {
                    return;
                }
                if (c == '<' && start < end) {
                    return;
                }
            }
            for (int i : list) {
                System.out.print(i);
            }
        }
    }
}