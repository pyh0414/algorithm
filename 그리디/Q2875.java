import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, k;

        n = sc.nextInt(); // 여학생 수
        m = sc.nextInt(); // 남학생 수
        k = sc.nextInt(); // 인턴팀에 참여하는 학생

        int teamCount = 0;
        int internTeam = 0;

        int man = m;
        int girl = n;

        while (girl >= 2 && man >= 1) { // 처음에 학생들로 만들 수 있는 최대의 팀을 계산

            man -= 1;
            girl -= 2;
            teamCount++;
        }

        if (man >= k || girl >= k || (man + girl) >= k) { // 남아있는 학생들이 인턴에 참여하는 학생보다 많은가 ?
            System.out.println(teamCount);
            return;

        }
        teamCount--; // 부족하면 기존의 팀에서 학생들을 뺌
        man += 1;
        girl += 2;

        while (man + girl < k) { // 기존의 팀에서 뺀 학생들의 합이 인턴에 참여하는 학생을 만족할때까지 반복
            teamCount--;
            man += 1;
            girl += 2;
        }

        System.out.println(teamCount);
    }
}
