package programmers.level2;

import java.util.*;
class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int first = 0;
        int end = people.length-1;

        // 50,50,70,80
        while (first<=end){
            if (people[first]+people[end] <= limit){
                first+=1;
            }

            end-=1;
            answer+=1;
        }


        return answer;
    }
}
