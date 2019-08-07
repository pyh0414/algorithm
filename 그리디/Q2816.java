import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] arr = new String[N];

        int i;
        String s;
        int kbs1Index = 0, kbs2Index = 0;
        int currentIndex = 0;

        for (i = 0; i < N; i++) {
            s = sc.next();
            arr[i] = s.toUpperCase();
            if (s.equals("KBS1")) {
                kbs1Index = i;
            } else if (s.equals(("KBS2"))) {
                kbs2Index = i;
            }
        }

        int ordered = kbs1Index < kbs2Index ? 0 : 1;

        for (i = currentIndex; i < kbs1Index; i++) {
            System.out.print(1);
        }

        for (i = currentIndex; i < kbs1Index; i++) {
            System.out.print(4);
        }

        for (i = currentIndex; i < kbs2Index + ordered; i++) {
            System.out.print(1);
        }

        for (i = currentIndex; i < kbs2Index + ordered - 1; i++) {
            System.out.print(4);
        }

    }

}