package programmers.level2;

import java.util.*;
class 뒤에_있는_큰수_찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i=0; i<numbers.length; i++){
            answer[i]=-1;
        }

        Stack<int[]> s = new Stack<>();

        for(int i=0; i<numbers.length; i++){
            while (!s.isEmpty() && numbers[i]>s.peek()[0]){
                int[] tmp = s.pop();
                answer[tmp[1]] = numbers[i];
            }
            s.add(new int[]{numbers[i], i});
        }

        return answer;
    }
}
