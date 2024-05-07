package BOJ.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576 {

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int n;
    static int m;
    static int[][] arr;
    static int date = 0;
    static int notRedCnt = 0; // 익지 않은 토마토

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        n = Integer.parseInt(st.nextToken()); // y
        m = Integer.parseInt(st.nextToken()); // x

        arr = new int[m][n];
        Deque<int[]> q = new LinkedList<>();

        for (int i =0; i<m; i++){
            line = br.readLine();
            st = new StringTokenizer(line, " ");
            for (int j =0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i =0; i<m; i++){
            for (int j =0; j<n; j++){
                if(arr[i][j]==1){
                    q.add(new int[]{i,j});
                }
                if (arr[i][j] == 0){
                    notRedCnt+=1;
                }
            }
        }

        if (notRedCnt == 0){
            System.out.println(0);
            System.exit(0);
        }

        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){

                int[] poll = q.pollFirst();
                int x = poll[0];
                int y = poll[1];

                for (int j =0; j<4; j++){
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (0<=nx && nx<m && 0<=ny && ny<n){
                        if (arr[nx][ny] == 0){
                            q.add(new int[]{nx,ny});
                            arr[nx][ny]=1;
                            notRedCnt-=1;
                        }
                    }
                }
            }
            if(notRedCnt==0){
                System.out.println(date+1);
                System.exit(0);
            }
            date+=1;
        }
        System.out.println(-1);
    }
}
