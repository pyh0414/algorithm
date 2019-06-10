import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr1 = s.split("-");
        String[] arr2;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < arr1.length; i++) {
            String q = arr1[i];
            sum = 0;
            arr2 = q.split("\\+");
            for (int h = 0; h < arr2.length; h++) {
                sum += Integer.parseInt((arr2[h]));
            }

            if (i == 0) {
                sum *= -1;
            }

            result -= sum;
        }
        System.out.println(result);
    }
}
