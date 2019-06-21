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

        // .을 만나서X수가 홀수이면 무조건 -1을 출력(예외, X인 경우는 바로 -1 )
        // s==”X”이면 바로 -1
        // X인 경우, count++( i==마지막 숫자 ? count가 홀수이면 -1 아니면 print)
        // . 인 경우 , .을 만나서 count가 홀수이면 -1 아니면 print) result+”.”

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
                if (i == s.length() - 1) {
                    if (count % 2 == 1) {
                        System.out.println(-1);
                        return;
                    }
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
