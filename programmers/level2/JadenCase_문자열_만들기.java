package programmers.level2;

import java.util.*;
class JadenCase_문자열_만들기 {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" "); // StringTokenizer 대시 split을 써야 공백 문자를 기준으로 나눌 수 있다.
        int n = arr.length;

        for (int i=0; i<n; i++){
            // 공백이면
            if(arr[i].length() == 0){
                answer+=" ";
            }
            else{
                answer+=arr[i].substring(0,1).toUpperCase(); // 숫자는 알아서 upper 하지 않음
                answer+=arr[i].substring(1,arr[i].length()).toLowerCase();
                answer+=" ";
            }
        }

        // 마지막이 공백이면 그대로 출력하고, 아니면 마지막 공백을 지운다.
        if (s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }else{
            return answer.substring(0,answer.length()-1);
        }
    }
}
