import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] users = new int[N + 1];

        for (int s : stages) {
            users[s - 1]++;
        }

        List<Info> list = new ArrayList<Info>();
        int total = stages.length;

        for (int i = 0; i < N; i++) {
            if (users[i] == 0) {
                list.add(new Info(i + 1, 0));
            } else {
                list.add(new Info(i + 1, (double) users[i] / total));
                total -= users[i];
            }
        }

        Collections.sort(list, new Comparator<Info>() {
            public int compare(Info a, Info b) {
                if (a.rate < b.rate) {
                    return 1;
                } else if (a.rate > b.rate) {
                    return -1;
                } else {
                    if (a.stage > b.stage) {
                        return 1;
                    } else if (a.stage < b.stage) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });

        for (int j = 0; j < N; j++) {
            answer[j] = list.get(j).stage;
        }
        return answer;
    }
}

class Info {
    int stage;
    double rate;

    Info(int stage, double rate) {
        this.stage = stage;
        this.rate = rate;
    }
}