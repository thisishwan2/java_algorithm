package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_2206 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++){
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        // 벽을 부순지 안부순지 체크하기 위해 3차원 배열 이용
        int[][][] visited = new int[n][m][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1,0}); // x,y,cnt,break_wall
        visited[0][0][0]=1;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            if (poll[0]==n-1 && poll[1]==m-1){
                System.out.println(poll[2]);
                System.exit(0);
            }
            for (int i=0; i<4; i++){
                int nx=poll[0]+dx[i];
                int ny=poll[1]+dy[i];

                if (0<=nx && nx<n && 0<=ny && ny<m){
                    // 벽을 부시는 기회를 사용한 경우
                    if (poll[3]==1){
                        // 방문여부를 파악하고, 빈칸인지를 본다.
                        if (visited[nx][ny][1]==0 && arr[nx][ny]==0){
                            visited[nx][ny][1]=1;
                            q.add(new int[]{nx,ny,poll[2]+1,1});
                        }
                    }

                    // 벽을 부시는 기회를 쓰지 않은 경우
                    else if(poll[3]==0){

                        // 다음 칸이 벽인 경우
                        if (arr[nx][ny]==1 && visited[nx][ny][1]==0){
                            visited[nx][ny][1]=1;
                            q.add(new int[]{nx,ny,poll[2]+1,1});
                        }

                        // 다음 칸이 벽이 아닌 경우
                        else if (arr[nx][ny]==0 && visited[nx][ny][0]==0){
                            visited[nx][ny][0]=1;
                            q.add(new int[]{nx,ny,poll[2]+1,0});
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
