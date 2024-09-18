package programmers.level2;

import java.util.*;

class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;


        int n = s.length();

        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<n; j++){
                if (stack.size() == 0){
                    stack.add(s.charAt(j));
                }else if (stack.peek() == '[' && s.charAt(j) == ']'){
                    stack.pop();
                }else if (stack.peek() == '{' && s.charAt(j) == '}'){
                    stack.pop();
                }else if (stack.peek() == '(' && s.charAt(j) == ')'){
                    stack.pop();
                }else{
                    stack.add(s.charAt(j));
                }
            }

            if (stack.isEmpty()){
                answer+=1;
            }

            char tmp = s.charAt(0);
            s = s.substring(1,s.length())+tmp;
        }

        return answer;
    }
}