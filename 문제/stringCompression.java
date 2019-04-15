import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        String[] ary;
        int gap = 0;

        StringBuffer buffer = new StringBuffer(s);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) { // 현재값과 이전값이 다르면 새로운 문자 -> "/"를 입력해 구분해줌
                buffer.insert(i + gap, '/');
                gap++; // 알파벳을 구분할 때마다 "/"을 추가해주는데, 이때문자열의 크기가 +1씩 증가하고 gap도 같이 ++해준다. 이유는 insert "/"가
                       // 입력되는 위치를 정확하게 잡아주기 위함
            }
        }

        ary = buffer.toString().split("/"); // buffer문자열은 "/"을 기준으로 같은 문자끼리 뭉침. "/"을 기준으로 구분하여 배열을 반환

        int charCount;
        char c;

        for (int z = 0; z < ary.length; z++) {
            charCount = ary[z].length();
            c = ary[z].charAt(0);

            if (charCount == 1) { // 1인 경우는 문자만 출력
                System.out.print(c);
            } else {
                System.out.print(charCount + "" + c);
            }
        }

    }
}