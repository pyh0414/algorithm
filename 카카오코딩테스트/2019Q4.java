
// https://www.welcomekakao.com/learn/courses/30/lessons/42888?language=java
// 무지의 먹방 라이브

import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {

        List<Integer> list = new ArrayList<Integer>(); //

        for (int h = 0; h < food_times.length; h++) {
            list.add(h);
        }

        int p = 0; // list에서 사용하는 index
        int index = 0; // food_times에서 사용하는 index

        for (int i = 0; i < k; i++) {

            if (list.size() == 0) { // 더이상 먹을 음식이 없으면 return -1
                return -1;
            }
            if (p > list.size() - 1) { // 크기에 넘어가면 다시 0으로 초기화
                p = 0;
            }

            index = list.get(p); // list는 현재 음식이 남아있는 index를 저장

            food_times[index]--; // 음식을 1초동안 섭취
            if (food_times[index] == 0) { // 섭취했는데, 남은 음식이 없으면 list에서 제외
                list.remove(p);
                p--; // 21번 행에서 list.size와 동기화 해주기 위해서 --
            }
            p++; // 다음 음식을 선택
        }

        while (true) { // 장애 복구 후, 몇번부터 다시 먹으면 될 지 결정, 마지막으로 먹음 음식 번호
            index++;
            if (index > food_times.length - 1) {
                index = 0;
            }
            if (food_times[index] != 0) {
                break;
            }
        }
        return index + 1;

    }
}
