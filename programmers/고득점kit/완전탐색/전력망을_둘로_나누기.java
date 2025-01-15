package programmers.고득점kit.완전탐색;

import java.util.*;

public class 전력망을_둘로_나누기 {
    public int bfs(int start, List<List<Integer>> lst, int[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int cnt = 1;
        visited[start]=1;

        while(!q.isEmpty()){
            int poll = q.poll();
            List<Integer> tmp = lst.get(poll);
            for(int i=0; i<tmp.size(); i++){
                int next = tmp.get(i);
                if(visited[next]==0){
                    visited[next]=1;
                    cnt+=1;
                    q.add(next);
                }
            }
        }

        return cnt;


    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 인접리스트 생성
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0; i<=n; i++){
            lst.add(new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            lst.get(a).add(b);
            lst.get(b).add(a);
        }

        // 간선하나를 제거하면서 bfs
        for(int[] wire: wires){
            int a = wire[0];
            int b = wire[1];

            lst.get(a).remove(Integer.valueOf(b));
            lst.get(b).remove(Integer.valueOf(a));

            // 한쪽 연결 노드들 탐색
            int[] visited = new int[n+1];
            int a_cnt = bfs(a, lst, visited);

            // 나머지 한쪽
            int b_cnt = n-a_cnt;

            int comapre = Math.max(a_cnt, b_cnt) - Math.min(a_cnt, b_cnt);

            answer = Math.min(answer, comapre);

            lst.get(a).add(b);
            lst.get(b).add(a);
        }
        return answer;
    }
}
