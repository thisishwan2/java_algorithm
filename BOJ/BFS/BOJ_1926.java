package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1926 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<m; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int artCount = 0;
        int maxSize = 0;
        int[][] visited = new int[n][m];

        for (int i =0; i<n; i++){
            for (int j =0; j<m; j++){
                if (board[i][j]==1 && visited[i][j]==0){
                    int size = 1;
                    Queue<int[]> q = new LinkedList<>();
                    int[] tmp = {i,j};
                    q.add(tmp);
                    visited[i][j]=1;

                    while (!q.isEmpty()){
                        int[] arr = q.poll();
                        for (int k =0; k<4; k++){
                            int nx = arr[0]+dx[k];
                            int ny = arr[1]+dy[k];

                            if(0<=nx && nx<n && 0<=ny && ny<m){
                                if (visited[nx][ny]==0 && board[nx][ny]==1){
                                    visited[nx][ny]=1;
                                    int[] tmp2 = {nx,ny};
                                    q.add(tmp2);
                                    size+=1;
                                }
                            }
                        }
                    }

                    maxSize = Math.max(size, maxSize);
                    artCount+=1;
                }
            }
        }

        System.out.println(artCount);
        System.out.println(maxSize);
    }
}
