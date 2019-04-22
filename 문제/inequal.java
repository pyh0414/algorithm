import java.util.*;

public class Main {

    static List<Integer> numList = new LinkedList<Integer>(); // 사용되는 숫자들을 저장
    static List<Integer> check = new LinkedList<Integer>(); // 사용한 숫자를 확인
    static List<Character> operatorList = new LinkedList<Character>(); // 연산자를 저장
    static boolean isFindMax = false; //
    static boolean isMinFind = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // 입력받은 연산자를 저장
            operatorList.add(sc.next().charAt(0));
        }

        search(9, n + 1, 0); // 최대값 찾기
        numList.clear();
        check.clear();
        search(0, n + 1, 1); // 최소값 찾기

    }

    static void search(int n, int count, int division) { // 모든 가능한 숫자조합을 찾음 , division=0이면 최대값, division=1이면 최소값
        if (count == 0) { // 기저조건은 숫자를 출력할 수 있는 횟수가 0일때
            if (division == 0 && !isFindMax) { // 숫자의 조합을 완성하고 아직 최대값을 찾지 않은 경우 print()함수 실행
                print(division);
            }

            if (division == 1 && !isMinFind) {
                print(division);
            }
        } else {
            if (division == 0 && !isFindMax) {
                for (int i = 9; i >= 0; i--) {
                    if (!check.contains(i)) { // 숫자의 조합에서 중복되는 숫자를 제외하기 위함
                        numList.add(i); // 사용한 숫자는 리스트에 추가
                        check.add(i); // 사용한 숫자를 표시
                        search(i, count - 1, 0); // // 숫자의 조합을 찾기 위해 다시 호출, 하나의 숫자는 찾았기 때문에 count-1
                        numList.remove(numList.size() - 1); // n번째 숫자에서 모든 숫자의 조합을 찾았으면 n번째 숫자는 제거
                        check.remove(check.size() - 1); // 마찬가지로 check에서도 제거
                    }
                }
            }

            if (division == 1 && !isMinFind) {
                for (int i = 0; i <= 9; i++) {
                    if (!check.contains(i)) {
                        numList.add(i);
                        check.add(i);
                        search(i, count - 1, 1);
                        numList.remove(numList.size() - 1);
                        check.remove(check.size() - 1);
                    }
                }
            }
        }
    }

    static void print(int division) { // 찾은 숫자의 조합과 연산자를 사용해서 조건에 하는지 확인하는 함수

        boolean maxCheck = true;
        boolean minCheck = true;

        for (int i = 0; i < operatorList.size(); i++) { // 8<9>7 에서 연산자 양옆으로 숫자들을 비교
            int start = numList.get(i); // 연산자 왼쪽 숫자
            int end = numList.get(i + 1);// 연산자 오른쪽 숫자
            char operator = operatorList.get(i); // 연산자

            if (operator == '>' && start <= end) { // 연산자가 '>'인 경우, 왼쪽이 무조건 커야하는데 왼쪽이 오른쪽보다 작거나 같으면 false
                if (division == 0) {
                    maxCheck = false;
                } else {
                    minCheck = false;
                }
                break; // 하나라도 실패한 케이스가 있으면 바로 break;
            }

            if (operator == '<' && start >= end) { // 연산자가 '<'인 경우, 오른쪽 무조건 커야하는데 오른쪽이 왼쪽보다 작거나 같으면 false
                if (division == 0) {
                    maxCheck = false;
                } else {
                    minCheck = false;
                }
                break;
            }
        }

        if (division == 0 && maxCheck) { // 위의 조건을 모두 만족하면 현재 숫자들을 출력.
            isFindMax = true;
            for (int i : numList) {
                System.out.print(i);
            }
            System.out.println();
        }

        if (division == 1 && minCheck) {
            isMinFind = true;
            for (int i : numList) {
                System.out.print(i);
            }
        }

    }
}