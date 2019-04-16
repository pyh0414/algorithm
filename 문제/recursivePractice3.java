import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        boolean result;

        result = pan(arr, start, end);

        if (result) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean pan(char[] arr, int start, int end) {
        if (start == end) { // 문자열의 길이가 홀수인 경우
            return true;
        }

        if (start + 1 == end) { // 문자열의 길이가 짞수인 경우
            if (arr[start] == arr[end]) {
                return true;
            } else {
                return false;
            }
        }

        if (arr[start] == arr[end]) {
            return pan(arr, start + 1, end - 1);
        } else {
            return false;
        }

    }
}