import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int j = 0; j < t; j++) {
            int loop = sc.nextInt();
            int[] candidates = new int[loop + 1];
            for (int i = 0; i < loop; i++) {
                candidates[sc.nextInt()] = sc.nextInt();
            }

            int count = 1;
            int interviewRank = candidates[1];

            for (int k = 2; k <= loop; k++) {
                if (interviewRank >= candidates[k]) {
                    interviewRank = candidates[k];
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
