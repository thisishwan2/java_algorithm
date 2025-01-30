package programmers.고득점kit.탐욕법;
import java.util.*;
public class 구명보트 {
    // [60, 50, 50, 40] 이 있을때
    // 60, 50, 50 40 = 3
    // 60 40, 50 50 = 2
    // 즉, 제일 무거운 사람과 제일 가벼운 사람을 비교하면서 구명보트 개수를 구한다.

    public int solution(int[] people, int limit) {
        int answer = 0;

        // int 타입은 아래와 같이 역정렬이 불가함 -> Integer로 변한필요
        // Arrays.sort(people, Collections.reversOrder());
        Integer[] peopleArr = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peopleArr, Collections.reverseOrder());

        // System.out.println(peopleArr[0]);

        int lastIdx = peopleArr.length-1;

        for(int i=0; i<peopleArr.length; i++){

            if(i>lastIdx){
                break;
            }else if(i==lastIdx){
                answer+=1;
                break;
            }

            if(peopleArr[i]+peopleArr[lastIdx]<=limit){
                lastIdx-=1;
                answer+=1;
            }else{
                answer+=1;
            }
        }
        return answer;
        // 80,70,50,50
    }
}
