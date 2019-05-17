import java.util.*;

public class Main {

    static int arr[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int start = 1; // start에서는 성공
        int end = n + 1; // end에서는 실패

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (check(mid)) { // mid 길이에서 중복없이 가능 한지
                start = mid;
            } else {
                end = mid;
            }
        }
        System.out.println(start);
    }

    static boolean check(int n) { // n거리에서 중복없이 가능한가?

        boolean isFindDuplication = false; // 첫번째 n구간에서 중복을 찾았는지 여부

        int num;
        int successCount = arr.length - n + 1; // n구간에서 중복이 없는 최대값,
                                               // 일단 모두 중복이 없다고 가정

        List<Integer> list = new LinkedList<Integer>();
        int[] check = new int[100001];

        int duplicationCount = 0; // 구간 내에서 중복된 숫잦의 갯수

        for (int i = 0; i < n; i++) {
            num = arr[i];
            check[num]++;

            if (check[num] > 1) { // 중복되는 값들을 체크해서 list에 넣어줌
                if (!list.contains(num)) {
                    duplicationCount++; // 처음 구간 n에서 중복된 숫자가 얼마나 있는지
                    list.add(num);
                }

                if (!isFindDuplication) { // 중복된 수가 있고, 아직 찾지 않았다면 successCount--;
                    successCount--;
                }
                isFindDuplication = true; // 중복되는 숫자를 한번 찾았기 때문에 true로 바꿔줌
            }
        }

        if (!isFindDuplication) { // 처음 n구간에서 중복을 찾지 못했다면 n구간에서는 true
            return true;
        }

        int index = 0;
        int removeElement = 0, newElement = 0; // 구간을 한칸씩 전진하면서 제거/추가 되는 값

        for (int i = n; i < arr.length; i++) {

            removeElement = arr[index++];
            check[removeElement]--;
            if (check[removeElement] == 1) {

                duplicationCount--;
                // 위에서 removeElement에서의 값을 --했는데, 그 값이 1이라면
                // 이 값은 원래 2였다. 이는 곧 중복된 숫자를 의미한다.
                // 그리고 중복된 숫자가 없어 졌기 때문에 duplicationCount--;

            }

            newElement = arr[i];
            check[newElement]++;

            if (check[newElement] == 2) {
                duplicationCount++;
            }
            // 새로 추가된 값의 중복값이 2라는 말은, 구간내에서 중복된 값이 추가되었다는 의미이기
            // 때문에 duplicationCount++

            if (duplicationCount > 0) { // 구간 내에서 중복된 숫자가 있으면, successCount--;
                successCount--;
            }
        }

        if (successCount > 0) { // 만약 하나라도 중복되지 않는 경우가 있다면 return true;
            return true;
        } else {
            return false;
        }
    }
}