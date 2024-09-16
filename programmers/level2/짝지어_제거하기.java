package programmers.level2;

import java.util.*;
class 짝지어_제거하기
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stack = new Stack<>();
        int index = 0;
        int len = s.length();
        while(true){
            if (index == len){
                break;
            }

            char input = s.charAt(index);

            if (!stack.isEmpty() && stack.peek() == input){
                // 상위 2개를 확인하고 같으면 제거하는 while 문
                while (!stack.isEmpty() && stack.peek() == input){
                    stack.pop();
                }
            }else{
                stack.add(input);
            }


            index+=1;
        }

        if (stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}
