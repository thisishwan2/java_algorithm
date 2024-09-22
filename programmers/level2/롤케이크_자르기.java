package programmers.level2;

import java.util.*;
class 롤케이크_자르기 {

    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        for(int i=0; i<topping.length; i++){
            m2.put(topping[i], m2.getOrDefault(topping[i],0)+1);
        }

        // 하나씩 잘라서 map에 옮긴다
        for(int i=0; i<topping.length; i++){
            int num = topping[i];
            m1.put(num, m1.getOrDefault(num,0)+1);

            if (m2.get(num)-1==0){
                m2.remove(num);
            }else{
                m2.put(num,m2.get(num)-1);
            }
            // key 길이 비교
            int m1Len = m1.keySet().size();
            int m2Len = m2.keySet().size();

            if (m1Len == m2Len){
                answer+=1;
            }
        }


        return answer;
    }
}
