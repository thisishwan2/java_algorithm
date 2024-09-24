package programmers.level3;

import java.util.*;
class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        List<List<Integer>> list = new ArrayList<>();
        // 인접행렬 생성
        for(int i=0; i<n; i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j]==1) {
                    tmp.add(j);
                }
            }
            list.add(tmp);
        }

        // 0~n-1까지 탐색
        int[] visited = new int[n];
        for(int i=0; i<n; i++){

            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            answer+=1;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            while (!q.isEmpty()){
                int next = q.poll();
                List<Integer> nextList = list.get(next);

                for (int node: nextList){
                    if (visited[node]==0){
                        q.add(node);
                        visited[node]=1;
                    }
                }
            }
        }

        return answer;
    }
}