package programmers.level2;

import java.util.*;

class 연속_부분_수열_합의_개수 {

    static Set<Long> s = new HashSet<>();

    public int solution(int[] elements) {
        long answer = 0;

        for(int i=0; i<elements.length; i++){
            long sum = 0;
            for (int j=i; j<i+elements.length; j++){
                sum+=elements[j%elements.length];
                s.add(sum);
            }
        }
//        System.out.println(s.size());

        return s.size();
    }
}