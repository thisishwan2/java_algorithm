package programmers.level2;

import java.util.*;
class 할인_행사 {

    static boolean check(){
        for(int val : map.values()){
            if (val>0){
                return false;
            }
        }
        return true;
    }

    static Map<String, Integer> map = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int start = 0;
        int end = 10;

        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }


        for (int i=0; i<discount.length; i++){
            if (i<9){
                if (map.get(discount[i])!=null){
                    map.put(discount[i], map.get(discount[i])-1);
                }
                continue;
            }else if (i==9){
                if (map.get(discount[i])!=null){
                    map.put(discount[i], map.get(discount[i])-1);
                }

                // map의 모든 원소가 0보다 작거나 같은지 확인(맞다면  answer+1)
                if (check()){
                    answer+=1;
                }
            }
            else{ // 10일 이후부터는 투포인터 시작
                if (map.get(discount[start])!=null){
                    map.put(discount[start], map.get(discount[start])+1);
                }
                if (map.get(discount[i])!=null){
                    map.put(discount[i], map.get(discount[i])-1);
                }

                start+=1;
                // map의 모든 원소가 0보다 작거나 같은지 확인(맞다면  answer+1)
                if (check()){
                    answer+=1;
                }
            }
        }

        return answer;
    }
}