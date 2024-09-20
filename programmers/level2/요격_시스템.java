package programmers.level2;

import java.util.*;
class 요격_시스템 {
    public int solution(int[][] targets) {
        int answer = 1;

        // 구간 마지막이 젤 빠른 순으로 정렬
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });

        // 마지막 구간과 겹치는 구간이 있으면 pass, 안겹치면 +1
        int end = 0;
        for(int i=0; i<targets.length; i++){
            if (i==0){
                end = targets[i][1];
            }else{
                if (targets[i][0]<end){
                    continue;
                }else{
                    answer+=1;
                    end = targets[i][1];
                }
            }
        }


        return answer;
    }
}