import java.util.*;

public class Main {

    static int count = 0; // 출력할 수 있는 경우의 수
    static int num; // 입력받을 정수
    static String result = ""; // 결과를 표시할 문자열
    static Stack<Integer> stack = new Stack<>(); // num을 출력할 수 있는 조합

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        divisionSum(num - 1, 0);
        System.out.println(count);

    }

    static void divisionSum(int n, int sum) {
        if (sum == num) { // 재귀함수의 기저조건. 더하는 경우의 수를 조합한 값이 num과 같으면 스택의 값을 출력한다.
            count++;
            for (int i : stack) {
                result += ("+" + i);
            }
            System.out.print(result.substring(1, result.length()));
            System.out.println();
            result = "";
        } else {
            for (int j = n; j >= 1; j--) {
                if (sum + j <= num) { // 기존의 sum값에 j를 더했는데 만약 num보다 커지는 j의 경우는 제외함.
                    sum += j; // sum에 j를 더 한 값이 num보다 작은 경우라면 sum에 j값을 더함.
                    stack.push(j); // j를 사용했다가 스택에 넣어줌
                    divisionSum(j, sum); // 다음에 어떤 값을 sum에 더할 수 있는지 결정. 5의 경우 2가 두번들어갈 수 있기 때문에 j값 그대로 넘겨줌.
                    sum -= j; // j번째를 모두 검사 했기 때문에 sum에서 빼준다
                    stack.pop(); // 마찬가지로 j를 사용했기 때문에 스택의 마지막 부분을 빼줌
                }
            }
        }
    }
}