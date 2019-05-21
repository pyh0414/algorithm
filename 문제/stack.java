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

    int size = -1;
    int[] stack;

    void create(int n) {
        stack = new int[n];
    }

    void push(int n) {
        if (size + 1 >= stack.length) {
            System.out.println("Overflow");
        } else {
            size++;
            stack[size] = n;
        }
    }

    void pop() {
        if (size < 0) {
            System.out.println("Underflow");
        } else {
            stack[size] = 0;
            size--;
        }
    }

    void top() {
        if (size < 0) {
            System.out.println("NULL");
        } else {
            System.out.println(stack[size]);
        }
    }
}