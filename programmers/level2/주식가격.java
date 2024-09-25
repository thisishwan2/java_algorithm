package programmers.level2;

import java.util.*;
class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int n = prices.length;
        Stack<int[]> s = new Stack<>();

        for(int i=0; i<n-1; i++){
            if(s.isEmpty()){
                s.add(new int[]{prices[i],i});
                answer[i] = n-i-1;
                continue;
            }

            while (!s.isEmpty() && s.peek()[0]>prices[i]){
                int[]tmp = s.pop();
                answer[tmp[1]] = i-tmp[1];
            }

            s.add(new int[]{prices[i],i});
            answer[i] = n-i-1;

        }

        return answer;
    }
}