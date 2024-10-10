package programmers.level3;

import java.util.*;
class 기지국_설치 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 전체 전파 범위는 W*2+1 임

        // 따라서 주어진 stations를 기준으로 전파가 닿지 않는 구간의 길이를 구하면된다.

        int length = 2*w+1;

        List<Integer> tmp = new ArrayList<>();

        int left = 1; // 전파가 안닿는 시작점
        for(int i=0; i<stations.length; i++){

            int mid = stations[i];
            int start = mid-w; // 기지국 왼쪽 전파 닿는 위치

            if(left<start){
                int gap = start-left;
                if (gap%length==0){
                    answer+=(gap/length);
                }else{
                    answer+=(gap/length + 1);
                }
            }

            left = mid+w+1;
        }

        // 남은 뒷부분이 있다면,
        if (left<=n){

            int gap = n-left+1;
            if (gap%length==0){
                answer+=(gap/length);
            }else{
                answer+=(gap/length + 1);
            }
        }

        return answer;
    }
}