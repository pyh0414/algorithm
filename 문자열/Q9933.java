import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<String, Integer>();
        String str;

        for (int i = 0; i < N; i++) {

            str = sc.next();

            if (str.equals(generateReverseString(str)) || map.get(str) != null) { // str이 팰린드롭이거나, 반전되는 값이 이미 map에 있으면
                System.out.print(str.length() + " ");
                System.out.println(str.charAt(str.length() / 2));
                break;
            }

            map.put(generateReverseString(str), 1);
        }
    }

    static String generateReverseString(String str) {

        char[] arr = str.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        char c;

        while (start < end) {
            c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
        return new String(arr);
    }
}