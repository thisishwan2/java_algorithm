package programmers.level2;

import java.util.*;
class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};


        // bx*by - sx*sy = brown
        // sx*sy = yellow

        // bx*by = brown+yellow
        // (bx-2)*(by-2) == yellow

        int total = brown+yellow;

        // 정확히 절반 찾기
        int mid = (int)Math.floor(Math.sqrt(total));

        for (int i=2; i<=mid; i++){
            if (total%i == 0){ // 나누어 떨어지면

                // 전체 배열 크기
                int c = total/i;
                int r = i;

                // 계산이 맞는 지 확인
                if ((c-2)*(r-2) == yellow){
                    return new int[]{c,r};
                }
            }
        }
    }
}
