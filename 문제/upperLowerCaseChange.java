import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr;
        arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 32) {
                continue;
            }
            if (arr[i] >= 97 && arr[i] <= 122) {
                arr[i] = (char) (arr[i] - 32);
            } else if (arr[i] >= 65 && arr[i] <= 90) {
                arr[i] = (char) (arr[i] + 32);
            }
        }

        System.out.println(arr);

    }
}