import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<String, Integer> map = new HashMap<String, Integer>();

        int i;
        int count = 0; // 듣보잡 숫자

        for (i = 0; i < N; i++) {
            map.put(sc.next(), 1);
        }

        String s;
        ArrayList<String> list = new ArrayList<String>();

        for (i = 0; i < M; i++) {
            s = sc.next();
            if (map.get(s) != null) {
                list.add(s);
                count++;
            } else {
                map.put(s, 1);
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (String str : list) {
            System.out.println(str);
        }
    }

}