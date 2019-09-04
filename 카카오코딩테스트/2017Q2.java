
// https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
// 다트게임

import java.util.*;
import java.lang.Math;

class Solution {
    public int solution(String dartResult) {

        int[] score = new int[3];
        int[] indexs = new int[3];
        int index = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) == 83 || dartResult.charAt(i) == 68 || dartResult.charAt(i) == 84) {
                indexs[index++] = i;
            }
        }

        for (int i = 0; i < 3; i++) {

            index = indexs[i];
            int num = Integer.parseInt(String.valueOf(dartResult.charAt(index - 1)));

            if (dartResult.charAt(index - 1) == '0' && index - 2 >= 0 && dartResult.charAt(index - 2) == '1') {
                num = 10;
            }

            if (i == 0) {
                if (dartResult.charAt(index) == 'D') {
                    num = (int) Math.pow(num, 2);
                } else if (dartResult.charAt(index) == 'T') {
                    num = (int) Math.pow(num, 3);
                }

                if (dartResult.charAt(index + 1) == '*') {
                    num *= 2;
                } else if (dartResult.charAt(index + 1) == '#') {
                    num *= -1;
                }

            } else {
                if (dartResult.charAt(index) == 'D') {
                    num = (int) Math.pow(num, 2);
                } else if (dartResult.charAt(index) == 'T') {
                    num = (int) Math.pow(num, 3);
                }

                if (index + 1 < dartResult.length()) {
                    if (dartResult.charAt(index + 1) == '*') {
                        if (dartResult.charAt(indexs[i - 1]) == '*') {
                            score[i - 1] *= 2;
                        } else if (dartResult.charAt(indexs[i - 1]) == '#') {
                            score[i - 1] *= 2;
                        }
                        score[i - 1] *= 2;
                        num *= 2;

                    } else if (dartResult.charAt(index + 1) == '#') {
                        num *= -1;
                    }
                }

            }
            score[i] = num;
        }
        int result = 0;
        for (int n : score) {
            result += n;
        }
        return result;
    }
}