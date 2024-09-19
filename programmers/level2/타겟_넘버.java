package programmers.level2;

import java.util.*;
class 타겟_넘버 {

    static int answer = 0;
    static int[] sub = new int[]{-1,1};

    static void dfs(List<Integer> tmp, int n, int target, int[] numbers, int start){
        if (tmp.size() == n){
            int sum = 0;
            for(int num:tmp){
                sum+=num;
            }

            if (sum == target){
                answer+=1;
            }
            return;
        }

        for(int i=0; i<2; i++){
            tmp.add(sub[i]*numbers[start]);
            dfs(tmp, n, target, numbers, start+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public int solution(int[] numbers, int target) {
        List<Integer> tmp = new ArrayList<>();
        int n = numbers.length;
        dfs(tmp, n, target, numbers,0);
        return answer;
    }
}