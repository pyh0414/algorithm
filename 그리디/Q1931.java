
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<conference> list = new ArrayList<conference>();

        for (int i = 0; i < n; i++) {
            list.add(new conference(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list, new Comparator<conference>() {
            public int compare(conference c1, conference c2) {
                if (c1.getEnd() > c2.getEnd()) {
                    return 1;
                } else if (c1.getEnd() < c2.getEnd()) {
                    return -1;
                }
                return c1.getStart() - c1.getEnd();

            }
        });

        int end = -1;
        int start;
        int count = 0;

        for (int j = 0; j < n; j++) {
            start = list.get(j).getStart();

            if (start >= end) {
                end = list.get(j).getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}

class conference {
    int start;
    int end;

    conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}
