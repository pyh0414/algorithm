import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 색상의 갯수
        int count = 0; // 칠해진 숫자 count
        int[] colors = new int[1000]; // 색상의 빈도수를 체크
        int num; // 입력받은 숫자

        if (n < 6) { // 모든 면을 칠해야 함.
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            num = sc.nextInt();

            if (colors[num] < 2) { // 1 1 1 의 경우 서로 마주보는 경우, 즉 한쌍의 경우만 필요
                                   // 하기 때문에 색깔의 빈도수가 2초과인 경우는 제외
                colors[num] += 1; // 색상을 한번 사용했으면 +1을 하여 사용했음을 체크
                count++; // 체크했다는 것은 색상을 한번 칠했기 때문에 ++
            } else {
                continue;
            }
        }

        if (count >= 6) { // 1 2 3 4 5 6 7 8 9의 경우 count는 6을 초과하기 때문에 6이상.
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}