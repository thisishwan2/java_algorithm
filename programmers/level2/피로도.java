package programmers.level2;

import java.util.*;
class 피로도 {

    static int answer = 0;

    static void dfs(int condition, int cnt, int[] visited, int[][] dungeons){
        for (int i=0; i<dungeons.length; i++){
            if (visited[i]==0 && condition>=dungeons[i][0] && condition-dungeons[i][1]>=0){
                visited[i]=1;
                answer = Math.max(answer, cnt+1);
                dfs(condition - dungeons[i][1], cnt+1, visited, dungeons);
                visited[i]=0;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int[] visited = new int[n];
        dfs(k, 0, visited, dungeons);
        return answer;
    }
}