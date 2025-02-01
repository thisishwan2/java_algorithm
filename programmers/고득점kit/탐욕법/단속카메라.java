package programmers.고득점kit.탐욕법;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        // for(int[] tmp: routes){
        //     System.out.println(tmp[0] + " " + tmp[1]);
        // }

        // -20 -15/ -18 -16/ -18 -13

        int start = routes[0][0];
        int end = routes[0][1];
        for(int i=1; i<routes.length; i++){

            int s = routes[i][0];
            int e = routes[i][1];

            // start~end 범위를 벗어나면 새로운 카메라가 필요함
            if (end<s){
                answer+=1;
                start = s;
                end = e;
            }else if(s<=end && e<end){
                start = s;
                end = e;
            }else if(s<=end && e>end){
                start = s;
            }
        }

        return answer;
    }
}
