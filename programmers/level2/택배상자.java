package programmers.level2;

import java.util.*;
class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> s = new Stack<>();

        int index = 0;
        for (int i=1; i<order.length+1; i++){
            if (order[index]!=i){
                s.add(i);
            }else{
                answer+=1;
                index+=1;
                while (!s.isEmpty() && s.peek() == order[index]){
                    answer+=1;
                    index+=1;
                    s.pop();
                }
            }
        }

        return answer;
    }
}