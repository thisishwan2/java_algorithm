package programmers.고득점kit.깊이_너비_우선탐색;

public class 네트워크 {
    int[] visited ;

    public void dfs(int[][] computers, int now){
        int computer[] = computers[now];

        for(int j=0; j<computer.length; j++){
            if(j!=now && visited[j]==0 && computer[j]==1){
                visited[j]=1;
                dfs(computers, j);
            }
        }

    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        // start node를 0~n까지 바꿔가면서 dfs 탐색
        // 단 그 과정에서 방문 안한 경우만 처리
        for(int i=0; i<computers.length; i++){
            if(visited[i]==0){
                answer+=1;
                visited[i]=1;
                dfs(computers, i);
            }
        }


        return answer;
    }
}
