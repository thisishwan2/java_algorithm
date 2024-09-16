package programmers.level2;

import java.util.*;
class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();

        int index = 0;
        int people = 0;
        char prev = ' ';
        for (String word: words){

            if (prev == ' '){

            }else if (set.contains(word) || prev != word.charAt(0)){
                // 이미 말했거나, 시작 단어가 이전 단어의 마지막이 아닌 경우
                int resNum = people+1;
                int turn = index/n;

                return new int[]{resNum, turn+1};
            }

            prev = word.charAt(word.length()-1);
            set.add(word);
            index+=1;
            people=(people+1)%n;
        }

        return new int[]{0, 0};
    }
}