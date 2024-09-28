package programmers.level3;

import java.util.*;
class 야근_지수 {

    // 공평하게 work를 남기는게 좋음
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[0]-a[0];
            }
        });

        for(int i=0; i<works.length; i++){
            pq.add(new int[]{works[i], i});
        }

        for(int i=0; i<n; i++){
            int[] tmp = pq.poll();
            if (works[tmp[1]]>0){
                works[tmp[1]]-=1;
                pq.add(new int[]{tmp[0]-1, tmp[1]});
            }else{
                break; // 어차피 젤 큰놈을 뽑을테니까 젤 큰놈이 0이면 끝내도됨
            }
        }


        for(int i=0; i<works.length; i++){
            answer += works[i]*works[i];
        }
        return answer;
    }
}