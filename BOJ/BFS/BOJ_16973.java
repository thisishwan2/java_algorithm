package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16973 {

    static int N,M,K;
    static int[][] map;
    static int[][] cycle;
    static int min = Integer.MAX_VALUE;
    // arr에는 회전(cycle)의 인덱스만 있음
    public static void dfs(int cnt, int[] arr, boolean[] visited){
        if(cnt == K) {
            doCycle(arr);
            return;
        }
        for(int i=0; i<K; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[cnt] = i;
            dfs(cnt+1, arr, visited);
            visited[i] = false;
        }
    }

    public static int[][] copyArr(){
        int[][] newArr = new int[N][M];

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                newArr[n][m] = map[n][m];
            }
        }
        return newArr;
    }

    public static void getAnswer(int[][] tmp) {
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=0; j<M; j++) {
                sum += tmp[i][j];
            }
            if(min > sum) min = sum;
        }
    }

    public static void doCycle(int[] arr){
        int [][] tmp = copyArr();

        for (int k=0; k<K; k++){
            int r = cycle[arr[k]][0];
            int c = cycle[arr[k]][1];
            int S = cycle[arr[k]][2];

            for (int s=1; s<=S; s++){
                // 위
                int upTmp = tmp[r-s][c+s];
                for (int y = c+s; y>c-s; y--){
                    tmp[r-s][y] = tmp[r-s][y-1];
                }

                // 오른쪽
                int rightTmp = tmp[r+s][c+s];
                for (int x = r+s; x>r-s; x--){
                    tmp[x][c+s] = tmp[x-1][c+s];
                }
                tmp[r-s+1][c+s] = upTmp;

                // 아래
                int leftTmp = tmp[r+s][c-s];
                for (int y = c-s; y<c+s; y++){
                    tmp[r+s][y] = tmp[r+s][y+1];
                }
                tmp[r+s][c+s-1] = rightTmp;

                // 왼쪽
                for (int x = r-s; x<r+s; x++){
                    tmp[x][c-s] = tmp[x+1][c-s];
                }
                tmp[r+s-1][c-s] = leftTmp;
            }
        }

        getAnswer(tmp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];

        for (int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            cycle[k][0] = Integer.parseInt(st.nextToken())-1;
            cycle[k][1] = Integer.parseInt(st.nextToken())-1;
            cycle[k][2] = Integer.parseInt(st.nextToken());
        }

        dfs(0 , new int[K], new boolean[K]);
        System.out.println(min);
    }
}
