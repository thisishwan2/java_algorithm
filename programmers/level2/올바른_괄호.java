package programmers.level2;

import java.util.*;
class 올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            if (stack.isEmpty()){
                stack.add(s.charAt(i));
            }else{
                if (stack.peek() == '(' && s.charAt(i) == ')' ){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            }
        }

        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
