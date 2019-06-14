import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt(); // y
        int x = sc.nextInt(); // x

        int count = 0;
        int moveX;

        if (y == 1) {
            count = 1;
        } else if (y == 2) {
            moveX = (x + 1) / 2;
            count = moveX > 4 ? 4 : moveX;
        } else if (y >= 3) {
            if (x <= 6) {
                count = x > 4 ? 4 : x;
            } else {
                count = x - 2;
            }
        }

        System.out.println(count);
    }
}