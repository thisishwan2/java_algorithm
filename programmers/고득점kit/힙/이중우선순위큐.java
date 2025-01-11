package programmers.고득점kit.힙;

import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        PriorityQueue<Integer> minq = new PriorityQueue<>(); // 최소 힙

        for(int i=0; i<operations.length; i++){
            String[] s = operations[i].split(" ");

            if (s[0].equals("I")){
                maxq.add(Integer.valueOf(s[1]));
                minq.add(Integer.valueOf(s[1]));
            }else{
                // poll()은 비어있으면 null 반환.
                if (s[1].equals("1") && !maxq.isEmpty()){
                    minq.remove(maxq.poll());
                }
                else if(s[1].equals("-1") && !minq.isEmpty()) {
                    maxq.remove(minq.poll());
                }
            }
        }

        int max = maxq.isEmpty() ? 0 : maxq.peek();
        int min = minq.isEmpty() ? 0 : minq.peek();

        return new int[]{max, min};
    }
}
