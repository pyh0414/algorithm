import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        char[] arr = s.toCharArray();
        int right = 0;
        int left = 0;

        Stack stack = new Stack();
        stack.create(arr.length);

        char c;
        for (int i = 0; i < arr.length; i++) {

            c = arr[i];

            if (stack.size() < 0) { // 스택에 아무것도 없을 때
                stack.push(c);
            } else { // 스택이 비어있지 않을 때
                if (c == '(') { // 추가되는 요소가 '(' 경우
                    stack.push(c);
                } else { // 추가되는 요소가 ')' 경우
                    if (stack.top() == '(') {
                        stack.pop();
                    }
                }

            }
        }

        if (stack.size() == -1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Stack {

    int size = -1;
    char[] stack;

    void create(int n) {
        stack = new char[n];
    }

    void push(char n) {
        size++;
        stack[size] = n;
    }

    int size() {
        return size;
    }

    void pop() {
        stack[size] = 0;
        size--;
    }

    char top() {
        return stack[size];
    }
}