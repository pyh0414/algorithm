import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int Alength = A.length();

        int gap = B.length() - A.length();

        int count = 0;
        int maxSame = 0;

        if (A.length() == B.length()) {
            for (int h = 0; h < A.length(); h++) {
                if (A.charAt(h) == B.charAt(h)) {
                    count++;
                }
            }
            System.out.println(Alength - count);
            return;
        }

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                count++;
            }
        }

        if (count > maxSame) {
            maxSame = count;
        }
        count = 0;

        while (gap - 1 >= 0) {

            count = 0;
            A = "A" + A;

            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == B.charAt(i)) {
                    count++;
                }
            }

            if (count > maxSame) {
                maxSame = count;
            }
            gap--;
        }

        System.out.println(Alength - maxSame);

    }
}