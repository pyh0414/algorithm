import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        String DNA = "";
        int max;
        for (int x = 0; x < M; x++) {
            int check[] = new int[123];
            max = 0;
            for (int y = 0; y < N; y++) {
                char c = arr[y].charAt(x);
                check[c]++;
                if (check[c] > max) {
                    max = check[c];
                }
            }
            DNA += getChar(check, max);
        }
        int sum = 0;

        for (int w = 0; w < N; w++) {
            String s = arr[w];
            for (int f = 0; f < s.length(); f++) {
                if (s.charAt(f) != DNA.charAt(f)) {
                    sum++;
                }
            }
        }

        System.out.println(DNA);
        System.out.println(sum);
    }

    static String getChar(int[] arr, int max) {
        boolean isFind = false;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return String.valueOf((char) (int) list.get(0));
    }
}
