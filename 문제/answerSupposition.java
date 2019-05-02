import java.util.Scanner;

public class Main {

    static boolean oneShot = false; // 두 비교 숫자의 나머지가 0인 경우, 둘 다 값이 같은 경우

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long start = 0; // 조건을 만족하지 않는 경우
        long end = 10000000000L; // 조건을 무조건 만족하는 경우, 입력된 값의 범위는 최대 1,000,000,000,000,000,000인데
                                 // end 조건을 만족하는 최대의 값이

        if (n == 0) {
            System.out.println(0);
            return;
        }
        while (start + 1 < end && !oneShot) { // start+1이 endd와 같을때, 또는 한번에 값을 찾았을 때 종료
            long mid = (start + end) / 2;
            if (check(mid, n)) { // mid번쨰 값이 조건을 만족하는지 검사
                end = mid; // mid에서 조건을 만족하니 end에 대입(end는 무조건 조건을 만족하는 경우임)
            } else {
                start = mid; // 반대로 mid에서는 조건을 만족하지 않으니 start에 대입(start는 무조건 조건을 만족하지 않는 경우)
            }
        }
        if (oneShot) {
            System.out.println(end);
        } else {
            System.out.println(end - 1); // 예를 들어서 103을 만족하는 값은 9~10에 있는 9.xxx값.103은 한번에 조건을 만족하는 값이 없으므로 소수점으 포함하는 값임.
                                         // 위의 조건상 10일때(110) 103보다 크다는 조건을 만족하므로 103을 만족하는 값은 10보다 하나 작은 9가 된다.

        }
    }

    static boolean check(long num, long n) {
        long result = num * num + num; // 조건은 x^2+x+x값을 만족하는 x의 정수부분
        if (result == n) { // 두 값이 같다면 oneShot을 true로 하고 return, 위의 while문을 바로 빠져나온다.
            oneShot = true;
            return true;
        } else if (result > n) {
            return true;
        } else {
            return false;
        }

    }
}