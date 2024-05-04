package programmers.level1;

import java.util.*;

public class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 10000;

        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> list = Arrays.asList(a, b, c, d);
        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), 1);
            } else {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            }
        }

//        System.out.println(map);
//
        if (map.size() == 1) { // 4개가 모두 같으면
            answer = 1111 * a;
        } else if (map.size() == 2) { // map에 2개만 있으면 같은 주사위 2개인 경우와 세 주사위가 같고 나머지 하나가 다른 경우
            Iterator<Integer> iterator = map.keySet().iterator();
            Integer next = iterator.next();
            if (map.get(next) == 2) { // 2개씩 있는 경우
                int nnext = iterator.next();
                if (next >= nnext) {
                    answer = (next + nnext) * (next - nnext);
                } else {
                    answer = (next + nnext) * (next - nnext) * -1;
                }
            } else {
                int nnext = iterator.next();

                if (map.get(next) == 1) {
                    answer = (10 * nnext + next) * (10 * nnext + next);
                } else {
                    answer = (10 * next + nnext) * (10 * next + nnext);
                }
            }
        } else if (map.size() == 3) {
            Iterator<Integer> iterator = map.keySet().iterator();
            Integer next = iterator.next();
            Integer nnext = iterator.next();
            Integer nnnext = iterator.next();

            if (map.get(next) == 2) {
                answer = nnext * nnnext;
            } else if (map.get(nnext) == 2) {
                answer = next * nnnext;
            } else if (map.get(nnnext) == 2) {
                answer = next * nnext;
            }
        }
        else{
            answer = Math.min(answer,a);
            answer = Math.min(answer,b);
            answer = Math.min(answer,c);
            answer = Math.min(answer,d);
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6,4,2,3);
    }
}
