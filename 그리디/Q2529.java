import java.util.*;

public class Main {
    static String[] operators;
    static Stack<Integer> stack = new Stack<Integer>();
    static boolean[] check = new boolean[11];
    static boolean isMaxFind = false;
    static boolean isMinFind = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        operators = sc.nextLine().split(" ");

        recursive(1, 0); // max
        stack.clear();
        recursive(2, 0); // min
    }

    static public void recursive(int c, int count) {

        // c : 1 -> max를 찾는 경우
        // c : 2 -> min을 찾는 경우
        if (c == 1) {
            if (!isMaxFind && count >= operators.length + 1) {
                check(c);
                return;
            }
        } else {
            if (!isMinFind && count >= operators.length + 1) {
                check(c);

                return;
            }
        }

        if (c == 1) {
            for (int i = 9; i >= (9 - operators.length); i--) {
                if (!isMaxFind && !check[i]) {
                    stack.push(i);
                    check[i] = true;
                    recursive(c, count + 1);
                    check[i] = false;
                    stack.pop();
                }
            }
        } else {
            for (int i = 0; i <= (0 + operators.length); i++) {
                if (!isMinFind && !check[i]) {
                    stack.push(i);
                    check[i] = true;
                    recursive(c, count + 1);
                    check[i] = false;
                    stack.pop();
                }
            }
        }
    }

    static void check(int c) {
        int left, right;
        String operator;
        String s = "";

        boolean isSuccess = true;

        for (int i = 0; i < operators.length; i++) {

            operator = operators[i];
            left = Integer.parseInt(s.charAt(i) + "");
            right = Integer.parseInt(s.charAt(i + 1) + "");

            if ((operator.equals(">")) && (left < right)) {
                isSuccess = false;
                break;
            } else if ((operator.equals("<")) && (left > right)) {
                isSuccess = false;
                break;
            }
        }

        if (isSuccess) {
            if (c == 1) {
                isMaxFind = true;
            } else {
                isMinFind = true;
            }
            System.out.println(s);

        }
    }
}
