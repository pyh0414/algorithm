import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str;
        int[] check = new int[26];

        int max = 0;
        int index;

        while (sc.hasNextLine()) {
            str = sc.nextLine();
            String[] arr = str.split(" ");

            for (int j = 0; j < arr.length; j++) {
                String s = arr[j];
                for (int i = 0; i < s.length(); i++) {
                    index = s.charAt(i) - 'a';
                    check[index]++;
                    if (check[index] > max) {
                        max = check[index];
                    }
                }
            }
        }

        for (int k = 0; k < 26; k++) {
            if (check[k] == max) {
                System.out.print((char) ('a' + k));
            }
        }

    }
}