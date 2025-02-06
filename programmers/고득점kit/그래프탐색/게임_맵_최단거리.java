package programmers.고득점kit.그래프탐색;
import java.util.*;
public class 게임_맵_최단거리 {
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};

    public int solution(int[][] maps) {
        int answer = 0;

        int n=maps.length;
        int m=maps[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        int[][] visited = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0]=1;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<n && 0<=ny && ny<m){
                    if(maps[nx][ny]==1 && visited[nx][ny]>visited[x][y]+1){
                        visited[nx][ny]=visited[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }

        if (visited[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }else{
            return visited[n-1][m-1];
        }
    }

    public static void main(String[] args) {
        게임_맵_최단거리 test = new 게임_맵_최단거리();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(test.solution(maps));
    }
}
