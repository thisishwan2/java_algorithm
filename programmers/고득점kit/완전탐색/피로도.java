package programmers.고득점kit.완전탐색;

public class 피로도 {
    static int answer = 0 ;

    public void dfs(int n, int[] visited, int[][] dungeons, int heart, int cnt){
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                int[] dungeon = dungeons[i];
                int need = dungeon[0];
                int spend = dungeon[1];

                if(heart>=need){
                    answer = Math.max(answer, cnt+1);
                    visited[i]=1;
                    dfs(n, visited, dungeons, heart - spend, cnt+1);
                    visited[i]=0;
                }

            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        int[] visited = new int[n];
        dfs(n,visited, dungeons, k, 0);

        return answer;
    }
}
