package programmers.level2;

import java.util.*;
class 최댓값과_최솟값 {
    public String solution(String s) {
        String answer = "";

        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> arr = new ArrayList<>();
        while (st.hasMoreTokens()){
            arr.add(Integer.parseInt(st.nextToken()));
        }

        answer=answer+Collections.min(arr)+" "+Collections.max(arr);


        return answer;
    }
}