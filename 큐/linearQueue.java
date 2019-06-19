import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue que = new Queue(10);
        que.enQueue('A');
        que.enQueue('B');
        que.enQueue('C');
        que.delete();
        que.print();
    }
}

class Queue {
    int front = -1; // 저장된 원소중에 첫번쨰 원소
    int rear = -1; // 저장된 원소중에 마지막 원소
    int size;
    char items[];

    Queue(int size) {
        this.size = size;
        items = new char[this.size];
    }

    boolean isEmpty() {
        return front == rear;
    }

    boolean isFull() {
        return rear == this.size - 1;
    }

    void enQueue(char item) {
        if (isFull()) {
            System.out.println("큐가 모두 차있습니다");
        } else {
            items[++rear] = item;
        }
    }

    char deQueue() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다");
            return 0;
        } else {
            return items[++front];
        }
    }

    void delete() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다");
        } else {
            ++front;
        }
    }

    char peek() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다");
            return 0;
        } else {
            return items[front + 1];
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("큐가 비어있습니다");
        } else {
            for (int i = front + 1; i <= rear; i++) {
                System.out.print(items[i]);
            }
            System.out.println();
        }
    }
}
