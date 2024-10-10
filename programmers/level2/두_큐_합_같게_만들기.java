package programmers.level2;

import java.util.*;
class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;

        // 무식하게 합이 작은 큐에 원소를 옮긴다.?(선입선출이니)
        // 큐의 전체 합을 구한다음 반으로 쪼갠다.(long)

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;

        long total = 0;
        for (int i=0; i<queue1.length; i++){
            total+=queue1[i];
            q1.add(queue1[i]);
            q1Sum+=queue1[i];
            total+=queue2[i];
            q2.add(queue2[i]);
            q2Sum+=queue2[i];
        }

        long half = total/2;

        int n = queue1.length;
        int turn = 0;
        while (turn<=4*n){ // 범위가 2n이 아니라 더 q1 q2 를 2번 돌 수 있음
            if (q1Sum==q2Sum){ // 두 큐의 합이 같으면 return
                return turn;
            }
            else if(q1Sum>q2Sum){ // q1이 크면
                int num = q1.poll();
                q1Sum-=num;
                q2Sum+=num;
                q2.add(num);
            }
            else if(q1Sum<q2Sum){ // q2가 크면
                int num = q2.poll();
                q2Sum-=num;
                q1Sum+=num;
                q1.add(num);
            }

            turn+=1;
        }


        return -1;
    }
}
