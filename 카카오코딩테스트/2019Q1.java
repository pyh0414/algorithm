
// https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=java
// 오픈채팅방

import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        String[] answer = {};
        Map<String, String> map = new HashMap<String, String>();
        int i;

        String status = "", userId = "", nick = "";
        int size = 0;

        for (i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            if (arr.length == 3) {
                status = arr[0];
                userId = arr[1];
                nick = arr[2];
            } else {
                status = arr[0];
                userId = arr[1];
            }

            if (status.equals("Enter") || status.equals("Leave")) {
                size++;
            }
            if (status.equals("Enter") || status.equals("Change")) {
                map.put(userId, nick);
            }

        }

        answer = new String[size];

        int index = 0;

        for (i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            status = arr[0];
            userId = arr[1];

            String text;
            if (status.equals("Enter")) {
                text = map.get(userId) + "님이 들어왔습니다.";
                answer[index++] = text;
            } else if (status.equals("Leave")) {
                text = map.get(userId) + "님이 나갔습니다.";
                answer[index++] = text;
            }
        }
        return answer;
    }
}