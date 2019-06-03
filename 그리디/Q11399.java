
import java.util.*;

public class Q11399 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int result = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int num;
        for (int j = 0; j < n; j++) {
            sum += arr[j];
            result += sum;
        }
        System.out.println(result);
    }

}
