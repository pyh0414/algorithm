import java.util.*;

public class Main {

    static String result = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.equals("X")) {
            System.out.println(-1);
            return;
        }

        char c;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == 'X') {
                count++;
                if (i == s.length() - 1) {
                    if (count % 2 == 1) {
                        System.out.println(-1);
                        return;
                    } else {
                        print(count);
                    }
                }
            } else if (c == '.') {
                if (count % 2 == 1) {
                    System.out.println(-1);
                    return;
                } else {
                    print(count);
                    result += ".";
                    count = 0;
                }
            }
        }
        System.out.println(result);
    }

    static void print(int size) {
        while (size > 0) {
            if (size >= 4) {
                result += "AAAA";
                size -= 4;
            } else {
                result += "BB";
                size -= 2;
            }
        }
    }
}
