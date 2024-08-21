package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int finishTomato = 0; // 익은 토마토 개수
        int minus = 0;
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토면 큐에 넣는다.
                if (board[i][j]==1){
                    q.add(new int[]{i,j});
                    finishTomato+=1;
                    visited[i][j]=1;
                }

                else if(board[i][j]==-1){
                    minus+=1;
                }
            }
        }

        int time = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int tmp = 0; tmp<size; tmp++) {
                int[] info = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = info[0] + dx[i];
                    int ny = info[1] + dy[i];

                    if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                        if (visited[nx][ny] == 0 && board[nx][ny] == 0) {
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = 1;
                            finishTomato += 1;
                            board[nx][ny]=1;
                        }
                    }
                }
            }
//            for (int[] a : board) {
//                for (int i : a) {
//                    System.out.print(i+" ");
//                }
//                System.out.println();
//
//            }
//            System.out.println("=====");
            time+=1;
        }

        if (finishTomato == n*m-minus){
            System.out.println(time-1);
        }else{
            System.out.println(-1);
        }
    }
}
