import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = sc.nextInt();

        Stack s = new Stack();
        s.create(n);

        int c;

        for (int i = 0; i < count; i++) {
            c = sc.nextInt();

            switch (c) { // 1 : push 2 : pop 3 : top
            case 1:
                s.push(sc.nextInt());
                break;
            case 2:
                s.pop();
                break;
            case 3:
                s.top();
                break;
            }
        }
    }
}

class Stack {

    int len = 0;
    int capacity;
    int[] stack = new int[101];

    void create(int n) {
        capacity = n;
    }

    void push(int n) {
        if (len >= capacity) {
            System.out.println("Overflow");
        } else {
            stack[len++] = n;
        }
    }

    void pop() {
        if (len <= 0) {
            System.out.println("Underflow");
        } else {
            stack[len - 1] = 0;
            len--;
        }
    }

    void top() {
        if (len <= 0) {
            System.out.println("NULL");
        } else {
            System.out.println(stack[len - 1]);
        }
    }
}