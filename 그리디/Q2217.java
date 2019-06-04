
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ropes = new int[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes);

        int max = ropes[ropes.length - 1];
        int rope;
        int count = 1;
        List<Integer> result = new LinkedList<Integer>();
        result.add(max);

        for (int i = ropes.length - 2; i >= 0; i--) {
            rope = ropes[i];
            count++;
            max = count * ropes[i];
            result.add(max);
        }
        System.out.println(Collections.max(result));
    }
}
